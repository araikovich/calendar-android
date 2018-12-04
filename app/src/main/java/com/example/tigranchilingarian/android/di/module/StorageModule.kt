package com.example.tigranchilingarian.android.di.module

import android.content.Context
import androidx.room.Room
import com.example.tigranchilingarian.android.data.repository.TimeTableRepository
import com.example.tigranchilingarian.android.data.repository.impl.TimeTableRepositoryImpl
import com.example.tigranchilingarian.android.data.storage.PreferencesStorage
import com.example.tigranchilingarian.android.data.storage.TimeTableDataBase
import com.example.tigranchilingarian.android.data.storage.TimeTableStorage
import com.example.tigranchilingarian.android.data.storage.impl.PreferencesStorageImpl
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

const val CALENDAR_DATABASE = "CALENDAR_DATABASE"
const val CALENDAR_VERSION = 1

@Module(includes = [AppModule::class, TimeTableStorageModule::class])
class StorageModule {

    @Singleton
    @Provides
    fun provideRoom(context: Context): TimeTableDataBase = Room.databaseBuilder(
            context.applicationContext,
            TimeTableDataBase::class.java,
            CALENDAR_DATABASE
    ).fallbackToDestructiveMigration().build()

    @Singleton
    @Provides
    fun providesPreferencesStorage(context: Context, gson: Gson): PreferencesStorage = PreferencesStorageImpl(context, gson)

    @Singleton
    @Provides
    fun provideTimeTableRepositoty(localDataSource: TimeTableStorage): TimeTableRepository = TimeTableRepositoryImpl(localDataSource)
}