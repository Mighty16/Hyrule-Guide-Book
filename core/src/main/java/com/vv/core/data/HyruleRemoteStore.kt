package com.vv.core.data

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.vv.core.data.network.errors.ApiError
import com.vv.core.data.network.errors.NetworkError
import com.vv.core.data.network.api_models.ApiResponseModel
import com.vv.core.data.network.retrofit.HyruleRetrofitInterface
import com.vv.core.data.network.toEntity
import com.vv.core.domain.BaseEntryEntity
import com.vv.core.domain.UnknownError
import com.vv.core.domain.Try
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.HttpException
import retrofit2.Retrofit
import java.io.IOException

class HyruleRemoteStore(private val dispatcher: CoroutineDispatcher) {

    private val retrofitService = Retrofit.Builder()
        .baseUrl("https://botw-compendium.herokuapp.com/api/v2")
        .addConverterFactory(Json.asConverterFactory(MediaType.get("application/json")))
        .build()
        .create(HyruleRetrofitInterface::class.java)

    suspend fun getAll(): Try<List<BaseEntryEntity>> {
        return safeApiCall(dispatcher) {
            retrofitService.getAll()
        }.transform { model ->
            Try.Success(model.mapNotNull { it.toEntity() })
        }
    }

    suspend fun getEntry(idOrName: String): Try<BaseEntryEntity> {
        return safeApiCall(dispatcher) {
            retrofitService.getEntry(idOrName = idOrName)
        }.transform {
            val entity = it.toEntity()
            if (entity != null) {
                Try.Success(entity)
            } else {
                Try.Failure(UnknownError)
            }
        }
    }

    private suspend fun <T> safeApiCall(
        dispatcher: CoroutineDispatcher,
        apiCall: suspend () -> ApiResponseModel<T>
    ): Try<T> {
        return withContext(dispatcher) {
            try {
                val response = apiCall.invoke()
                if (response.message.isNullOrEmpty()) {
                    Try.Success(value = response.data)
                } else {
                    Try.Failure(ApiError(httpCode = 200, message = response.message))
                }
            } catch (throwable: Throwable) {
                when (throwable) {
                    is IOException -> Try.Failure(error = NetworkError)
                    is HttpException -> Try.Failure(error = getApiError(throwable))
                    else -> Try.Failure(error = UnknownError)
                }
            }
        }
    }

    private fun getApiError(throwable: HttpException): ApiError {
        return try {
            val code = throwable.code()
            ApiError(httpCode = code, message = "")
        } catch (ex: Exception) {
            ApiError(httpCode = 0, message = "Error while parsing server error body")
        }
    }

}