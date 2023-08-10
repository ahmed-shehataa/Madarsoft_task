package com.ashehata.madarsoft_task.modules.sign_up.presentation.contract

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.ashehata.madarsoft_task.base.BaseEvent
import com.ashehata.madarsoft_task.base.BaseState
import com.ashehata.madarsoft_task.base.BaseViewState
import com.ashehata.madarsoft_task.common.enums.Gender
import com.ashehata.madarsoft_task.common.presentation.InputWrapper
import com.ashehata.madarsoft_task.common.presentation.ValidationType

sealed class SignUpEvent : BaseEvent {
    object OnSignUpClicked : SignUpEvent()
}

sealed class SignUpState : BaseState {
    object OpenRecipesScreen : SignUpState()
}

data class SignUpViewState(
    override val isRefreshing: MutableState<Boolean> = mutableStateOf(false),
    override val isNetworkError: MutableState<Boolean> = mutableStateOf(false),
    override val isLoading: MutableState<Boolean> = mutableStateOf(false),
    val userName: InputWrapper = InputWrapper(validationType = ValidationType.Text),
    val jobTitle: InputWrapper = InputWrapper(validationType = ValidationType.Text),
    val age: InputWrapper = InputWrapper(validationType = ValidationType.Age),
    val gender: MutableState<Gender> = mutableStateOf(Gender.MALE),
) : BaseViewState