package com.example.topcryptos.presentation.rx

import io.reactivex.Completable
import io.reactivex.CompletableSource
import io.reactivex.CompletableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PresentationCompletableTransformer: CompletableTransformer {

    override fun apply(upstream: Completable): CompletableSource {
        return upstream
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
    }
}