package com.colisa.compose.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import com.colisa.compose.router.BackButtonHandler
import com.colisa.compose.router.JetFundamentalsRouter
import com.colisa.compose.router.Screen


@Composable
fun ColumnScreen() {
    MyColumn()

    BackButtonHandler {
        JetFundamentalsRouter.navigateTo(Screen.Navigation)
    }
}

@Composable
fun MyColumn() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxSize()
    ) {
        THREE_ELEMENTS.forEach {
            Text(text = stringResource(id = it), fontSize = 22.sp)
        }
    }
}