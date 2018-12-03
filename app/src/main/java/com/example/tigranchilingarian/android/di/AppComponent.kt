package com.example.tigranchilingarian.android.di

import com.example.tigranchilingarian.android.App
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class,
    StorageModule::class,
    NetworkModule::class])
interface AppComponent {

    fun inject(app: App)

    fun plus(module: HomeScreenModule): HomeComponent
}