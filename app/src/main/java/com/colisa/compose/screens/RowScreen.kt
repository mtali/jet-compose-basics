package com.colisa.compose.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import com.colisa.compose.R
import com.colisa.compose.router.BackButtonHandler
import com.colisa.compose.router.JetFundamentalsRouter
import com.colisa.compose.router.Screen


val THREE_ELEMENTS = listOf(R.string.first, R.string.second, R.string.third)

@Composable
fun RowScreen() {
    MyRow()
    BackButtonHandler {
        JetFundamentalsRouter.navigateTo(Screen.Navigation)
    }
}

@Composable
fun MyRow() {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxSize()
    ) {
        THREE_ELEMENTS.forEach { item ->
            Text(text = stringResource(id = item), fontSize = 18.sp)
        }
    }
}