package com.scouting.app.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.scouting.app.R

@Composable
fun LargeButton(
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    icon: Painter? = null,
    contentDescription: String? = null,
    onClick: () -> Unit,
    color: Color,
    colorBorder: Color
) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .height(80.dp)
            .clip(MaterialTheme.shapes.large)
            .border(
                width = 3.5.dp,
                color = colorBorder,
                shape = MaterialTheme.shapes.large
            ),
        enabled = enabled,
        onClick = onClick,
        shape = MaterialTheme.shapes.large,
        elevation = ButtonDefaults.buttonElevation(0.dp),
        colors = ButtonDefaults.buttonColors(containerColor = color)
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = text,
                style = MaterialTheme.typography.bodyLarge,
                fontSize = dimensionResource(id = R.dimen.button_large_text_size).value.sp,
                modifier = Modifier.align(Alignment.Center)
            )
            icon?.let {
                Icon(
                    painter = it,
                    contentDescription = contentDescription,
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(end = 20.dp)
                )
            }
        }
    }
}

@Composable
fun MediumButton(
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    icon: Painter? = null,
    contentDescription: String? = null,
    onClick: () -> Unit,
    color: Color
) {
    Button(
        modifier = modifier
            .height(55.dp)
            .clip(MaterialTheme.shapes.medium),
        enabled = enabled,
        onClick = onClick,
        shape = MaterialTheme.shapes.medium,
        elevation = ButtonDefaults.buttonElevation(0.dp),
        colors = ButtonDefaults.buttonColors(containerColor = color)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = text,
                style = MaterialTheme.typography.bodyLarge,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            icon?.let {
                Icon(
                    painter = it,
                    contentDescription = contentDescription,
                    modifier = Modifier
                        .size(35.dp)
                        .padding(horizontal = 10.dp)
                )
            }
        }
    }
}

@Composable
fun SmallButton(
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    icon: Painter? = null,
    contentDescription: String? = null,
    onClick: () -> Unit,
    color: Color,
    outlineStyle: Boolean? = false
) {
    Button(
        modifier = modifier
            .height(50.dp)
            .clip(MaterialTheme.shapes.medium)
            .border(
                width = if (outlineStyle == true) 2.5.dp else 0.dp,
                color = color,
                shape = MaterialTheme.shapes.medium
            ),
        enabled = enabled,
        shape = MaterialTheme.shapes.medium,
        onClick = onClick,
        elevation = ButtonDefaults.buttonElevation(0.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (outlineStyle == true) Color.Transparent else color
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            icon?.let {
                Icon(
                    painter = it,
                    contentDescription = contentDescription
                )
            }
            if (text.isNotEmpty()) {
                Text(
                    text = text,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(
                        start = if (icon != null) 15.dp else 0.dp
                    )
                )
            }
        }
    }
}