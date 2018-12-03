package com.example.tigranchilingarian.android.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [AppModule::class])
class NetworkModule {

    @Singleton
    @Provides
    fun providesGson(): Gson = GsonBuilder().create()
}