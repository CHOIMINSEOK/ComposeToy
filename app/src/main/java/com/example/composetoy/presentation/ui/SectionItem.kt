package com.example.composetoy.presentation.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.composetoy.domain.model.Section

@Composable
fun SectionItem(section: Section) {
    Text(text = section.toString())
}

@Preview
@Composable
fun SectionItemPreview() {

}