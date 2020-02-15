package com.example.topcryptos.presentation.ui.currencies

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import com.example.topcryptos.R
import com.example.topcryptos.TopCryptosApp
import com.example.topcryptos.presentation.adapter.CurrenciesAdapter
import com.example.topcryptos.presentation.ui.about.AboutFragment
import com.example.topcryptos.presentation.base.BaseFragment
import com.example.topcryptos.presentation.extensions.makeGone
import com.example.topcryptos.presentation.extensions.makeVisible
import com.example.topcryptos.presentation.model.CurrencyModel
import com.example.topcryptos.presentation.ui.currencies.info.CurrencyInfoFragment
import kotlinx.android.synthetic.main.fragment_currencies.*
import kotlinx.android.synthetic.main.layout_retry.*
import javax.inject.Inject

class CurrenciesFragment : BaseFragment(), CurrenciesView {

    companion object {
        fun getInstance() = CurrenciesFragment()
    }

    override val layout: Int = R.layout.fragment_currencies

    @Inject
    lateinit var presenter: CurrenciesPresenter

    var adapter: CurrenciesAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        TopCryptosApp.appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onViewPrepare(view: View, savedInstanceState: Bundle?) {
        super.onViewPrepare(view, savedInstanceState)

        adapter = CurrenciesAdapter().apply {
            onItemClick = {
                presenter.onCurrencyClick(it)
            }
        }
        rv_currencies.adapter = adapter
        rv_currencies.layoutManager = LinearLayoutManager(requireContext())
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.menu_currencies, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            R.id.about -> {
                navigateTo(AboutFragment())
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        presenter.onAttach(this)
    }

    override fun onPause() {
        presenter.onDetach()
        super.onPause()
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    override fun showCurrencies(items: List<CurrencyModel>) {
        adapter?.items = items
    }

    override fun showProgress() {
        progress.makeVisible()
    }

    override fun hideProgress() {
        progress.makeGone()
    }

    override fun navigateCurrencyInfo(model: CurrencyModel) {
        base {
            navigateToScreen(CurrencyInfoFragment.getInstance(model))
        }
    }

    override fun showRetry() {
        progress_error.makeVisible()
        retry.setOnClickListener {
            presenter.onRetry()
        }
    }

    override fun hideRetry() {
        progress_error.makeGone()
    }
}