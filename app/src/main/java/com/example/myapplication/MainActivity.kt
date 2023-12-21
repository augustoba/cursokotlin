package com.example.myapplication

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            content()

        }
    }
}

val listaItems = listOf(Color.Black, Color.Red,Color.Yellow,Color.Black, Color.Green, Color.Cyan)
val nombre: String = "Me Gusta"

@Preview(showBackground = true)
@Composable
fun content(){
    //sive para usar las variables en tiempo de ejecucion en tiempo real si no no se modifica en la vista
    var likes by remember { mutableStateOf(0) }

Column(modifier = Modifier
    .fillMaxSize()
    .wrapContentSize(Alignment.Center)
    .padding(horizontal = 10.dp)
) {
    Texto("putos")
    Space()
    Texto("los del")
    Space()
    Texto("front")
    Space()
    //hace un for de la lista que le pasas y crea la row
    LazyRow(modifier = Modifier
        .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
        ){
        items(listaItems) {item ->
            Circulo(color = item)
            Spacer(modifier = Modifier.width(10.dp))

        }
    }
    Space()
    Row (modifier = Modifier
        .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically){
        Button(onClick = {
            likes ++ }) {
            Text(text = nombre)

        }
        Spacer(modifier = Modifier.width(10.dp))
        Resultado(likes = likes)
    }
    /*Row (modifier = Modifier
        .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly){
        Circulo(color =Color.Red)
        Circulo(color =Color.Blue)
        Circulo(color =Color.Yellow)
        Circulo(color =Color.Green)

}*/

}

}


@Composable
fun Texto(texto:String){
    Text(text = texto,
        color = Color.Red,
        fontWeight = FontWeight.Bold ,
        fontSize = 40.sp,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .background(Color.Black)
            .padding(horizontal = 30.dp)
            .fillMaxWidth()
            .clickable { Log.e(TAG, "clickeaste") }
    )
}

@Composable
fun Space(){
    Spacer(modifier= Modifier.height(5.dp))
}

@Composable
fun Circulo(color :Color){
Box(modifier = Modifier
    .size(70.dp)
    .background(color, CircleShape))
}

@Composable
fun Resultado(likes: Int){
    Text(text= likes.toString(), fontWeight = FontWeight.Bold, fontSize = 50.sp)
}