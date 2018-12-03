package com.example.tigranchilingarian.android.ui.core

import android.os.Bundle

abstract class BaseActivityWithPresenter<S : BaseScreen, P : ActivityPresenter<S>> : BaseActivity(), BaseScreen {

    lateinit var presenter: P

    abstract fun createPresenter(): P

    override fun onCreate(savedInstanceState: Bundle?) {
        presenter = createPresenter()
        super.onCreate(savedInstanceState)
        presenter.setupResources(resources)
        presenter.onCreate(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        presenter.onStart()
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun onPause() {
        super.onPause()
        presenter.onPause()
    }

    override fun onStop() {
        super.onStop()
        presenter.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun activity(): BaseActivity = this
}