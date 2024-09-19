package com.nameisjayant.composepractise.canvas

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp

/*
     * relativeMoveTo() --- move from current position.
     * moveTo() --- it will not move from the current position , start from the topLeft position.
     * lineTo --- it will always start from a new position like topLeft(0f,0f).
     * relativeLineTo --- it will start from the current position.
 */

@Composable
fun PathScreen(modifier: Modifier = Modifier) {
    Canvas(modifier = modifier.fillMaxSize()) {
        val canvasWidth = size.width
        val canvasHeight = size.height
        val path = Path().apply {
            moveTo(canvasWidth / 2, 0f) // initial position
            lineTo(0f, canvasHeight / 2)
            lineTo(canvasWidth / 2, canvasHeight)
            lineTo(canvasWidth, canvasHeight / 2)
            moveTo(canvasWidth / 2, 0f)
            lineTo(canvasWidth, canvasHeight / 2)
            close()
        }

        drawPath(path = path, color = Color.Red, style = Stroke(8.dp.toPx()))
    }

}

@Composable
fun PathScreen2(modifier: Modifier = Modifier) {
    Canvas(modifier = modifier.fillMaxSize()) {
        val canvasWidth = size.width
        val canvasHeight = size.height
        val path = Path().apply {
            moveTo(canvasWidth / 2, 0f) // initial position
            relativeLineTo(canvasWidth / 2, canvasHeight / 2)
            relativeLineTo(-(canvasWidth / 2), canvasHeight / 2)
            relativeLineTo(-(canvasWidth / 2), -(canvasHeight / 2))
            relativeLineTo(canvasWidth / 2, -(canvasHeight / 2))
            close()
        }

        drawPath(path = path, color = Color.Red, style = Stroke(8.dp.toPx()))
    }

}

@Composable
fun PathScreen3(modifier: Modifier = Modifier) {
    Canvas(modifier = modifier.fillMaxSize()) {
        val canvasWidth = size.width
        val canvasHeight = size.height
        val path = Path().apply {
            moveTo(0f, canvasHeight / 2) // initial position
            cubicTo(
                canvasWidth / 1.5f, canvasHeight / 2f,    // Control point 1
                0f, 0f,   // Control point 2
                canvasWidth, canvasHeight / 2    // End point
            )
        }

        drawPath(path = path, color = Color.Red, style = Stroke(8.dp.toPx()))
    }

}




