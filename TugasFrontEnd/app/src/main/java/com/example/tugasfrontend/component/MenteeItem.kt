package com.example.tugasfrontend.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tugasfrontend.R
import com.example.tugasfrontend.model.Mentee
import com.example.tugasfrontend.ui.theme.TugasFrontEndTheme

@Composable
fun MenteeItem(
    mentee: Mentee,
    modifier: Modifier = Modifier,
) {
    Row (
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.fillMaxWidth()
    ){
        Image(
            painter = painterResource(id = mentee.photo),
            contentDescription = mentee.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(CircleShape)
                .size(80.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(text = mentee.name, style = MaterialTheme.typography.titleMedium)
            Row {
                Text(text = mentee.role, color = MaterialTheme.colorScheme.primary)
                Text(text = " - ${mentee.batch}")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun MenteeItemPreview() {
    TugasFrontEndTheme {
        MenteeItem(
            mentee = Mentee(
                id = 1,
                name = "Nurcahyo",
                R.drawable.cahyo,
                batch = "Batch 5",
                role = "Mentee Web"
            )
        )
    }
}