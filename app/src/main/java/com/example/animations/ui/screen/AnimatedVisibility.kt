package com.example.animations.ui.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterExitState
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AnimatedVisibilityScreen() {
    Column(modifier = Modifier.padding(10.dp)) {
        var visible by remember { mutableStateOf(true) }
        Text("Animated Visibility", style = MaterialTheme.typography.bodyLarge, modifier = Modifier.padding(bottom = 10.dp))

        HorizontalDivider()

        AnimatedVisibility(
            visible = visible,
            enter = expandVertically(tween(durationMillis = 500), expandFrom = Alignment.Top),
            exit = scaleOut(tween(durationMillis = 500)),
        ) {
            val textColor by transition.animateColor(label = "color") { state ->
                if (state == EnterExitState.Visible) Color.DarkGray else Color.Blue
            }

            Text(
                "Hello, Android!",
                color = textColor,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.fillMaxWidth().padding(vertical = 5.dp)
            )
        }

        Button(
            onClick = { visible = !visible },
            modifier = Modifier.fillMaxWidth().height(50.dp).padding(vertical = 5.dp),
        ){
            Text("Hide text")
        }
    }

}