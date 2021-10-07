package com.colisa.compose.screens

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.colisa.compose.R
import com.colisa.compose.router.BackButtonHandler
import com.colisa.compose.router.JetFundamentalsRouter
import com.colisa.compose.router.Screen

data class BookCategory(@StringRes val categoryResId: Int, val bookImageRes: List<Int>)

private val items = listOf(
    BookCategory(
        R.string.android,
        listOf(
            R.drawable.android_aprentice,
            R.drawable.saving_data_android,
            R.drawable.advanced_architecture_android
        )
    ),
    BookCategory(
        R.string.kotlin,
        listOf(
            R.drawable.kotlin_coroutines,
            R.drawable.kotlin_aprentice
        )
    ),
    BookCategory(
        R.string.swift,
        listOf(
            R.drawable.combine,
            R.drawable.rx_swift,
            R.drawable.swift_apprentice,
        )
    ),
    BookCategory(
        R.string.ios,
        listOf(
            R.drawable.core_data,
            R.drawable.ios_apprentice,
        )
    )
)

@Composable
fun ListsScreen() {
    MyList()
    BackButtonHandler {
        JetFundamentalsRouter.navigateTo(Screen.Navigation)
    }

}

@Composable
fun MyList() {
    LazyColumn {
        items(items) { item -> ListItem(item) }
    }
}

@Composable
fun ListItem(category: BookCategory, modifier: Modifier = Modifier) {
    Column(modifier = Modifier.padding(8.dp)) {
        Text(
            text = stringResource(id = category.categoryResId),
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colors.primary
        )
        Spacer(modifier = modifier.height(8.dp))
        LazyRow {
            items(category.bookImageRes) { items ->
                BookImage(items)
            }
        }
    }
}

@Composable
fun BookImage(imageResource: Int) {
    Image(
        modifier = Modifier.size(170.dp, 200.dp),
        painter = painterResource(id = imageResource),
        contentScale = ContentScale.Fit,
        contentDescription = stringResource(id = R.string.book_image)
    )
}