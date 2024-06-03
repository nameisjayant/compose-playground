package com.nameisjayant.composepractise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.nameisjayant.composepractise.motion_layout.MotionLayoutScreenOne
import com.nameisjayant.composepractise.motion_layout.WhatsAppProfileLayout
import com.nameisjayant.composepractise.ui.theme.ComposePractiseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // enableEdgeToEdge()
        setContent {
            ComposePractiseTheme {

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    WhatsAppProfileLayout(modifier = Modifier.padding(innerPadding))

                }
            }
        }
    }
}