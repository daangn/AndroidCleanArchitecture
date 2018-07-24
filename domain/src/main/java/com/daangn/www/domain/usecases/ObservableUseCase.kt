package com.daangn.www.domain.usecases

import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import io.reactivex.Single

interface ObservableUseCase {
    fun <Params, Type> execute(params: Params?): Observable<Type>
}