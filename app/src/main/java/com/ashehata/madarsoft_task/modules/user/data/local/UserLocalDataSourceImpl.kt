package com.ashehata.madarsoft_task.modules.user.data.local


import com.ashehata.madarsoft_task.modules.user.domain.model.UserDomainModel
import com.ashehata.madarsoft_task.database.datastore.AppDataStore
import javax.inject.Inject


class UserLocalDataSourceImpl @Inject constructor(
    private val appDataStore: AppDataStore
) : UserLocalDataSource {

    override suspend fun getUser(): UserDomainModel {
        return appDataStore.getUser()
    }

    override suspend fun setUser(user: UserDomainModel) {
        appDataStore.setUser(user)
    }

    override suspend fun clearUser() {
        appDataStore.clearUser()
    }

    override suspend fun checkIfUserLoggedIn(): Boolean {
        return appDataStore.getIsLoggedIn()
    }

}
