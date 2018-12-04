package com.example.tigranchilingarian.android.di.component

import com.example.tigranchilingarian.android.App
import com.example.tigranchilingarian.android.di.module.*
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class,
    StorageModule::class,
    NetworkModule::class,
    TimeTableStorageModule::class,
    InteractorModule::class])
interface AppComponent {

    fun inject(app: App)

    fun plus(module: HomeScreenModule): HomeComponent
}