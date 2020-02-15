package com.example.topcryptos.presentation.ui.about

import com.example.topcryptos.presentation.base.BasePresenter
import javax.inject.Inject

class AboutPresenter @Inject constructor(): BasePresenter<AboutView>() {

    override fun attachView() {
        super.attachView()
        view.initAds()
    }
}