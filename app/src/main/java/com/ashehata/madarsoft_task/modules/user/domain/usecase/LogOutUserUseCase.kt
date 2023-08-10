package com.ashehata.madarsoft_task.modules.user.domain.usecase

import com.ashehata.madarsoft_task.modules.user.domain.repository.UserRepository
import javax.inject.Inject

class LogOutUserUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend fun execute() {
        userRepository.logoutUser()
    }
}
