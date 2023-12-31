package com.ashehata.madarsoft_task.common.presentation.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag


@Composable
fun LoadingView() {
    Box(modifier = Modifier.fillMaxSize().testTag("loading_view")) {
        CircularProgressIndicator(Modifier.align(Alignment.Center))
    }
}