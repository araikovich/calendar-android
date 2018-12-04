package com.example.tigranchilingarian.android

import android.app.Application
import com.example.tigranchilingarian.android.di.component.AppComponent
import com.example.tigranchilingarian.android.di.component.DaggerAppComponent
import com.example.tigranchilingarian.android.di.module.AppModule

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