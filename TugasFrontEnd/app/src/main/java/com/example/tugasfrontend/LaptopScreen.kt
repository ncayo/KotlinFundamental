package com.example.tugasfrontend

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tugasfrontend.component.LaptopItem
import com.example.tugasfrontend.data.LazyData
import com.example.tugasfrontend.model.Laptop
import com.example.tugasfrontend.ui.theme.TugasFrontEndTheme

@Composable
fun LaptopScreen(
    modifier: Modifier = Modifier,
    laptops: List<Laptop> = LazyData.mobileLaptops
) {
    LazyVerticalGrid(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        columns = GridCells.Adaptive(140.dp),
        modifier = modifier.fillMaxSize()
    ) {
        items(laptops, key = { it.id }) {
            LaptopItem(laptop = it)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun LaptopScreenPreview() {
    TugasFrontEndTheme {
        LaptopScreen(laptops = LazyData.mobileLaptops)
    }
}