package com.example.tugasfrontend.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tugasfrontend.R
import com.example.tugasfrontend.model.Laptop
import com.example.tugasfrontend.ui.theme.TugasFrontEndTheme

@Composable
fun LaptopItem(
    laptop: Laptop,
    modifier: Modifier = Modifier,
) {
    Column (
        modifier = modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = laptop.photo),
            contentDescription = laptop.name,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = laptop.name,
            textAlign = TextAlign.Center,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = laptop.level,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.fillMaxWidth()
        )
    }

}

@Preview(showBackground = true)
@Composable
private fun LaptopItemPreview(){
    TugasFrontEndTheme {
        LaptopItem(
            laptop = Laptop(
                id = 1,
                name = "Predator Helios 18",
                level = "Gaming",
                R.drawable.predatorhelios18
            )
        )
    }
}