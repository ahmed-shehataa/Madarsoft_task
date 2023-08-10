package com.ashehata.madarsoft_task.modules.user.data.model

import androidx.annotation.Keep
import com.ashehata.madarsoft_task.common.enums.Gender

@Keep
data class UserDataModel(
    val name: String,
    val jobTitle: String,
    val age: Int,
    val gender: Gender,
)
