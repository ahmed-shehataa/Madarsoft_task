package com.ashehata.madarsoft_task.base

import androidx.compose.runtime.MutableState

interface BaseEvent

interface BaseState

interface BaseViewState {
    val isRefreshing: MutableState<Boolean>
    val isNetworkError: MutableState<Boolean>
    val isLoading: MutableState<Boolean>
}