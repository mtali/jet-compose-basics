package com.colisa.compose.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.colisa.compose.R
import com.colisa.compose.router.BackButtonHandler
import com.colisa.compose.router.JetFundamentalsRouter
import com.colisa.compose.router.Screen

@Composable
fun ExploreButtonsScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        MyButton()
        MyRadioGroup()
        MyFloatingActionButton()

        BackButtonHandler {
            JetFundamentalsRouter.navigateTo(Screen.Navigation)
        }
    }
}

@Composable
fun MyButton() {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary),
        border = BorderStroke(
            1.dp,
            color = MaterialTheme.colors.primary
        )
    ) {
        Text(
            text = stringResource(id = R.string.button_text),
            color = Color.White
        )
    }
}

@Composable
fun MyRadioGroup() {
    val radioButtons = listOf(1, 2, 3)
    val selectedButton = remember { mutableStateOf(radioButtons.first()) }
    Column {
        radioButtons.forEach { index ->
            val isSelected = index == selectedButton.value
            val colors = RadioButtonDefaults.colors(
                selectedColor = MaterialTheme.colors.primary,
                unselectedColor = MaterialTheme.colors.primaryVariant,
                disabledColor = Color.LightGray
            )
            RadioButton(
                selected = isSelected,
                colors = colors,
                onClick = { selectedButton.value = index })
        }
    }
}

@Composable
fun MyFloatingActionButton() {
    FloatingActionButton(
        onClick = { },
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = Color.White,
        content = {
            Icon(Icons.Filled.Favorite, contentDescription = "Text FAB")
        }
    )
}