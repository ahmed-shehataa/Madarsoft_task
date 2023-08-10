package com.ashehata.madarsoft_task.modules.profile.presentation.contract

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.ashehata.madarsoft_task.base.BaseEvent
import com.ashehata.madarsoft_task.base.BaseState
import com.ashehata.madarsoft_task.base.BaseViewState
import com.ashehata.madarsoft_task.modules.user.presentaion.model.UserUIModel


sealed class ProfileEvent : BaseEvent {
    object OnLogoutClicked : ProfileEvent()
}
sealed class ProfileState : BaseState {
    object OpenSignUpScreen : ProfileState()
}

data class ProfileViewState(
    override val isRefreshing: MutableState<Boolean> = mutableStateOf(false),
    override val isNetworkError: MutableState<Boolean> = mutableStateOf(false),
    override val isLoading: MutableState<Boolean> = mutableStateOf(false),
    val user: MutableState<UserUIModel?> = mutableStateOf(null),
    val logoutDialogState: MutableState<Boolean> = mutableStateOf(false),

) : BaseViewState