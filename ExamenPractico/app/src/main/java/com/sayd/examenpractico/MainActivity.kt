package com.sayd.examenpractico

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import com.sayd.examenpractico.Navigation.NavManager
import com.sayd.examenpractico.ui.theme.ExamenPracticoTheme
import com.sayd.examenpractico.viewmodels.ThemeViewModel

class MainActivity : ComponentActivity() {
    private val themeViewModel: ThemeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val isDarkTheme by themeViewModel.isDarkTheme.collectAsState()
            ExamenPracticoTheme(darkTheme = isDarkTheme) {
                NavManager()
            }
        }
    }
}

