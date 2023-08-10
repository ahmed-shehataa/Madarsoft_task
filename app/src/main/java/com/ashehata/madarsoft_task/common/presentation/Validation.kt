package com.ashehata.madarsoft_task.common.presentation

import androidx.core.util.PatternsCompat

sealed class ValidationMessageType(val validationType: ValidationType? = null) {
    object EmptyField : ValidationMessageType()
    data class Invalid(val type: ValidationType?) : ValidationMessageType(type)
    object Valid : ValidationMessageType()
}

object Validation {
    fun String.validateEmail(): ValidationMessageType {
        return if (this.isEmpty()) ValidationMessageType.EmptyField
        else if (PatternsCompat.EMAIL_ADDRESS.matcher(this.trim()).matches()
                .not()
        ) ValidationMessageType.Invalid(ValidationType.Email)
        else ValidationMessageType.Valid
    }

    fun String.validateAge(): ValidationMessageType {
        val agePattern = Regex("^(0?[1-9]|[1-9][0-9]{1,2})\$")
        return if (this.isEmpty()) ValidationMessageType.EmptyField
        else if (this.matches(agePattern).not()) ValidationMessageType.Invalid(ValidationType.Age)
        else ValidationMessageType.Valid
    }

    fun String.validateText(): ValidationMessageType {
        return if (this.isEmpty()) ValidationMessageType.EmptyField
        else ValidationMessageType.Valid
    }
}