package com.vv.core.data.network.errors

import com.vv.core.domain.AppError

data class ApiError(val httpCode:Int,
                    val message:String):AppError()