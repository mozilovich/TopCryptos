package com.example.topcryptos

import android.app.Application
import android.content.Context
import android.support.multidex.MultiDex
import com.example.topcryptos.data.DataModule
import com.example.topcryptos.di.AppModule
import com.example.topcryptos.di.app.AppComponent
import com.example.topcryptos.di.app.DaggerAppComponent
import com.example.topcryptos.presentation.PresentationModule
import com.google.android.gms.ads.MobileAds

class TopCryptosApp: Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()
        initDagger()
    }

    private fun initDagger() {
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }
}