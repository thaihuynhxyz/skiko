package org.jetbrains.skiko.native

import org.jetbrains.skiko.GraphicsApi
import org.jetbrains.skiko.redrawer.Redrawer
import org.jetbrains.skiko.native.redrawer.LinuxOpenGLRedrawer

internal actual fun makePlatformOperations(): PlatformOperations {
    return object: PlatformOperations {
        override fun createRedrawer(layer: HardwareLayer, properties: SkiaLayerProperties): Redrawer =
            when (SkikoProperties.renderApi) {
                GraphicsApi.OPENGL -> LinuxOpenGLRedrawer(layer, properties)
                else -> error("No other renderings for native yet")
            }
    }
}