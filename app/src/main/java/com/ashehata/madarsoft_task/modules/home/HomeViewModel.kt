package com.ashehata.madarsoft_task.modules.home

import com.ashehata.madarsoft_task.modules.user.domain.usecase.CheckUserIsLoggedInUseCase
import com.ashehata.madarsoft_task.base.BaseEvent
import com.ashehata.madarsoft_task.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val checkUserIsLoggedInUseCase: CheckUserIsLoggedInUseCase,
) : BaseViewModel<BaseEvent, HomeViewState, HomeState>() {


    init {
        launchCoroutine {
            val isLoggedIn = checkUserIsLoggedInUseCase.execute()
            setState {
                if (isLoggedIn) {
                    HomeState.OpenProfileScreen
                } else HomeState.OpenSignUpScreen
            }
        }
    }

    override fun handleEvents(event: BaseEvent) {

    }

    override fun createInitialViewState(): HomeViewState {
        return HomeViewState()
    }

}
