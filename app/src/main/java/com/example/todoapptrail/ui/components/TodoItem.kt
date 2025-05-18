package com.example.todoapptrail.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todoapptrail.model.Todo


@Composable
fun TodoItem(
    todo: Todo,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isFirstItem: Boolean = false
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .padding(
                top = if (isFirstItem) 16.dp else 8.dp,
                bottom = 12.dp
            )
            .clickable { onClick() },
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        Text(
            text = todo.title,
            style = MaterialTheme.typography.bodyLarge.copy(
                fontWeight = FontWeight.Normal,
                lineHeight = 24.sp
            ),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(bottom = 4.dp)
        )

             Box(
            modifier = Modifier
                .wrapContentWidth()
                .clip(RoundedCornerShape(16.dp))
                .background(
                    if (todo.completed) Color(0xFF2E7D32).copy(alpha = 0.1f)
                    else Color(0xFFF57C00).copy(alpha = 0.1f)
                )
//
                .padding(horizontal = 14.dp, vertical = 8.dp)
        ) {
            Text(
                text = if (todo.completed) "Completed" else "Pending",
                color = if (todo.completed) Color(0xFF2E7D32)
                else Color(0xFFF57C00),
                style = MaterialTheme.typography.labelLarge.copy(
                    fontWeight = FontWeight.Medium,
                    letterSpacing = 0.5.sp
                )
            )
        }
    }


    Divider(
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 4.dp),
        thickness = 1.dp,
        color = MaterialTheme.colorScheme.outline.copy(alpha = 0.1f)
    )
}