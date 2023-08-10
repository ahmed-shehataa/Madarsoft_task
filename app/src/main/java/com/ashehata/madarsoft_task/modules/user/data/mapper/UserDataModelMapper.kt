package com.ashehata.madarsoft_task.modules.user.data.mapper

import com.ashehata.madarsoft_task.modules.user.data.model.UserDataModel
import com.ashehata.madarsoft_task.modules.user.domain.model.UserDomainModel

fun UserDataModel.toDomainModel(): UserDomainModel =
    UserDomainModel(
        name, jobTitle, age, gender
    )

