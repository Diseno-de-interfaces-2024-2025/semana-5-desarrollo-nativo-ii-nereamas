package com.example.desarrollonativo2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Create
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            Scaffold(
                topBar = {
                    CenterAlignedTopAppBar(
                        colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = Color(0xFFCDE7B0)
                        ),
                        title = { Text("Asignaturas") },
                        navigationIcon = {
                            Icon(
                                imageVector = Icons.AutoMirrored.Outlined.ArrowBack,
                                contentDescription = "favorite",
                                tint = Color.Black,
                                modifier = Modifier.height(35.dp) .width(35.dp)
                            )
                        },
                        actions = {
                            Icon(
                                imageVector = Icons.Outlined.AccountCircle,
                                contentDescription = "favorite",
                                tint = Color.Black,
                                modifier = Modifier.height(35.dp) .width(35.dp)
                            )
                        }
                    )
                },
                bottomBar = {
                    BottomAppBar(
                        containerColor = Color(0xFFCDE7B0)
                    ) {
                        Row(
                            Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.Home,
                                contentDescription = "favorite",
                                tint = Color.Black,
                                modifier =  Modifier.clickable { navController.navigate("screen1") }
                            )
                            Icon(
                                imageVector = Icons.Outlined.Create,
                                contentDescription = "favorite",
                                tint = Color.Black,
                                modifier =  Modifier.clickable { navController.navigate("screen2") }
                            )
                            Icon(
                                imageVector = Icons.Outlined.Favorite,
                                contentDescription = "favorite",
                                tint = Color.Red,
                                modifier =  Modifier.clickable { navController.navigate("screen3") }
                            )

                        }
                    }
                },
                modifier = Modifier.fillMaxSize()
            ) { innerPadding ->
                MyNavControllerCustom(navController, Modifier.padding(innerPadding))
            }
        }
    }

    @Composable
    fun MyNavControllerCustom(navController: NavHostController, modifier: Modifier) {
        NavHost(
            navController = navController,
            startDestination = "screen1",
            modifier = modifier
        ) {
            composable("screen1") { Screen1() }
            composable("screen2") { Screen2() }
            composable("screen3") { Screen3() }
        }
    }
}