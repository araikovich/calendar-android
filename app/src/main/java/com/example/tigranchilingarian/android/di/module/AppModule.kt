package com.example.tigranchilingarian.android.di.module

import android.content.Context
import com.example.tigranchilingarian.android.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val app: App) {

    @Provides
    @Singleton
    fun provideApp() = app

    @Provides
    @Singleton
    fun provideContext(): Context = app
}