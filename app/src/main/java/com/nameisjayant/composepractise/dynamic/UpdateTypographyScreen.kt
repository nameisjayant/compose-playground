package com.nameisjayant.composepractise.dynamic

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.nameisjayant.composepractise.R
import com.nameisjayant.composepractise.ui.theme.getTypography


@Composable
fun UpdateTypographyScreen(modifier: Modifier = Modifier) {

    var fontSize by remember {
        mutableFloatStateOf(16F)
    }

    getTypography(fontSize = fontSize)

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = stringResource(R.string.hello_world))
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            fontSize = if (fontSize == 16f) 30f else 16f
        }) {
            Text(text = stringResource(R.string.update_font_size))
        }
    }

}