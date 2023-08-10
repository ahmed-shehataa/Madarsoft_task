package com.ashehata.madarsoft_task.modules.sign_up.presentation.composables

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.hilt.navigation.compose.hiltViewModel
import com.ashehata.madarsoft_task.common.presentation.GeneralObservers
import com.ashehata.madarsoft_task.modules.sign_up.presentation.contract.SignUpEvent
import com.ashehata.madarsoft_task.modules.sign_up.presentation.contract.SignUpState
import com.ashehata.madarsoft_task.modules.sign_up.presentation.contract.SignUpViewState
import com.ashehata.madarsoft_task.modules.sign_up.presentation.viewModel.SignUpViewModel

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SignUpScreen(
    viewModel: SignUpViewModel,
) {

    val keyboardController = LocalSoftwareKeyboardController.current

    val viewStates = remember {
        viewModel.viewStates ?: SignUpViewState()
    }


    val email = remember {
        viewStates.email
    }

    val isLoading = remember {
        viewStates.isLoading
    }

    val isButtonEnabled by remember(email.text, email.text) {
        derivedStateOf {
            email.isValid.value && email.isValid.value
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
        email = email,
        jobTitle = email,
        age = email,
        gender = email,
        isButtonEnabled = isButtonEnabled,
        onSignUpClicked = onSignUpClicked
    )

    GeneralObservers<SignUpState, SignUpViewModel>(viewModel = viewModel) {
        when (it) {
            SignUpState.OpenRecipesScreen -> {
                /*navigator?.navigate(RecipesScreenDestination, navOptions = navOptions {
                    popUpTo(SignUpScreenDestination.route) {
                        inclusive = true
                    }
                })*/
            }
        }

    }
}