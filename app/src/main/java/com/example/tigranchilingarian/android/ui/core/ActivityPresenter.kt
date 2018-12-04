package com.example.tigranchilingarian.android.ui.core

import android.content.res.Resources
import android.os.Bundle
import kotlinx.coroutines.Job

abstract class ActivityPresenter<S : BaseScreen>(protected val screen: BaseScreen) {

    protected lateinit var resources: Resources

    var reactiveJob: Job? = null

    open fun onStart() {}

    open fun onCreate(bundle: Bundle?) {}

    open fun onDestroy() {}

    open fun onStop() {
        reactiveJob?.cancel()
    }

    open fun onResume() {}

    open fun onPause() {}

    fun setupResources(resources: Resources) {
        this.resources = resources
    }
}