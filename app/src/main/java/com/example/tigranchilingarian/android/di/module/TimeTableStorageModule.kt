package com.example.tigranchilingarian.android.di.module

import com.example.tigranchilingarian.android.data.storage.TimeTableDataBase
import com.example.tigranchilingarian.android.data.storage.TimeTableStorage
import com.example.tigranchilingarian.android.data.storage.local.TimeTableLocalStorage
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [AppModule::class])
class TimeTableStorageModule {

    @Singleton
    @Provides
    fun provideTimeTableLocalDataSource(db: TimeTableDataBase): TimeTableStorage = TimeTableLocalStorage(db)
}