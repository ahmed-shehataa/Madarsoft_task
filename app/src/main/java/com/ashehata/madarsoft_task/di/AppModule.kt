package com.ashehata.madarsoft_task.di

import android.app.Application
import com.ashehata.madarsoft_task.database.datastore.AppDataStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideDataStore(
        application: Application,
    ): AppDataStore {
        return AppDataStore(application)
    }

}