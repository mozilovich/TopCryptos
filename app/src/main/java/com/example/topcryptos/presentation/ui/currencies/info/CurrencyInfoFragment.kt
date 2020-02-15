package com.example.topcryptos.presentation.ui.currencies.info

import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.example.topcryptos.R
import com.example.topcryptos.TopCryptosApp
import com.example.topcryptos.presentation.base.BaseFragment
import com.example.topcryptos.presentation.extensions.formatWithDecimalsPlaces
import com.example.topcryptos.presentation.extensions.makeGone
import com.example.topcryptos.presentation.extensions.makeVisible
import com.example.topcryptos.presentation.model.CurrencyModel
import com.example.topcryptos.presentation.util.ChatUiController
import kotlinx.android.synthetic.main.fragment_currency_info.*
import kotlinx.android.synthetic.main.layout_retry.*
import java.lang.IllegalArgumentException
import javax.inject.Inject

class CurrencyInfoFragment: BaseFragment(), CurrencyInfoView {

    companion object {
        private const val KEY_CURRENCY = "KEY_CURRENCY"

        fun getInstance(model: CurrencyModel) = CurrencyInfoFragment().also {
            it.arguments = Bundle().apply {
                putSerializable(KEY_CURRENCY, model)
            }
        }
    }

    override val layout: Int = R.layout.fragment_currency_info

    @Inject
    lateinit var chatController: ChatUiController

    @Inject
    lateinit var presenter: CurrencyInfoPresenter

    private fun getCurrencyModel(): CurrencyModel = (arguments?.get(KEY_CURRENCY) as? CurrencyModel)
            ?: throw IllegalArgumentException("currency model is null")

    override fun onCreate(savedInstanceState: Bundle?) {
        TopCryptosApp.appComponent.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onViewPrepare(view: View, savedInstanceState: Bundle?) {
        super.onViewPrepare(view, savedInstanceState)

        chatController.initChart(chat_currency)
    }

    override fun showProgress() {
        progress_chart.makeVisible()
    }

    override fun hideProgress() {
        progress_chart.makeGone()
    }

    override fun addChartEntry(value: Float, date: Float) {
        chatController.addEntry(value, date)
    }

    override fun onResume() {
        super.onResume()
        presenter.onAttach(this, getCurrencyModel())
    }

    override fun onPause() {
        presenter.onDetach()
        super.onPause()
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    override fun showRetry() {
        progress_chart_error.makeVisible()
        retry.setOnClickListener {
            presenter.onRetry()
        }
    }

    override fun hideRetry() {
        progress_chart_error.makeGone()
    }

    override fun showCurrencyInfo(model: CurrencyModel) {
        Glide.with(requireContext()).load(model.image).into(iv_currency_info)

        tv_market_cap.text = model.marketCapRank.toString()
        tv_market_cap_change.text = model.marketCapChangePercentage24h.toString()
        tv_ath.text = model.ath.toString()
        tv_ath_change.text = model.athChangePercentage.formatWithDecimalsPlaces(2)
        tv_circulating_supply.text = model.circulatingSupply.formatWithDecimalsPlaces(2)
        tv_total_supply.text = model.totalSupply.toString()
    }
}