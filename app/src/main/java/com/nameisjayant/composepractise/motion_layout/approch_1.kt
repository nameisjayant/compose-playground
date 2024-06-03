package com.nameisjayant.composepractise.motion_layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ExperimentalMotionApi
import androidx.constraintlayout.compose.MotionLayout
import androidx.constraintlayout.compose.MotionScene
import com.nameisjayant.composepractise.R


@OptIn(ExperimentalMotionApi::class)
@Composable
fun MotionLayoutScreenOne(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val motionScene = remember {
        context.resources.openRawResource(R.raw.motion_scence).readBytes().decodeToString()
    }
    MotionLayout(
        motionScene = MotionScene(content = motionScene),
        modifier = modifier
            .fillMaxSize()
            .background(Color.LightGray)
    ) {
        Box(
            modifier = modifier
                .fillMaxHeight()
                .background(Color.White, RoundedCornerShape(8.dp)).layoutId("box"),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Content", fontSize = 40.sp, color = Color.Black)
        }
        IconButton(
            onClick = { }, modifier = Modifier.layoutId("menu")
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = null,
                tint = Color.Black
            )
        }
    }

}