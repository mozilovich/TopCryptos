package com.example.topcryptos.presentation.base

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BasePresenter<V: BaseView> {

    protected lateinit var view: V
    private var destroyDisposable = CompositeDisposable()


    open fun onAttach(v: V){
        this.view = v
        attachView()
    }

    open fun onDetach() {}

    open fun onDestroy() {
        if(!destroyDisposable.isDisposed) {
            destroyDisposable.dispose()
        }
    }

    protected open fun attachView() {

    }

    fun Disposable.disposeWhenDestroy() {
        destroyDisposable.add(this)
    }
}