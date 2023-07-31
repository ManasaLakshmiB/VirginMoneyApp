package com.example.virginMoneyapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.virginMoneyapp.ui.screens.DetailScreen
import com.example.virginMoneyapp.ui.screens.MainScreen
import com.example.virginMoneyapp.ui.theme.VirginMoneyAppTheme
import com.example.virginMoneyapp.ui.viewmodel.PeopleViewModel
import com.example.virginMoneyapp.ui.viewmodel.RoomViewModel

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<PeopleViewModel>()
    private val roomViewModel by viewModels<RoomViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VirginMoneyAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavigator(viewModel, roomViewModel)
                }
            }
        }
    }
}

@Composable
fun AppNavigator(peopleViewModel: PeopleViewModel,roomViewModel: RoomViewModel) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "main") {
        composable("main") {
            MainScreen(peopleViewModel,navController,roomViewModel) }
            composable("detail/{personId}") { backStackEntry ->
                DetailScreen(backStackEntry.arguments?.getString("personId") ?: "", peopleViewModel){
                //  onBack = { navController.popBackStack() }
                }


        }
    }

}











