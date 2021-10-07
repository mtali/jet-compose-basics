package com.colisa.compose

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.colisa.compose.app.JetFundamentalApp
import com.colisa.compose.theme.AppComposeTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppComposeTheme {
                JetFundamentalApp()
            }
        }
    }
}