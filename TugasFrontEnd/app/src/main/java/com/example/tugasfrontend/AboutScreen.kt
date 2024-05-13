package com.example.tugasfrontend

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tugasfrontend.ui.theme.TugasFrontEndTheme

@Composable
fun AboutScreen() {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth().padding(4.dp)
    ) {
        Box {
            Image(
                painter = painterResource(id = R.drawable.cahyo1),
                contentDescription = "Cahyo",
                modifier = Modifier.size(100.dp)
            )
        }
        Column {
            Text(text = "Nurcahyo")
            Text(text = "nurc21149ti@student.nurulfikri.ac.id")
            Text(text = "STT Terpadu Nurul Fikri")
            Text(text = "Teknik Informatika")
        }
    }

}

@Preview(showBackground = true)
@Composable
private fun AboutScreenPreview() {
    TugasFrontEndTheme {
        AboutScreen()
    }

}