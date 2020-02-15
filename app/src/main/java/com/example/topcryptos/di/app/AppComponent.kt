package com.example.topcryptos.di.app

import android.app.Application
import com.example.topcryptos.data.DataModule
import com.example.topcryptos.di.AppModule
import com.example.topcryptos.presentation.PresentationModule
import com.example.topcryptos.presentation.util.ChatUiController
import com.example.topcryptos.presentation.ui.MainActivity
import com.example.topcryptos.presentation.ui.about.AboutFragment
import com.example.topcryptos.presentation.ui.currencies.CurrenciesFragment
import com.example.topcryptos.presentation.ui.currencies.info.CurrencyInfoFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, DataModule::class, PresentationModule::class])
interface AppComponent {

    fun inject(application: Application)

    fun inject(activity: MainActivity)

    fun inject(fragment: AboutFragment)

    fun inject(fragment: CurrenciesFragment)

    fun inject(fragment: CurrencyInfoFragment)

    fun inject(controller: ChatUiController)
}