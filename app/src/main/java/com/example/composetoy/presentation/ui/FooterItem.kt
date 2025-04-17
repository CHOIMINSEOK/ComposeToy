package com.example.composetoy.presentation.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.composetoy.domain.model.Footer
import com.example.composetoy.domain.model.FooterType

@Composable
fun FooterItem(footer: Footer, onClick: (type: FooterType) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .border(width = 1.dp, color = Color.Gray, shape = RoundedCornerShape(100))
            .padding(horizontal = 20.dp, vertical = 8.dp)
            .clickable { onClick(footer.type) },
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (footer.iconURL != null) {
            AsyncImage(
                model = footer.iconURL,
                contentDescription = "footer icon"
            )
            Spacer(modifier = Modifier.size(4.dp))
        }
        Text(text = footer.title)
    }
}