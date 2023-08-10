package com.ashehata.madarsoft_task.modules.sign_up.presentation.composables

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.navigation.NavHostController
import androidx.navigation.navOptions
import com.ashehata.madarsoft_task.common.presentation.GeneralObservers
import com.ashehata.madarsoft_task.modules.sign_up.presentation.contract.SignUpEvent
import com.ashehata.madarsoft_task.modules.sign_up.presentation.contract.SignUpState
import com.ashehata.madarsoft_task.modules.sign_up.presentation.contract.SignUpViewState
import com.ashehata.madarsoft_task.modules.sign_up.presentation.viewModel.SignUpViewModel

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SignUpScreen(
    viewModel: SignUpViewModel,
    navController: NavHostController,
) {

    val keyboardController = LocalSoftwareKeyboardController.current

    val viewStates = remember {
        viewModel.viewStates ?: SignUpViewState()
    }


    val userName = remember {
        viewStates.userName
    }

    val jobTitle = remember {
        viewStates.jobTitle
    }

    val age = remember {
        viewStates.age
    }

    val gender = remember {
        viewStates.gender
    }

    val isLoading = remember {
        viewStates.isLoading
    }

    val isButtonEnabled by remember(userName.text, jobTitle.text, age.text) {
        derivedStateOf {
            userName.isValid.value && jobTitle.isValid.value && age.isValid.value
        }
    }

    val onSignUpClicked = remember {
        {
            keyboardController?.hide()
            viewModel.setEvent(
                SignUpEvent.OnSignUpClicked
            )
        }
    }


    SignUpScreenContent(
        isLoading = isLoading.value,
        userName = userName,
        jobTitle = jobTitle,
        age = age,
        gender = gender,
        isButtonEnabled = isButtonEnabled,
        onSignUpClicked = onSignUpClicked
    )

    GeneralObservers<SignUpState, SignUpViewModel>(viewModel = viewModel) {
        when (it) {
            SignUpState.OpenRecipesScreen -> {
                navController.navigate("profile", navOptions = navOptions {
                    popUpTo("sign_up") {
                        inclusive = true
                    }
                })
            }
        }

    }
}