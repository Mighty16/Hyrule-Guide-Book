package com.vv.core.domain

import kotlinx.coroutines.flow.Flow

interface IHyruleRepository {

    fun getAll():Flow<Try<List<BaseEntryEntity>>>

}