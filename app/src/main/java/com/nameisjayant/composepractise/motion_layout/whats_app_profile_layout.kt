package com.nameisjayant.composepractise.motion_layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ExperimentalMotionApi
import androidx.constraintlayout.compose.MotionLayout
import androidx.constraintlayout.compose.MotionScene
import com.nameisjayant.composepractise.R


@OptIn(ExperimentalMotionApi::class)
@Composable
fun WhatsAppProfileLayout(modifier: Modifier = Modifier) {

    val context = LocalContext.current
    val motionScene = remember {
        context.resources.openRawResource(R.raw.profile_motion_scene).readBytes().decodeToString()
    }

    MotionLayout(
        motionScene = MotionScene(content = motionScene), modifier = modifier.fillMaxSize()
    ) {
        IconButton(onClick = {}, modifier = Modifier.layoutId("arrowBack")) {
            Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
        }
        Box(
            modifier = Modifier
                .background(Color.Black, CircleShape)
                .layoutId("profile")
        )
        Text(
            text = "Jayant",
            fontSize = 24.sp,
            fontWeight = FontWeight.W600,
            color = Color.Black,
            modifier =Modifier.layoutId("name")
        )
        LazyColumn(
            modifier = Modifier.fillMaxSize().layoutId("items")
        ) {
            items(40){
                Text(text = "item $it", modifier = Modifier.padding(top = 10.dp))
            }
        }
    }
}