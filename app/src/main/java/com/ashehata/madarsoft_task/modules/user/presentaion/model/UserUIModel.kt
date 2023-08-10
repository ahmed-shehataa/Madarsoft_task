package com.ashehata.madarsoft_task.modules.user.presentaion.model

import com.ashehata.madarsoft_task.common.enums.Gender


data class UserUIModel(
    val name: String,
    val jobTitle: String,
    val age: Int,
    val gender: Gender,
)