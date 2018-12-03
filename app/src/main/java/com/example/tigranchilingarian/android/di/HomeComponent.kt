package com.example.tigranchilingarian.android.di

import com.example.tigranchilingarian.android.ui.home.HomeActivity
import com.example.tigranchilingarian.android.ui.home.HomePresenter
import dagger.Subcomponent

@Subcomponent(modules = [HomeScreenModule::class])
interface HomeComponent {

    fun plus(activity: HomeActivity)

    fun inject(presenter: HomePresenter)
}