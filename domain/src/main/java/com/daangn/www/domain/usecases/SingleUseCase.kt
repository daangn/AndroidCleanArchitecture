package com.daangn.www.domain.usecases

import io.reactivex.Single

interface SingleUseCase<Params, Type> {
    fun execute(params: Params?): Single<Type>
}