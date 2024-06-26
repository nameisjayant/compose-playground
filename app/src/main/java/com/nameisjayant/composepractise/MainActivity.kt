package com.nameisjayant.composepractise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.nameisjayant.composepractise.canvas.CanvasPractise
import com.nameisjayant.composepractise.canvas.PathScreen
import com.nameisjayant.composepractise.canvas.PathScreen2
import com.nameisjayant.composepractise.canvas.PathScreen3
import com.nameisjayant.composepractise.motion_layout.MoveBox
import com.nameisjayant.composepractise.motion_layout.ProfileLayout
import com.nameisjayant.composepractise.motion_layout.ProfileMotionLayout
import com.nameisjayant.composepractise.ui.theme.ComposePractiseTheme
import com.nameisjayant.composepractise.ui_testing.LoginScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // enableEdgeToEdge()
        setContent {
            ComposePractiseTheme {

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    //  ProfileLayout(modifier = Modifier.padding(innerPadding))
                   // MoveBox(modifier = Modifier.padding(innerPadding))
                   // ProfileMotionLayout(modifier = Modifier.padding(innerPadding))
                   // LoginScreen(modifier = Modifier.padding(innerPadding))
                   // CanvasPractise(modifier = Modifier.padding(innerPadding))
                    PathScreen3()
                }
            }
        }
    }
}