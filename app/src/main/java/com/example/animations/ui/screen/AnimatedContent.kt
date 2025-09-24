package com.example.animations.ui.screen

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AnimatedContentScreen() {
    Column(modifier = Modifier.padding(10.dp)) {
        var count by remember { mutableIntStateOf(0) }

        Text(
            "Animated Content",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(bottom = 10.dp)
        )

        HorizontalDivider()

        AnimatedContent(
            targetState = count,
            transitionSpec = {
                (slideInVertically { height -> height } + fadeIn() togetherWith
                        slideOutVertically { height -> -height } + fadeOut())
                    .using(
                        SizeTransform(clip = false)
                    )
            },
            label = "animated content"
        ) { targetCount ->
            Text(text = "$targetCount", style = MaterialTheme.typography.titleLarge, modifier = Modifier.padding(vertical = 10.dp))
        }

        Button(onClick = { count++ }) {
            Text("Add")
        }
    }

}