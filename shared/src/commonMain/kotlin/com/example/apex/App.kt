package com.example.apex

import androidx.compose.ui.Modifier
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import androidx.savedstate.serialization.SavedStateConfiguration
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.modules.subclass
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import org.jetbrains.compose.resources.stringResource
import f1archive.shared.generated.resources.Res
import f1archive.shared.generated.resources.theme_dark
import f1archive.shared.generated.resources.theme_light
import androidx.compose.runtime.CompositionLocalProvider

private val navConfig = SavedStateConfiguration {
    serializersModule = SerializersModule {
        polymorphic(NavKey::class) {
            subclass(
                Route.RaceList::class,
                Route.RaceList.serializer()
            )
            subclass(
                Route.RaceDetails::class,
                Route.RaceDetails.serializer()
            )
        }
    }
}

@Composable
@Preview
fun App() {
    var darkTheme by remember { mutableStateOf(false) }
    var language by remember { mutableStateOf("en") }

    AppTheme(darkTheme = darkTheme)
    {

        val backStack = rememberNavBackStack(
            navConfig,
            Route.RaceList
        )
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Button(
                onClick = {
                    darkTheme = !darkTheme
                }
            ) {
                Text(
                    text = if (darkTheme) {
                        stringResource(Res.string.theme_light)
                    } else {
                        stringResource(Res.string.theme_dark)
                    }
                )
            }

            Button(
                onClick = {
                    language = if (language == "en") "ru" else "en"
                }
            ) {
                Text(
                    text = if (language == "en") "Русский" else "English"
                )
            }

            NavDisplay(
                backStack = backStack,

                transitionSpec = {
                    slideInHorizontally(
                        initialOffsetX = { it }
                    ) togetherWith slideOutHorizontally(
                        targetOffsetX = { -it }
                    )
                },

                popTransitionSpec = {
                    slideInHorizontally(
                        initialOffsetX = { -it }
                    ) togetherWith slideOutHorizontally(
                        targetOffsetX = { it }
                    )
                },

                entryProvider = entryProvider {
                    entry<Route.RaceList> {
                        RaceListScreen(
                            races = races,
                            onRaceClick = { raceId ->
                                backStack.add(Route.RaceDetails(raceId))
                            }
                        )
                    }
                    entry<Route.RaceDetails> { route ->
                        RaceDetailsScreen(
                            raceId = route.raceId,
                            onBack = {
                                backStack.removeLastOrNull()
                            }
                        )
                    }
                }
            )
        }
    }
}