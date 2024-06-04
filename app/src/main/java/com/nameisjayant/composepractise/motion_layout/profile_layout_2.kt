package com.nameisjayant.composepractise.motion_layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ExperimentalMotionApi
import androidx.constraintlayout.compose.MotionLayout
import androidx.constraintlayout.compose.MotionScene
import com.nameisjayant.composepractise.R


@Composable
fun ProfileMotionLayout(modifier: Modifier = Modifier) {
    var progress by remember {
        mutableFloatStateOf(0.0f)
    }
    Column(modifier = modifier) {
        ProfileRow(progress = progress)
        Spacer(modifier = Modifier.height(40.dp))
        Slider(value = progress, onValueChange = {
            progress = it
        })
    }

}

@OptIn(ExperimentalMotionApi::class)
@Composable
fun ProfileRow(modifier: Modifier = Modifier, progress: Float) {
    val context = LocalContext.current
    val motionScene = remember {
        context.resources.openRawResource(R.raw.profile_scene)
            .readBytes()
            .decodeToString()
    }
    MotionLayout(
        motionScene = MotionScene(content = motionScene),
        modifier = modifier,
        progress = progress
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
                .padding(PaddingValues(vertical = 16.dp))
                .layoutId("box")
        )
        Box(
            modifier = Modifier
                .background(Color.Red, CircleShape)
                .size(80.dp)
                .layoutId("profile")
        )
        Text(text = "Jayant Kumar", color = Color.White, modifier = Modifier.layoutId("name"))
    }
}