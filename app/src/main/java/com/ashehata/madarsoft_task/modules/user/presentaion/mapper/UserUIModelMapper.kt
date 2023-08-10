package com.ashehata.madarsoft_task.modules.user.presentaion.mapper

import com.ashehata.madarsoft_task.modules.user.domain.model.UserDomainModel
import com.ashehata.madarsoft_task.modules.user.presentaion.model.UserUIModel


fun UserDomainModel.toUIModel() = UserUIModel(
    name, jobTitle, age, gender
)