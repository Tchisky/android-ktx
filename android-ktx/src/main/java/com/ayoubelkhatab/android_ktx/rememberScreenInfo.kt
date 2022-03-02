package com.ayoubelkhatab.android_ktx

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Determines the screen info of the device, and returns screen type [ScreenInfo]
 */
@Composable
fun rememberScreenInfo(): ScreenInfo {
    val configuration = LocalConfiguration.current
    return ScreenInfo(
        widthInfo = when {
            configuration.screenWidthDp < 600 -> ScreenType.Normal
            configuration.screenWidthDp < 840 -> ScreenType.Medium
            else -> ScreenType.Large
        },
        heightInfo = when {
            configuration.screenWidthDp < 480 -> ScreenType.Normal
            configuration.screenWidthDp < 900 -> ScreenType.Medium
            else -> ScreenType.Large
        },
        width = configuration.screenWidthDp.dp,
        height = configuration.screenHeightDp.dp,
    )
}

/**
 * holds info about the current screen configuration
 * [widthInfo] type of the width [ScreenType.Normal] or [ScreenType.Medium] or [ScreenType.Large]
 * [heightInfo] type of the width [ScreenType.Normal] or [ScreenType.Medium] or [ScreenType.Large]
 * [width] current width in [Dp]
 * [height] current height in [Dp]
 */
data class ScreenInfo(
    val widthInfo: ScreenType,
    val heightInfo: ScreenType,
    val width: Dp,
    val height: Dp,
)

/**
 * type of screen
 * [Normal] is the normal phone screen size, width < 600dp
 * [Medium] is a phone or tablet with medium screen size, 840dp < width >= 600dp
 * [Large] is a tablet with large screen size, width >= 840dp
 */
sealed class ScreenType {
    object Normal : ScreenType()
    object Medium : ScreenType()
    object Large : ScreenType()
}
