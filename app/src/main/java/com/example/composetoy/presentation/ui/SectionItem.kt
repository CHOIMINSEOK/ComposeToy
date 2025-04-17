package com.example.composetoy.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.composetoy.domain.model.Section

@Composable
fun SectionItem(section: Section) {
    Column(modifier = Modifier.background(color = Color.White)) {
        if (section.header != null) {
            HeaderItem(section.header)
        }
        Text(text = section.toString())
    }

}

@Preview
@Composable
fun SectionItemPreview() {

}