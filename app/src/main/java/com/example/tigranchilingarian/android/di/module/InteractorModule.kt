package com.example.tigranchilingarian.android.di.module

import com.example.tigranchilingarian.android.data.repository.TimeTableRepository
import com.example.tigranchilingarian.android.domain.TimeTableInteractor
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [AppModule::class, StorageModule::class])
class InteractorModule {

    @Singleton
    @Provides
    fun provideTimeTableInteractor(repository: TimeTableRepository) = TimeTableInteractor(repository)
}