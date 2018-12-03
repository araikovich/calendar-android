package com.example.tigranchilingarian.android.ui.core

import android.content.Context
import android.view.View
import com.bluelinelabs.conductor.Controller

abstract class BaseController<S : BaseScreen, P : Presenter<S>> : Controller() {

    override fun onContextAvailable(context: Context) {
        super.onContextAvailable(context)
        setupComponent()
        presenter = createPresenter()
        presenter.context = context
    }

    abstract fun setupComponent()

    lateinit var presenter: P

    abstract fun createPresenter(): P

    override fun onAttach(view: View) {
        super.onAttach(view)
        presenter.onAttach(view)
    }

    override fun onDetach(view: View) {
        super.onDetach(view)
        presenter.onDetach(view)
        (activity as BaseActivity).hideKeyboard()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }
}