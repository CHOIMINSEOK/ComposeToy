package com.example.composetoy.presentation.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.Placeable
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.composetoy.domain.model.Style
import kotlin.math.roundToInt

@Composable
fun StyleItem(
    styles: List<Style>
) {
    Layout(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp),
        content = {
            styles.forEach { style ->
                AsyncImage(
                    model = style.thumbnailURL,
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                )
            }
        }
    ) { measurables, constraints ->

        val columnCount = 3
        val itemSpacing = 4.dp.roundToPx()
        val cellWidth = (constraints.maxWidth - itemSpacing * (columnCount - 1)) / columnCount
        val cellHeight = (cellWidth * 1.5).roundToInt()

        val placeables = mutableListOf<PlaceableWithPosition>()

        var currentRow = 0
        var nextCol = 0

        measurables.forEachIndexed { index, measurable ->
            if (index == 0) {
                // 첫 번째 아이템: 2x2 span
                val width = cellWidth * 2 + itemSpacing
                val height = cellHeight * 2 + itemSpacing

                val placeable = measurable.measure(
                    Constraints.fixed(width, height)
                )

                placeables += PlaceableWithPosition(
                    placeable,
                    x = 0,
                    y = 0
                )

                nextCol = 2
            } else {
                // 나머지 아이템

                // 열을 다 채웠을 경우 줄 바꿈 처리
                if (nextCol >= columnCount) {
                    currentRow++
                    nextCol = 0
                }

                // 첫번 째 Item이 2x2 사이즈를 가지므로 두번째 행은 3번째 열부터 채운다.
                if (currentRow == 1 && nextCol < 2) {
                    nextCol = 2
                }

                val x = nextCol * (cellWidth + itemSpacing)
                val y = currentRow * (cellHeight + itemSpacing)

                val placeable = measurable.measure(
                    Constraints.fixed(cellWidth, cellHeight)
                )

                placeables += PlaceableWithPosition(
                    placeable,
                    x = x,
                    y = y
                )

                nextCol++
            }
        }

        val totalHeight = placeables.maxOfOrNull { it.y + it.placeable.height } ?: 0

        layout(
            width = constraints.maxWidth,
            height = totalHeight
        ) {
            placeables.forEach {
                it.placeable.place(it.x, it.y)
            }
        }
    }
}

private data class PlaceableWithPosition(
    val placeable: Placeable,
    val x: Int,
    val y: Int
)