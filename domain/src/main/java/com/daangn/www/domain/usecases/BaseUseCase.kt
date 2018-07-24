package com.daangn.www.domain.usecases

import io.reactivex.Observable
import io.reactivex.ObservableTransformer

abstract class BaseUseCase<Type, in Params>(private val transformer: ObservableTransformer<Type, Type>) {
    abstract fun createObservable(params: Params?): Observable<Type>

    fun observable(params: Params? = null): Observable<Type> {
        return createObservable(params).compose(transformer)
    }
}