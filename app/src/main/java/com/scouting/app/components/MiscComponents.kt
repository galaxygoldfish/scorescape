package com.scouting.app.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.scouting.app.theme.NeutralGrayMedium

@Composable
fun SheetHandle() {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Card(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 15.dp, bottom = 15.dp)
                .width(100.dp)
                .height(4.dp),
            shape = RoundedCornerShape(8.dp),
            colors = CardDefaults.cardColors(containerColor = NeutralGrayMedium),
            elevation = CardDefaults.cardElevation(0.dp)
        ) { }
    }
}

@Composable
fun BorderedCard(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Card(
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(0.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent),
        border = BorderStroke(2.dp, MaterialTheme.colorScheme.onBackground),
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 10.dp)
    ) {
        content.invoke()
    }
}

@Composable
fun DottedRoundBox(
    modifier: Modifier = Modifier,
    height: Dp,
    content: @Composable () -> Unit
) {
    MaterialTheme.colorScheme.let { themeColors ->
        Box(modifier = modifier) {
            Canvas(
                Modifier
                    .fillMaxWidth()
                    .height(height)
            ) {
                drawRoundRect(
                    color = themeColors.onBackground,
                    style = Stroke(
                        width = 2.5f,
                        pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
                    ),
                    cornerRadius = CornerRadius(15.0F, 15.0F)
                )
            }
            content.invoke()
        }
    }
}

@Composable
fun TabLayout(
    items: List<String>,
    selection: State<Int>,
    onSelectionChange: (Int) -> Unit,
    modifier: Modifier = Modifier,
    size: Int
) {
    Row(
        modifier = modifier
            .clip(MaterialTheme.shapes.medium)
            .background(color = MaterialTheme.colorScheme.background)
            .fillMaxWidth()
            .padding(horizontal = 10.dp)
    ) {
        items.forEachIndexed { index, text ->
            Column(
                modifier = Modifier
                    .fillMaxWidth(if (index == 0) 0.5F else 1F) // really bad practice sorry team
                    .padding(horizontal = 10.dp, vertical = 10.dp)
                    .clip(MaterialTheme.shapes.medium)
                    .border(
                        width = if (selection.value == index) 2.dp else 0.dp,
                        shape = MaterialTheme.shapes.medium,
                        color = if (selection.value == index) MaterialTheme.colorScheme.onBackground else Color.Transparent
                    )
                    .clickable {
                        onSelectionChange(index)
                    },
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = text,
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
                )
            }
        }
    }
}

@Composable
fun SpacedRow(
    modifier: Modifier = Modifier,
    horizontalPadding: Dp = 30.dp,
    content: @Composable () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = horizontalPadding),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        content.invoke()
    }
}

@Composable
fun SettingsDivider(modifier: Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth(0.8F)
            .clip(MaterialTheme.shapes.medium)
            .height(3.dp)
            .background(MaterialTheme.colorScheme.onBackground.copy(0.15F))
    ) {}
}