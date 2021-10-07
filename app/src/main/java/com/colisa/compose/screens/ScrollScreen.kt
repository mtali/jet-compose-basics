package com.colisa.compose.screens

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.colisa.compose.R
import com.colisa.compose.router.BackButtonHandler
import com.colisa.compose.router.JetFundamentalsRouter
import com.colisa.compose.router.Screen

@Composable
fun ScrollScreen() {
    MyScrollingScreen()

    BackButtonHandler {
        JetFundamentalsRouter.navigateTo(Screen.Navigation)
    }
}

@Composable
fun MyScrollingScreen() {
    Row(
        modifier = Modifier.horizontalScroll(rememberScrollState()),
    ) {
        BookImage(R.drawable.advanced_architecture_android, R.string.advanced_architecture_android)
        BookImage(R.drawable.kotlin_aprentice, R.string.kotlin_apprentice)
        BookImage(R.drawable.kotlin_coroutines, R.string.kotlin_coroutines)
    }
}

@Composable
fun BookImage(@DrawableRes imageResId: Int, @StringRes contentDescription: Int) {
    Image(
        bitmap = ImageBitmap.imageResource(id = imageResId),
        contentDescription = stringResource(id = contentDescription),
        contentScale = ContentScale.FillBounds,
        modifier = Modifier.size(476.dp, 616.dp)
    )
}
