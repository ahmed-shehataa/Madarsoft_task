package com.ashehata.madarsoft_task.modules.sign_up.presentation.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.ashehata.madarsoft_task.R
import com.ashehata.madarsoft_task.common.enums.Gender
import java.util.Locale

@Composable
fun GenderItem(gender: MutableState<Gender>) {

    val genders = remember {
        Gender.values()
    }

    val onOptionSelected: (Gender) -> Unit = remember {
        {
            gender.value = it
        }
    }

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Column {

            Text(
                text = stringResource(id = R.string.gender),
                style = MaterialTheme.typography.subtitle2
            )

            genders.forEach { text ->
                Row(
                    Modifier
                        .fillMaxWidth()
                        .selectable(
                            selected = (text == gender.value),
                            onClick = { onOptionSelected(text) }
                        ),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    RadioButton(
                        selected = (text == gender.value),
                        onClick = {
                            onOptionSelected(text)
                        },
                        colors = RadioButtonDefaults.colors(
                            selectedColor = MaterialTheme.colors.primary
                        )
                    )

                    Text(
                        text = text.name.toLowerCase(Locale.getDefault())
                            .capitalize(Locale.getDefault()),
                        style = MaterialTheme.typography.subtitle2
                    )
                }
            }
        }

    }
}