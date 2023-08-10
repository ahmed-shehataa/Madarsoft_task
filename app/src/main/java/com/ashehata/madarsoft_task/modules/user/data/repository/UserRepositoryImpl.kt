package com.ashehata.madarsoft_task.modules.user.data.repository

import com.ashehata.madarsoft_task.modules.user.data.local.UserLocalDataSource
import com.ashehata.madarsoft_task.modules.user.domain.model.UserDomainModel
import com.ashehata.madarsoft_task.modules.user.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userLocalDataSource: UserLocalDataSource,
) : UserRepository {

    override suspend fun getUser(): UserDomainModel {
        return userLocalDataSource.getUser()
    }

    override suspend fun setUser(user: UserDomainModel) {
        return userLocalDataSource.setUser(user)
    }

    override suspend fun logoutUser() {
        return userLocalDataSource.clearUser()
    }

    override suspend fun checkIfUserLoggedIn(): Boolean {
        return userLocalDataSource.checkIfUserLoggedIn()
    }

}
