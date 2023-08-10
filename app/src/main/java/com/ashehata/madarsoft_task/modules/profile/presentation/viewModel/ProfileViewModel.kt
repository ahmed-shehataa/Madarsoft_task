package com.ashehata.madarsoft_task.modules.profile.presentation.viewModel

import com.ashehata.madarsoft_task.base.BaseViewModel
import com.ashehata.madarsoft_task.modules.profile.presentation.contract.ProfileEvent
import com.ashehata.madarsoft_task.modules.profile.presentation.contract.ProfileState
import com.ashehata.madarsoft_task.modules.profile.presentation.contract.ProfileViewState
import com.ashehata.madarsoft_task.modules.user.domain.usecase.GetUserUseCase
import com.ashehata.madarsoft_task.modules.user.domain.usecase.LogOutUserUseCase
import com.ashehata.madarsoft_task.modules.user.presentaion.mapper.toUIModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val getUserUseCase: GetUserUseCase,
    private val logOutUserUseCase: LogOutUserUseCase,
) : BaseViewModel<ProfileEvent, ProfileViewState, ProfileState>() {


    init {
        launchCoroutine {
            viewStates?.user?.value = getUserUseCase.execute().toUIModel()
        }
    }

    override fun handleEvents(event: ProfileEvent) {
        when (event) {
            ProfileEvent.OnLogoutClicked -> {
                logout()
            }
        }
    }


    private fun logout() {
        setLoading()
        launchCoroutine {
            logOutUserUseCase.execute()
            setDoneLoading()
            setState { ProfileState.OpenSignUpScreen }
        }
    }

    override fun createInitialViewState(): ProfileViewState {
        return ProfileViewState()
    }

}
