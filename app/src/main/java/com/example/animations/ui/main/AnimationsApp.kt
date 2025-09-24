package com.example.animations.ui.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.animations.ui.screen.AnimatedContentScreen
import com.example.animations.ui.screen.AnimatedVisibilityScreen
import kotlinx.coroutines.launch

@Composable
fun AnimationsApp() {
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Column(
                    modifier = Modifier
                        .padding(5.dp)
                        .wrapContentWidth()
                        .verticalScroll(rememberScrollState())
                ) {
                    Spacer(Modifier.height(10.dp))
                    Text(
                        "Animations",
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.bodyMedium
                    )
                    HorizontalDivider()
                    NavigationDrawerItem(
                        label = {
                            Text(
                                AnimationScreens.AnimatedVisibility.title,
                                style = MaterialTheme.typography.titleMedium
                            )
                        },
                        selected = false,
                        onClick = {
                            scope.launch {
                                drawerState.apply { close() }
                            }
                            navController.navigate(AnimationScreens.AnimatedVisibility.name)
                        }
                    )
                    NavigationDrawerItem(
                        label = {
                            Text(
                                AnimationScreens.AnimatedContent.title,
                                style = MaterialTheme.typography.titleMedium
                            )
                        },
                        selected = false,
                        onClick = {
                            scope.launch {
                                drawerState.apply { close() }
                            }
                            navController.navigate(AnimationScreens.AnimatedContent.name)
                        }
                    )
                }
            }
        }
    ) {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = AnimationScreens.AnimatedVisibility.name,
                modifier = Modifier.padding(innerPadding)
            ) {
                composable(AnimationScreens.AnimatedVisibility.name) {
                    AnimatedVisibilityScreen()
                }
                composable(AnimationScreens.AnimatedContent.name) {
                    AnimatedContentScreen()
                }
            }
        }
    }
}