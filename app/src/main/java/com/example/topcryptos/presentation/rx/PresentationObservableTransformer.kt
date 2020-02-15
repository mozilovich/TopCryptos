package com.example.topcryptos.presentation.rx

import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PresentationObservableTransformer<T> : ObservableTransformer<T, T> {

    override fun apply(upstream: Observable<T>): ObservableSource<T> {
        return upstream
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
    }
}