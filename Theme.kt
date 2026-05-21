package com.example.jalrakshakapp.ui.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Primary Colors
val md_theme_light_primary = Color(0xFF4CAF50)      // Green
val md_theme_light_onPrimary = Color.White

val md_theme_light_secondary = Color(0xFF2196F3)    // Blue
val md_theme_light_onSecondary = Color.White

val md_theme_light_background = Color(0xFFF5F5F5)   // Light gray background
val md_theme_light_onBackground = Color.Black

val md_theme_light_surface = Color(0xFFFFFFFF)      // White cards
val md_theme_light_onSurface = Color.Black

val md_theme_light_error = Color(0xFFF44336)        // Red
val md_theme_light_onError = Color.White

// Dark theme colors (optional)
val md_theme_dark_primary = Color(0xFF4CAF50)
val md_theme_dark_onPrimary = Color.Black

val md_theme_dark_secondary = Color(0xFF2196F3)
val md_theme_dark_onSecondary = Color.Black

val md_theme_dark_background = Color(0xFF121212)
val md_theme_dark_onBackground = Color.White

val md_theme_dark_surface = Color(0xFF1E1E1E)
val md_theme_dark_onSurface = Color.White

val md_theme_dark_error = Color(0xFFCF6679)
val md_theme_dark_onError = Color.Black

// Theme Composable
@Composable
fun JalrakshakAppTheme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        darkColorScheme(
            primary = md_theme_dark_primary,
            onPrimary = md_theme_dark_onPrimary,
            secondary = md_theme_dark_secondary,
            onSecondary = md_theme_dark_onSecondary,
            background = md_theme_dark_background,
            onBackground = md_theme_dark_onBackground,
            surface = md_theme_dark_surface,
            onSurface = md_theme_dark_onSurface,
            error = md_theme_dark_error,
            onError = md_theme_dark_onError
        )
    } else {
        lightColorScheme(
            primary = md_theme_light_primary,
            onPrimary = md_theme_light_onPrimary,
            secondary = md_theme_light_secondary,
            onSecondary = md_theme_light_onSecondary,
            background = md_theme_light_background,
            onBackground = md_theme_light_onBackground,
            surface = md_theme_light_surface,
            onSurface = md_theme_light_onSurface,
            error = md_theme_light_error,
            onError = md_theme_light_onError
        )
    }

    MaterialTheme(
        colorScheme = colors,
        typography = Typography(),
        content = content
    )
}
