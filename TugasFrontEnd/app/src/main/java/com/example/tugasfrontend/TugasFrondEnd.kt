package com.example.tugasfrontend

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Accessibility
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Laptop
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.navArgument
import com.example.tugasfrontend.navigation.NavigationItem
import com.example.tugasfrontend.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TugasFrondEnd(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
//    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Tugas Front End") },
                actions = {
                }
            )
        },
        bottomBar = {
            BottomBar(navController)
        },
        modifier = modifier
    ) { contentPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = modifier.padding(contentPadding)
        ) {
            composable(Screen.Home.route){
                HomeScreen(navController)
            }

            composable(Screen.Laptop.route){
                LaptopScreen()
            }
            composable(Screen.About.route){
                AboutScreen()
            }
            composable(Screen.Detail.route + "/{teamId}",
                arguments = listOf(navArgument("teamId"){ type = NavType.IntType })
            ) { navBackStackEntry ->
                DetailTeamScreen(
                    navController = navController,
                    teamsId = navBackStackEntry.arguments?.getInt("teamId"))

            }
        }
    }
}

@Composable
private fun BottomBar(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    NavigationBar(
        modifier = modifier
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        val navigationItem = listOf(
            NavigationItem(
                title = "Home",
                icon = Icons.Default.Home,
                screen = Screen.Home
            ),
            NavigationItem(
                title = "Laptop",
                icon = Icons.Default.Laptop,
                screen = Screen.Laptop
            ),
            NavigationItem(
                title = "About",
                icon = Icons.Default.Accessibility,
                screen = Screen.About
            )
        )
        navigationItem.map { item ->
            NavigationBarItem(
                selected = currentRoute == item.screen.route,
                onClick = {
                     navController.navigate(item.screen.route){
                         popUpTo(navController.graph.findStartDestination().id){
                             saveState = true
                         }
                         restoreState = true
                         launchSingleTop = true
                     }
                },
                icon = { Icon(imageVector = item.icon, contentDescription = item.title) },
                label = { Text(text = item.title) }
                )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TugasFrontEndPreview() {
    TugasFrondEnd()
}