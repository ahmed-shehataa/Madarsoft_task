package com.ashehata.madarsoft_task.modules.profile.presentation.composables

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.navOptions
import com.ashehata.madarsoft_task.common.presentation.GeneralObservers
import com.ashehata.madarsoft_task.modules.profile.presentation.contract.ProfileEvent
import com.ashehata.madarsoft_task.modules.profile.presentation.contract.ProfileState
import com.ashehata.madarsoft_task.modules.profile.presentation.contract.ProfileViewState
import com.ashehata.madarsoft_task.modules.profile.presentation.viewModel.ProfileViewModel

@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel,
    navController: NavHostController,
) {

    val viewStates = remember {
        viewModel.viewStates ?: ProfileViewState()
    }


    val user = remember {
        viewStates.user
    }

    val logoutDialogState = remember {
        viewStates.logoutDialogState
    }


    val onLogoutClicked = remember {
        {
            viewModel.setEvent(ProfileEvent.OnLogoutClicked)
        }
    }


    ProfileScreenContent(
        user = user.value,
        logoutDialogState = logoutDialogState,
        onLogout = onLogoutClicked
    )

    GeneralObservers<ProfileState, ProfileViewModel>(viewModel = viewModel) {
        when (it) {
            ProfileState.OpenSignUpScreen -> {
                navController.navigate("sign_up", navOptions = navOptions {
                    popUpTo("profile") {
                        inclusive = true
                    }
                })
            }
        }

    }
}