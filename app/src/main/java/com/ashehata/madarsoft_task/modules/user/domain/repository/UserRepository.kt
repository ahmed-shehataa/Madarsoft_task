package com.ashehata.madarsoft_task.modules.user.domain.repository

import com.ashehata.madarsoft_task.modules.user.domain.model.UserDomainModel


interface UserRepository {
    suspend fun getUser(): UserDomainModel
    suspend fun setUser(user: UserDomainModel)
    suspend fun logoutUser()
    suspend fun checkIfUserLoggedIn(): Boolean
}
