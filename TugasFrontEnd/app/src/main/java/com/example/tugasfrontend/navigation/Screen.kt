package com.example.tugasfrontend.navigation

sealed class Screen (val route: String){
    data object Home : Screen("home")
    data object Laptop: Screen("laptop")
    data object Detail: Screen("detail_team")
    data object About: Screen("about")
}