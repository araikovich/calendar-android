package com.example.tigranchilingarian.android.ui.core

import android.content.Context
import android.content.res.Resources
import android.view.View
import kotlinx.coroutines.Job

abstract class Presenter<S : BaseScreen>(var screen: S) {

    lateinit var context: Context

    protected lateinit var resources: Resources

    private var job: Job? = null

    open fun onAttach(view: View) {
        resources = view.resources
    }

    open fun onDetach(view: View) {
        job?.cancel()
    }

    open fun onDestroy() {

    }
}