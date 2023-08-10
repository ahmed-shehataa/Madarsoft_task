package com.ashehata.madarsoft_task.modules.profile.presentation.composables

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.ashehata.madarsoft_task.R
import com.ashehata.madarsoft_task.common.presentation.compose.AlertDialog
import com.ashehata.madarsoft_task.modules.user.presentaion.model.UserUIModel


@Composable
fun ProfileScreenContent(
    user: UserUIModel?,
    logoutDialogState: MutableState<Boolean>,
    onLogout: () -> Unit,
) {

    Box(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(
                    horizontal = 20.dp,
                    vertical = 20.dp
                ),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {

            ItemTitled(
                title = R.string.user_name,
                des = user?.name ?: ""
            )

            ItemTitled(
                title = R.string.job_title,
                des = user?.jobTitle ?: ""
            )

            ItemTitled(
                title = R.string.age,
                des = user?.age?.toString() ?: ""
            )

            ItemTitled(
                title = R.string.gender,
                des = user?.gender?.name?.toLowerCase()?.capitalize() ?: ""
            )

        }

        IconButton(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 40.dp),
            onClick = {
                logoutDialogState.value = true
            }) {
            Icon(
                modifier = Modifier.size(20.dp),
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_logout),
                contentDescription = "Logout",
                tint = Color.Black,
            )
        }
    }

    AlertDialog(
        state = logoutDialogState,
        title = R.string.logout,
        content = R.string.are_you_sure_to_logout,
        positiveTitleRes = R.string.logout,
        negativeTitleRes = R.string.cancel,
        positive = {
            onLogout()
        }
    )

}

@Composable
fun ItemTitled(
    @StringRes title: Int,
    des: String
) {

    Row(
        Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = stringResource(id = title) + ": ",
            style = MaterialTheme.typography.subtitle1
        )

        Text(
            text = des,
            style = MaterialTheme.typography.subtitle2
        )
    }

}