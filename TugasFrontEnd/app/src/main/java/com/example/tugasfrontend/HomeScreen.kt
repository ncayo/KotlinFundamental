package com.example.tugasfrontend

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tugasfrontend.component.MenteeItem
import com.example.tugasfrontend.component.TeamItem
import com.example.tugasfrontend.data.LazyData
import com.example.tugasfrontend.model.Mentee
import com.example.tugasfrontend.model.Team
import com.example.tugasfrontend.navigation.Screen

@Composable
fun HomeScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    teams: List<Team> = LazyData.mobileTeams,
    mentees: List<Mentee> = LazyData.mobileMentees,
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        item{
            LazyRow(
                contentPadding = PaddingValues(16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = modifier
            ) {
                items(teams, key = {it.id}) {
                    TeamItem(team = it) { teamId ->
                        navController.navigate(Screen.Detail.route + "/$teamId")
                    }
                }
            }
        }
        items(mentees, key = {it.id}) {
            MenteeItem(mentee = it, modifier = Modifier.padding(horizontal = 16.dp))
        }
    }
}
