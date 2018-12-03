package com.example.tigranchilingarian.android

import android.app.Application
import com.example.tigranchilingarian.android.di.AppComponent
import com.example.tigranchilingarian.android.di.AppModule
import com.example.tigranchilingarian.android.di.DaggerAppComponent

class App : Application() {

    val appModule by lazy { AppModule(this) }

    val component: AppComponent by lazy {
        DaggerAppComponent.builder()
                .appModule(appModule)
                .build()
    }

    override fun onCreate() {
        super.onCreate()
        component.inject(this)
    }
}