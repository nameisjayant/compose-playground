package com.nameisjayant.composepractise.composePlayground

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CountdownSnackBar(modifier: Modifier = Modifier) {
    val mailList = remember {
        mutableStateListOf(MailData.getMailList())
    }
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(16.dp)
    ) {
        itemsIndexed(mailList) { index, item ->
            MailRow()
        }
    }
}

@Composable
fun MailRow(
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.padding(top = 12.dp),
        elevation = CardDefaults.cardElevation(5.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp)
        ) {
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Text(
                    text = "Laptop Replacement", style = TextStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 18.sp
                    )
                )
                Text(
                    text = "This mail is regarding laptop replacement...", style = TextStyle(
                        color = Color.Gray,
                        fontWeight = FontWeight.Light,
                        fontSize = 14.sp
                    )
                )
            }
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = null,
                    tint = Color.Red
                )
            }
        }
    }
}

data class MailModal(
    val title: String,
    val message: String
)

data object MailData {

    fun getMailList() = listOf(
        MailModal(
            "Laptop Replacement", "This mail is regarding laptop replacement..."
        ),
        MailModal(
            "Laptop Replacement", "This mail is regarding laptop replacement..."
        ),
        MailModal(
            "Laptop Replacement", "This mail is regarding laptop replacement..."
        ),
        MailModal(
            "Laptop Replacement", "This mail is regarding laptop replacement..."
        ),
        MailModal(
            "Laptop Replacement", "This mail is regarding laptop replacement..."
        ),
        MailModal(
            "Laptop Replacement", "This mail is regarding laptop replacement..."
        ),
        MailModal(
            "Laptop Replacement", "This mail is regarding laptop replacement..."
        )
    )

}