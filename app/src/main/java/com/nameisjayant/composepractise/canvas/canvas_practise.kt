package com.nameisjayant.composepractise.canvas

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.unit.dp


@Composable
fun CanvasPractise(modifier: Modifier = Modifier) {

    // DrawCircleScreen(modifier = modifier)
    // DrawRectangleScreen(modifier = modifier)
    //  DrawOvalScreen(modifier = modifier)
    //DrawArcScreen(modifier = modifier)
    // DrawPointsScreen(modifier = modifier)
    // DrawTextScreen(modifier = modifier)
    DrawPathScreen(modifier)
}

@Composable
fun DrawLineScreen(modifier: Modifier = Modifier) {
    Canvas(
        modifier = modifier
            .padding(horizontal = 20.dp)
            .fillMaxSize()
    ) {
        val canvasWith = size.width
        val canvasHeight = size.height

        drawLine(
            color = Color.Black,
            start = Offset(x = 0f, y = canvasHeight / 2),
            end = Offset(x = canvasWith, y = canvasHeight / 2),
            pathEffect =
//            PathEffect.cornerPathEffect(
//                40f
//            )
            PathEffect.chainPathEffect(
                inner = PathEffect.dashPathEffect(
                    intervals = floatArrayOf(10f, 10f), 0f
                ),
                outer = PathEffect.cornerPathEffect(30f)
            ),
            strokeWidth = 50f, alpha = .5f,
        )
    }
}

@Composable
fun DrawCircleScreen(modifier: Modifier = Modifier) {

    Canvas(modifier = modifier.fillMaxSize()) {
        val width = size.width
        val height = size.height

        drawCircle(
            color = Color.Red,
            radius = size.width / 3,
            center = Offset(width / 2, height / 5),
            //alpha = 0.3f,
            style = Stroke(
                width = 10f,
                pathEffect = PathEffect.dashPathEffect(
                    floatArrayOf(10f, 10f), 0f
                )
            )
        )

    }

}

@Composable
fun DrawRectangleScreen(modifier: Modifier = Modifier) {

    Canvas(modifier = modifier.fillMaxSize()) {
        val width = size.width
        val height = size.height

        drawRect(
            color = Color.Red,
            size = Size(
                width = width,
                height = height / 5
            ),
            topLeft = Offset(x = 0f, y = height / 3),
            style = Stroke(
                width = 10f,
                pathEffect = PathEffect.dashPathEffect(
                    floatArrayOf(10f, 10f), 0f
                )
            )
        )
    }

}

@Composable
fun DrawOvalScreen(modifier: Modifier = Modifier) {

    Canvas(modifier = modifier.fillMaxSize()) {
        val width = size.width
        val height = size.height
        drawOval(
            color = Color.Red,
            size = Size(width / 2, height / 2),
            topLeft = Offset(
                width / 4, height / 4
            )
        )
    }
}


@Composable
fun DrawArcScreen(modifier: Modifier = Modifier) {

    Canvas(modifier = modifier.fillMaxSize()) {
        val width = size.width
        val height = size.height
        drawArc(
            color = Color.Red,
            startAngle = 0f,  // 0f represents 3'0 clock
            sweepAngle = 180f,
            useCenter = true,
            style = Stroke(10f),
            topLeft = Offset(width / 3, height / 3),
            size = Size(300f, 300f),
        )
    }
}

@Composable
fun DrawPointsScreen(modifier: Modifier = Modifier) {

    Canvas(modifier = modifier.fillMaxSize()) {
        val width = size.width
        val height = size.height

        drawPoints(
            points = listOf(
                Offset(width / 2, 0f),
                Offset(width / 4, height / 4),
                Offset(width / 2, height / 2)
            ),
            color = Color.Red,
            pointMode = PointMode.Polygon,
            strokeWidth = 50f,
            cap = StrokeCap.Round

        )
    }
}


@Composable
fun DrawTextScreen(modifier: Modifier = Modifier) {
    val textMeasurer = rememberTextMeasurer()
    val text = "Hello world"
    val textLayoutResult = remember(text) {
        textMeasurer.measure(text)
    }
    Canvas(modifier = modifier.fillMaxSize()) {
        val width = size.width
        val height = size.height
        drawText(
            textMeasurer = textMeasurer,
            text = "Hello World",
            topLeft = Offset(
                width / 2 - textLayoutResult.size.width / 2,
                height / 2 - textLayoutResult.size.height / 3
            )
        )
    }
}

@Composable
fun DrawPathScreen(modifier: Modifier = Modifier) {
    Canvas(modifier = modifier.fillMaxSize()) {
        val width = size.width
        val height = size.height
        drawPath(
            Path().apply {
                moveTo(0f, 0f)
                cubicTo(
                    150f, 50f,    // Control point 1
                    250f, 150f,   // Control point 2
                    300f, 100f    // End point
                )
            }, color = Color.Red, style = Stroke(
                width = 10f
            )
        )
    }
}