package ir.reza_mahmoudi.newsgram.core.presentation.design_system.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color

private val LightColorPalette = NewsgramColors(
    material = lightColorScheme(
        // You can override default colors
    ),
    designSystem = DesignSystem(

    )
)

private val DarkColorPalette = NewsgramColors(
    material = darkColorScheme(
        // You can override default colors
    ),
    designSystem = DesignSystem(
        Primary = Blue20,
        Primary00 = Blue00,
        Primary10 = Blue10,
        Primary20 = Blue20,
        Primary30 = Blue30,
        Primary40 = Blue40,

        Secondary = Lemon,

        Neutral00 = Gray50,
        Neutral10 = Gray40,
        Neutral20 = Gray30,
        Neutral30 = Gray20,
        Neutral40 = Gray10,
        Neutral50 = Gray00,

        PrimaryBackground = Gray40,

        PrimaryText = Gray00,
        SecondaryText = Lemon,
        TertiaryText = Gray50,
        PrimaryLink = Blue00,
        DisabledText = Gray20,

        BottomSheetBackground = Gray50,
        BottomSheetDefaultIcon = Gray10,
        BottomSheetSelectedIcon = Green00,
    )
)

private val MainTypography = NewsgramTypography(
    material = Typography
)

@Composable
fun NewsgramTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }
    CompositionLocalProvider(
        LocalColors provides colors
    ) {
        MaterialTheme(
            colorScheme = colors.material,
            typography = MainTypography.material,
            content = content,
        )
    }
}

private val LocalColors = staticCompositionLocalOf { LightColorPalette }

val MaterialTheme.NewsgramColors: NewsgramColors
    @Composable
    @ReadOnlyComposable
    get() = LocalColors.current

val MaterialTheme.NewsgramTypography: NewsgramTypography
    @Composable
    @ReadOnlyComposable
    get() = MainTypography