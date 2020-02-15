package com.example.topcryptos.presentation.ui

import android.os.Bundle
import com.example.topcryptos.R
import com.example.topcryptos.TopCryptosApp
import com.example.topcryptos.presentation.base.BaseActivity
import com.example.topcryptos.presentation.ui.currencies.CurrenciesFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity() {

    override val layout: Int get() = R.layout.activity_main

    override val containerId: Int get() = R.id.container_main

    override fun onViewPrepare(savedInstanceState: Bundle?) {
        TopCryptosApp.appComponent.inject(this)
        super.onViewPrepare(savedInstanceState)
        setSupportActionBar(toolbar)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_back)

        if(savedInstanceState == null) {
            addScreen(CurrenciesFragment.getInstance())
        }
    }
}
