package com.ashehata.madarsoft_task.modules.user.data.local

import com.ashehata.madarsoft_task.modules.user.domain.model.UserDomainModel


interface UserLocalDataSource {
    suspend fun getUser(): UserDomainModel
    suspend fun setUser(user: UserDomainModel)
    suspend fun clearUser()
    suspend fun checkIfUserLoggedIn(): Boolean
}