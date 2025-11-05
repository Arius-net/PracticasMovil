package com.sayd.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sayd.myapplication.ui.theme.MyApplicationTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sayd.myapplication.ViewModels.CounterViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val counterViewModel : CounterViewModel by viewModels()
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold (modifier = Modifier.fillMaxSize()){ innerpadding ->
                    content(innerpadding, counterViewModel)
                }
            }
        }
    }
}


@Composable
fun content (paddingValues: PaddingValues, counterViewModel: CounterViewModel){
    var counter = counterViewModel.counter.value
    Column (
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text ("Counter: $counter")
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = {
            counterViewModel.add()
        }) {
            Text("+")
        }
    }
}


@Preview
@Composable
fun PreviewContent(){
    val counterViewModel: CounterViewModel = viewModel()
    content(paddingValues = PaddingValues(0.dp), counterViewModel = counterViewModel
    )
}