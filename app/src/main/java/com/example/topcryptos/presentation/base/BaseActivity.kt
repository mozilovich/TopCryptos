package com.example.topcryptos.presentation.base

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.widget.Toast
import com.example.topcryptos.R

abstract class BaseActivity : AppCompatActivity(), BaseView {

    protected abstract val layout: Int

    protected abstract val containerId: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout)
        onViewPrepare(savedInstanceState)
    }

    protected open fun onViewPrepare(savedInstanceState: Bundle?) {
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }

    override fun onBackPressed() {
        if (!onBackPressedChilds()) {
            super.onBackPressed()
        }
    }

    open fun onBackPressedChilds(): Boolean {
        val fragment = supportFragmentManager.findFragmentById(containerId)
        return if (fragment is BaseFragment) {
            fragment.onBackPressed()
        } else {
            false
        }
    }

    fun navigateToScreen(fragment: BaseFragment) {
        val transaction = supportFragmentManager.beginTransaction().addToBackStack("")
        transaction.replace(containerId, fragment).commit()
    }

    fun addScreen(fragment: BaseFragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(containerId, fragment, null).commit()
    }

    override fun showToast(msg: String) {
        Toast.makeText(applicationContext, msg, Toast.LENGTH_SHORT).show()
    }
}

inline fun Activity.base(block: BaseActivity.() -> Unit) {
    (this as? BaseActivity)?.block()
}