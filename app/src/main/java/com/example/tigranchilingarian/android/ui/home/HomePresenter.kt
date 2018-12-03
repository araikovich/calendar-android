package com.example.tigranchilingarian.android.ui.home

import com.example.tigranchilingarian.android.data.PreferencesStorage
import com.example.tigranchilingarian.android.di.HomeComponent
import com.example.tigranchilingarian.android.ui.core.ActivityPresenter
import com.example.tigranchilingarian.android.ui.core.BaseScreen
import javax.inject.Inject

class HomePresenter(screen: BaseScreen, component: HomeComponent) : ActivityPresenter<HomePresenter.Screen>(screen) {

    @Inject
    lateinit var preferencesStorage: PreferencesStorage

    init {
        component.inject(this)
    }

    interface Screen : BaseScreen {

    }
}