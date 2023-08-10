package com.ashehata.madarsoft_task.modules.sign_up.presentation.viewModel

import com.ashehata.madarsoft_task.base.BaseViewModel
import com.ashehata.madarsoft_task.common.enums.Gender
import com.ashehata.madarsoft_task.modules.sign_up.presentation.contract.SignUpEvent
import com.ashehata.madarsoft_task.modules.sign_up.presentation.contract.SignUpState
import com.ashehata.madarsoft_task.modules.sign_up.presentation.contract.SignUpViewState
import com.ashehata.madarsoft_task.modules.user.domain.model.UserDomainModel
import com.ashehata.madarsoft_task.modules.user.domain.usecase.SetUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val setUserUseCase: SetUserUseCase,
) : BaseViewModel<SignUpEvent, SignUpViewState, SignUpState>() {


    override fun handleEvents(event: SignUpEvent) {
        when (event) {
            SignUpEvent.OnSignUpClicked -> {
                SignUp()
            }
        }
    }


    private fun SignUp() {
        setLoading()
        launchCoroutine {
            setUserUseCase.execute(
                UserDomainModel(
                    viewStates?.email?.text?.value?.trim() ?: "",
                    viewStates?.email?.text?.value ?: "",
                    12,
                    Gender.MALE
                ),
            )
            setDoneLoading()
            setState { SignUpState.OpenRecipesScreen }
        }
    }

    override fun createInitialViewState(): SignUpViewState {
        return SignUpViewState()
    }

}
