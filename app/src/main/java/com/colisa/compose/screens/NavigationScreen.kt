package com.colisa.compose.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.colisa.compose.R
import com.colisa.compose.router.JetFundamentalsRouter
import com.colisa.compose.router.Screen

@Composable
fun NavigationScreen() {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NavigationButton(stringResource(id = R.string.text), screen = Screen.Text)
            NavigationButton(stringResource(id = R.string.text_field), screen = Screen.TextField)
            NavigationButton(stringResource(id = R.string.buttons), screen = Screen.Buttons)
            NavigationButton(stringResource(R.string.progress_indicators), Screen.ProgressIndicator)
            NavigationButton(stringResource(R.string.alert_dialog), Screen.AlertDialog)
            NavigationButton(stringResource(R.string.row), Screen.Row)
            NavigationButton(stringResource(R.string.column), Screen.Column)
            NavigationButton(stringResource(R.string.box), Screen.Box)
            NavigationButton(stringResource(R.string.surface), Screen.Surface)
            NavigationButton(stringResource(R.string.scaffold), Screen.Scaffold)
            NavigationButton(stringResource(R.string.scrolling), Screen.Scroll)
            NavigationButton(stringResource(R.string.list), Screen.ListScreen)
            NavigationButton(stringResource(R.string.grid), Screen.Grid)

        }
    }
}


@Composable
fun NavigationButton(text: String, screen: Screen) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 16.dp),
        shape = RoundedCornerShape(4.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary),
        onClick = { JetFundamentalsRouter.navigateTo(screen) }
    ) {
        Text(text = text, color = Color.White)
    }
}