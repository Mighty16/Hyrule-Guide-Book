package com.vv.core.domain

sealed class Try<out T>{

    fun <P> transform(transform: (T)->Try<P>):Try<P>{
        return when (this){
            is Success -> transform(this.value)
            is Failure -> Failure(this.error)
        }
    }

    data class Success<out R>(val value:R): Try<R>()
    data class Failure<out T>(val error: AppError): Try<T>()

}
