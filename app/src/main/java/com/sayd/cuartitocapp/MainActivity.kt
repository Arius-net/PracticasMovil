package com.sayd.cuartitocapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.sayd.cuartitocapp.ui.theme.CuartitoCAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CuartitoCAppTheme {
                AppNavigation()
            }
        }
    }
}
