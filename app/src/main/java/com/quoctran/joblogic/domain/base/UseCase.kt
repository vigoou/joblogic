package com.quoctran.joblogic.domain.base

import kotlinx.coroutines.*

abstract class UseCase<out Type, in Params> where Type : Any {

    abstract suspend fun run(params: Params): Type

    suspend operator fun invoke(
        params: Params,
        onResult: ( Type) -> Unit = {}
    ) {
        withContext(Dispatchers.IO){
            val deferred = async(Dispatchers.IO) {
                run(params)
            }
            onResult(deferred.await())
        }
    }

    class None
}