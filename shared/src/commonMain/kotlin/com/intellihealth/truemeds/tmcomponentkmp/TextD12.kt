package com.intellihealth.truemeds.tmcomponentkmp


import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TextD12(text: String, fontWeight: FontWeight, modifier: Modifier?, color: Color?=null) =
    if (color == null) {
        Text(
            text,
            fontSize = 12.sp,
            style = TextStyle(fontWeight = fontWeight),
            modifier = modifier ?: Modifier
                .wrapContentSize()
                .padding(8.dp)
        )
    } else Text(
        text,
        fontSize = 12.sp,
        color = color,
        style = TextStyle(fontWeight = fontWeight),
        modifier = modifier ?: Modifier
            .wrapContentSize()
            .padding(8.dp)
    )

