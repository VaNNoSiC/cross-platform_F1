package com.example.apex

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.runtime.key
import androidx.compose.runtime.CompositionLocalProvider
import f1archive.shared.generated.resources.language_english
import f1archive.shared.generated.resources.language_russian
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import androidx.savedstate.serialization.SavedStateConfiguration
import com.example.apex.data.MockRaceRepository
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass
import org.jetbrains.compose.resources.stringResource
import f1archive.shared.generated.resources.Res
import f1archive.shared.generated.resources.theme_dark
import f1archive.shared.generated.resources.theme_light

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
            subclass(
                Route.CircuitDetails::class,
                Route.CircuitDetails.serializer()
            )
        }
    }
}

@Composable
fun App() {

    var darkTheme by remember { mutableStateOf(false) }
    var language by remember { mutableStateOf("ru") }

    val repository = remember { MockRaceRepository() }

    val backStack = rememberNavBackStack(
        navConfig,
        Route.RaceList
    )

    AppTheme(darkTheme = darkTheme) {
        CompositionLocalProvider(
            LocalAppLocale provides language
        ) {
            key(language) {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .safeDrawingPadding(),
                    contentWindowInsets = WindowInsets.safeDrawing,
                    topBar = {
                        Row {
                    Button(
                        onClick = { darkTheme = !darkTheme }
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
                            language = if (language == "ru") "en" else "ru"

                        },
                        modifier = Modifier.padding(start = 8.dp)
                    ) {
                        Text(
                            text = if (language == "ru") {
                                stringResource(Res.string.language_english)
                            } else {
                                stringResource(Res.string.language_russian)
                            }
                        )
                    }
                }
            }
        ) { paddingValues ->

            NavDisplay(
                backStack = backStack,

                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),

                transitionSpec = {
                    slideInHorizontally(
                        initialOffsetX = { it }
                    ) togetherWith
                            slideOutHorizontally(
                                targetOffsetX = { -it }
                            )
                },

                popTransitionSpec = {
                    slideInHorizontally(
                        initialOffsetX = { -it }
                    ) togetherWith
                            slideOutHorizontally(
                                targetOffsetX = { it }
                            )
                },

                entryProvider = entryProvider {

                    entry<Route.RaceList> {

                        val viewModel = remember {
                            RaceListViewModel(
                                repository = repository
                            )
                        }

                        val state by viewModel
                            .uiState
                            .collectAsStateWithLifecycle()

                        RaceListScreen(
                            state = state,

                            onSearchQueryChange = { query ->
                                viewModel.onSearchQueryChange(
                                    query
                                )
                            },

                            onRaceClick = { raceId ->
                                backStack.add(
                                    Route.RaceDetails(
                                        raceId = raceId
                                    )
                                )
                            }
                        )
                    }

                    entry<Route.RaceDetails> { route ->

                        val viewModel = remember {
                            RaceDetailsViewModel(
                                raceId = route.raceId,
                                repository = repository
                            )
                        }

                        val state by viewModel
                            .uiState
                            .collectAsStateWithLifecycle()

                        RaceDetailsScreen(
                            state = state,

                            onBack = {
                                backStack.removeLastOrNull()
                            },

                            onCircuitClick = { circuitId ->
                                backStack.add(
                                    Route.CircuitDetails(
                                        circuitId = circuitId
                                    )
                                )
                            }
                        )
                    }

                    entry<Route.CircuitDetails> { route ->

                        val viewModel = remember {
                            CircuitDetailsViewModel(
                                circuitId = route.circuitId,
                                repository = repository
                            )
                        }

                        val state by viewModel
                            .uiState
                            .collectAsStateWithLifecycle()

                        CircuitDetailsScreen(
                            state = state,

                            onBack = {
                                backStack.removeLastOrNull()
                            }
                        )
                    }
                }
            )
        }
    }
}}}