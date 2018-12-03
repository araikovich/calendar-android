package com.example.tigranchilingarian.android.di

import android.content.Context
import com.example.tigranchilingarian.android.data.PreferencesStorage
import com.example.tigranchilingarian.android.data.PreferencesStorageImpl
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [AppModule::class])
class StorageModule {

    @Singleton
    @Provides
    fun providesPreferencesStorage(context: Context, gson: Gson): PreferencesStorage = PreferencesStorageImpl(context, gson)
}