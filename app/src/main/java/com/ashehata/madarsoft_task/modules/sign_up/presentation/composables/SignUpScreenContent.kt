package com.ashehata.madarsoft_task.modules.sign_up.presentation.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.ashehata.madarsoft_task.R
import com.ashehata.madarsoft_task.common.presentation.InputWrapper
import com.ashehata.madarsoft_task.common.presentation.compose.InputText

@Composable
fun SignUpScreenContent(
    email: InputWrapper,
    jobTitle: InputWrapper,
    age: InputWrapper,
    gender: InputWrapper,
    isButtonEnabled: Boolean,
    onSignUpClicked: () -> Unit,
    isLoading: Boolean
) {

    Box {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(horizontal = 20.dp)
                .verticalScroll(rememberScrollState()),
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
                hint = stringResource(id = R.string.app_name),
                inputWrapper = email,
                keyboardType = KeyboardType.Email
            ) {

            }


            InputText(
                inputWrapper = email,
                hint = stringResource(id = R.string.app_name),
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done,
                onDone = {
                    if (isButtonEnabled)
                        onSignUpClicked()
                }
            )

            Button(
                modifier = Modifier
                    .requiredHeight(50.dp)
                    .fillMaxWidth(),
                onClick = onSignUpClicked,
                content = {
                    Text(text = stringResource(R.string.app_name))
                },
                enabled = isButtonEnabled,
                shape = MaterialTheme.shapes.medium
            )

        }

        if (isLoading) {
            Surface(
                modifier = Modifier.fillMaxSize().testTag("loading_view"),
                color = Color.Black.copy(alpha = 0.5f)
            ) {

                Box(modifier = Modifier.fillMaxSize()) {
                    CircularProgressIndicator(Modifier.align(Alignment.Center))
                }
            }
        }
    }
}