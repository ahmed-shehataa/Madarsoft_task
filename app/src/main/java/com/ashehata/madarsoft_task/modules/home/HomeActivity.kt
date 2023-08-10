package com.ashehata.madarsoft_task.modules.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.ashehata.madarsoft_task.common.presentation.GeneralObservers
import com.ashehata.madarsoft_task.modules.profile.presentation.composables.ProfileScreen
import com.ashehata.madarsoft_task.modules.profile.presentation.viewModel.ProfileViewModel
import com.ashehata.madarsoft_task.modules.sign_up.presentation.composables.SignUpScreen
import com.ashehata.madarsoft_task.modules.sign_up.presentation.viewModel.SignUpViewModel
import com.ashehata.madarsoft_task.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : ComponentActivity() {

    val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            AppTheme {
                NavHost(navController = navController, startDestination = "splash") {
                    composable("splash") {

                    }
                    composable("sign_up") {
                        val viewModel: SignUpViewModel by viewModels()
                        SignUpScreen(viewModel, navController)
                    }

                    composable("profile") {
                        val viewModel: ProfileViewModel by viewModels()
                        ProfileScreen(viewModel, navController)
                    }


                }

            }

            GeneralObservers<HomeState, HomeViewModel>(viewModel = viewModel) {
                val navOptions = navOptions {
                    popUpTo("splash") {
                        inclusive = true
                    }
                }

                when (it) {
                    HomeState.OpenSignUpScreen -> {
                        navController.navigate(
                            "sign_up",
                            navOptions = navOptions
                        )
                    }

                    HomeState.OpenProfileScreen -> {
                        navController.navigate(
                            "profile",
                            navOptions = navOptions
                        )
                    }
                }
            }
        }

    }
}
