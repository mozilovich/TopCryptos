package com.example.topcryptos.presentation.ui.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.topcryptos.R
import com.example.topcryptos.TopCryptosApp
import com.example.topcryptos.presentation.base.BaseFragment
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import kotlinx.android.synthetic.main.fragment_about.*
import javax.inject.Inject

class AboutFragment : BaseFragment(), AboutView {

    override val layout: Int = R.layout.fragment_about

    @Inject
    lateinit var presenter: AboutPresenter

    private lateinit var interstitialAd: InterstitialAd

    override fun onCreate(savedInstanceState: Bundle?) {
        TopCryptosApp.appComponent.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_about, container, false)
    }

    override fun onBackPressed(): Boolean {
        if(interstitialAd.isLoaded) {
            interstitialAd.show()
        }
        return super.onBackPressed()
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

    override fun initAds() {
        ad_view.loadAd(AdRequest.Builder().build())

        interstitialAd = InterstitialAd(requireContext()).apply {
            adUnitId = "ca-app-pub-9396209373050640/8053105793"
            loadAd(AdRequest.Builder().build())
        }
    }
}