package com.example.desarrollonativo2

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Screen1() {
    val itemList = listOf(
        Asignatura("Historia", R.drawable.historia),
        Asignatura("Matemáticas", R.drawable.mates),
        Asignatura("Historia", R.drawable.historia),
        Asignatura("Matemáticas", R.drawable.mates),
        Asignatura("Historia", R.drawable.historia),
        Asignatura("Matemáticas", R.drawable.mates),
        Asignatura("Historia", R.drawable.historia),
        Asignatura("Matemáticas", R.drawable.mates),
        Asignatura("Historia", R.drawable.historia),
        Asignatura("Matemáticas", R.drawable.mates)
    )

    LazyColumn(
        modifier = Modifier
            .padding(horizontal = 15.dp)
            .fillMaxWidth()
    ) {
        items(itemList) { asign ->
            Column(
                Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = asign.asignatura,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                // Imagen dentro de un Box
                Box(
                    Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                        .clip(shape = RoundedCornerShape(20.dp))
                ) {
                    Image(
                        painter = painterResource(id = asign.imageId),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
            Spacer(Modifier.height(20.dp))
        }
    }

}
data class Asignatura(val asignatura: String, val imageId: Int)


