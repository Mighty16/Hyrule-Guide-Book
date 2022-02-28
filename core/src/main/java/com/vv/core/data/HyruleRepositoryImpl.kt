package com.vv.core.data

import com.vv.core.domain.BaseEntryEntity
import com.vv.core.domain.IHyruleRepository
import com.vv.core.domain.Try
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class HyruleRepositoryImpl(
    private val hyruleRemoteStore: HyruleRemoteStore,
    private val dispatcher: CoroutineDispatcher,
) : IHyruleRepository {

    override fun getAll(): Flow<Try<List<BaseEntryEntity>>> {
        return flow {
            emit(hyruleRemoteStore.getAll())
        }.flowOn(dispatcher)
    }
}