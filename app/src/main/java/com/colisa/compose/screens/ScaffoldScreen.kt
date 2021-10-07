package com.colisa.compose.screens

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.colisa.compose.R
import com.colisa.compose.router.BackButtonHandler
import com.colisa.compose.router.JetFundamentalsRouter
import com.colisa.compose.router.Screen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun ScaffoldScreen() {
    MyScaffold()

    BackButtonHandler {
        JetFundamentalsRouter.navigateTo(Screen.Navigation)
    }
}

@Composable
fun MyScaffold() {
    val scaffoldState: ScaffoldState = rememberScaffoldState()
    val scope: CoroutineScope = rememberCoroutineScope()
    Scaffold(
        scaffoldState = scaffoldState,
        contentColor = MaterialTheme.colors.primary,
        content = { MyRow() },
        topBar = { MyTopAppBar(scaffoldState = scaffoldState, scope = scope) },
        bottomBar = { MyBottomAppBar() },
        drawerContent = { MyColumn() }
    )
}

@Composable
fun MyTopAppBar(scaffoldState: ScaffoldState, scope: CoroutineScope) {
    val drawerState = scaffoldState.drawerState
    TopAppBar(
        title = { Text(text = stringResource(id = R.string.app_name)) },
        backgroundColor = MaterialTheme.colors.primary,
        navigationIcon = {
            IconButton(
                content = {
                    Icon(
                        imageVector = Icons.Default.Menu,
                        tint = Color.White,
                        contentDescription = stringResource(id = R.string.menu)
                    )
                },
                onClick = {
                    scope.launch { if (drawerState.isClosed) drawerState.open() else drawerState.close() }
                }
            )
        }
    )
}

@Composable
fun MyBottomAppBar() {
    BottomAppBar(
        content = {},
        backgroundColor = MaterialTheme.colors.primary
    )
}

