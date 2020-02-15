package com.example.topcryptos.di

import android.app.Application
import android.content.Context
import com.example.topcryptos.TopCryptosApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val app: Application) {

    @Provides
    @Singleton
    fun provideContext(): Context {
        return app.applicationContext
    }
}