package com.nameisjayant.composepractise.motion_layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ExperimentalMotionApi
import androidx.constraintlayout.compose.MotionLayout
import androidx.constraintlayout.compose.MotionScene
import com.nameisjayant.composepractise.R


@OptIn(ExperimentalMotionApi::class)
@Composable
fun MoveBox(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val motionScene = remember {
        context.resources.openRawResource(R.raw.move_box_scene)
            .readBytes()
            .decodeToString()
    }
    MotionLayout(
        motionScene = MotionScene(content = motionScene),
        modifier = modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .background(Color.Red)
                .size(50.dp)
                .layoutId("box")
        )
    }

}