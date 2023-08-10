package com.ashehata.madarsoft_task.modules.sign_up.presentation.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.ashehata.madarsoft_task.R
import com.ashehata.madarsoft_task.common.enums.Gender
import com.ashehata.madarsoft_task.common.presentation.InputWrapper
import com.ashehata.madarsoft_task.common.presentation.compose.InputText

@Composable
fun SignUpScreenContent(
    userName: InputWrapper,
    jobTitle: InputWrapper,
    age: InputWrapper,
    gender: MutableState<Gender>,
    isButtonEnabled: Boolean,
    onSignUpClicked: () -> Unit,
    isLoading: Boolean
) {

    Box {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 20.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {


            Spacer(modifier = Modifier.height(20.dp))

            Image(
                modifier = Modifier
                    .size(250.dp)
                    .align(Alignment.CenterHorizontally),
                imageVector = ImageVector.vectorResource(id = R.drawable.login_placeholder),
                contentDescription = null
            )


            InputText(
                hint = stringResource(id = R.string.user_name),
                inputWrapper = userName,
                keyboardType = KeyboardType.Text
            )


            InputText(
                inputWrapper = jobTitle,
                hint = stringResource(id = R.string.job_title),
                keyboardType = KeyboardType.Text,
            )

            InputText(
                inputWrapper = age,
                hint = stringResource(id = R.string.age),
                keyboardType = KeyboardType.Number,
            )

            GenderItem(gender)

            Button(
                modifier = Modifier
                    .requiredHeight(50.dp)
                    .fillMaxWidth(),
                onClick = onSignUpClicked,
                content = {
                    Text(text = stringResource(R.string.sign_up))
                },
                enabled = isButtonEnabled,
                shape = MaterialTheme.shapes.medium
            )

            Spacer(modifier = Modifier.height(20.dp))

        }

        if (isLoading) {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color.Black.copy(alpha = 0.5f)
            ) {
                Box(modifier = Modifier.fillMaxSize()) {
                    CircularProgressIndicator(Modifier.align(Alignment.Center))
                }
            }
        }
    }
}