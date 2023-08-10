package com.ashehata.madarsoft_task.modules.user.di

import com.ashehata.madarsoft_task.modules.user.data.local.UserLocalDataSource
import com.ashehata.madarsoft_task.modules.user.data.local.UserLocalDataSourceImpl
import com.ashehata.madarsoft_task.modules.user.data.repository.UserRepositoryImpl
import com.ashehata.madarsoft_task.modules.user.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class UserModule {

    @Singleton
    @Binds
    abstract fun bindsUserRepo(userRepositoryImpl: UserRepositoryImpl): UserRepository


    @Singleton
    @Binds
    abstract fun bindsUserLocalDataSourceImpl(userLocalDataSourceImpl: UserLocalDataSourceImpl): UserLocalDataSource

}