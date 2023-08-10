package com.ashehata.madarsoft_task.modules.user.domain.usecase

import com.ashehata.madarsoft_task.modules.user.domain.model.UserDomainModel
import com.ashehata.madarsoft_task.modules.user.domain.repository.UserRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetUserUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend fun execute(): UserDomainModel {
        return userRepository.getUser()
    }
}
