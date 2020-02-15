package com.example.topcryptos.presentation.base

import android.app.Activity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

abstract class BaseFragment : Fragment(), BaseView {

    protected abstract val layout: Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setBackArrowIfNeed()
        onViewPrepare(view, savedInstanceState)
    }

    protected open fun onViewPrepare(view: View, savedInstanceState: Bundle?) {
    }

    open fun onBackPressed(): Boolean {
        return false
    }

    protected fun navigateTo(fragment: BaseFragment) {
        base {
            navigateToScreen(fragment)
        }
    }

    private fun setBackArrowIfNeed() {
        base {
            supportActionBar?.setDisplayHomeAsUpEnabled(supportFragmentManager?.backStackEntryCount ?: 0 > 0)
        }
    }

    inline fun base(block: BaseActivity.() -> Unit) {
        activity?.base(block)
    }

    override fun showToast(msg: String) {
        Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
    }
}