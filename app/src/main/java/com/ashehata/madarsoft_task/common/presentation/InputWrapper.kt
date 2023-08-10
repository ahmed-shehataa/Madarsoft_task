package com.ashehata.madarsoft_task.common.presentation


import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import com.ashehata.madarsoft_task.common.presentation.Validation.validateEmail
import com.ashehata.madarsoft_task.common.presentation.Validation.validateText
import com.ashehata.madarsoft_task.R

enum class ValidationType {
    Text, Email, Password
}

data class InputWrapper(
    var text: MutableState<String> = mutableStateOf(""),
    var isValid: MutableState<Boolean> = mutableStateOf(false),
    var borderColor: Color = Color.Gray,
    val validationType: ValidationType? = ValidationType.Text
) {

    var validationMessageResId: Int = R.string.empty_lbl

    fun onValueChange(input: String) {
        text.value = input
        validationMessageResId = when (validationType) {
            ValidationType.Email -> input.validateEmail().toMessageRes()
            else -> input.validateText().toMessageRes()
        }
        borderColor = if (isValid.value) {
            Color.Gray
        } else {
            Color.Red
        }
        isValid.value = validationMessageResId == R.string.empty_lbl && text.value.isNotEmpty()
    }
}

private fun ValidationMessageType.toMessageRes(): Int {
    return when (this) {
        ValidationMessageType.EmptyField -> R.string.empty_field
        is ValidationMessageType.Invalid -> {
            when (this.validationType) {
                ValidationType.Email -> R.string.invalid_email
                else -> R.string.invalid_email
            }
        }
        ValidationMessageType.Valid -> R.string.empty_lbl
    }
}