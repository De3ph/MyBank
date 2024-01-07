package com.example.mybank.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.mybank.navigation.NavGraph
import com.example.mybank.presentation.component.layout.Layout
import com.example.mybank.presentation.viewModel.MainViewModel
import com.example.mybank.ui.theme.MyBankTheme
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            navController = rememberNavController()
            val mainViewModel = koinViewModel<MainViewModel>()

            MyBankTheme {
                Layout(
                    navController = navController
                ) {
                    NavGraph(navController = navController)
                }
            }

        }

    }
}
