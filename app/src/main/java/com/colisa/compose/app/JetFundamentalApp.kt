package com.colisa.compose.app

import androidx.compose.animation.Crossfade
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import com.colisa.compose.router.JetFundamentalsRouter
import com.colisa.compose.router.Screen
import com.colisa.compose.screens.*

@Composable
fun JetFundamentalApp() {
    Surface(color = MaterialTheme.colors.background) {
        Crossfade(targetState = JetFundamentalsRouter.currentScreen) { screenState ->
            when (screenState.value) {
                Screen.Navigation -> NavigationScreen()
                Screen.Text -> TextScreen()
                Screen.TextField -> TextFieldScreen()
                Screen.Buttons -> ExploreButtonsScreen()
                Screen.ProgressIndicator -> ProgressIndicatorScreen()
                Screen.AlertDialog -> AlertDialogScreen()
                Screen.Row -> RowScreen()
                Screen.Column -> ColumnScreen()
                Screen.Box -> BoxScreen()
                Screen.Surface -> SurfaceScreen()
                Screen.Scaffold -> ScaffoldScreen()
                Screen.Scroll -> ScrollScreen()
                Screen.ListScreen -> ListsScreen()
                Screen.Grid -> GridScreen()
            }
        }
    }
}
