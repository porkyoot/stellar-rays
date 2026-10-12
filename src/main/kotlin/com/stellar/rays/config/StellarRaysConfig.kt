package com.stellar.rays.config

import org.quiltmc.config.api.ReflectiveConfig
import org.quiltmc.config.api.annotations.Comment
import org.quiltmc.config.api.values.TrackedValue

/**
 * Quilt ReflectiveConfig schema for Stellar Rays client-side visual and ray tracing enhancements.
 */
class StellarRaysConfig : ReflectiveConfig() {
    @Comment("Master switch enabling or disabling client-side ray features")
    val enabled: TrackedValue<Boolean> = value(true)

    @Comment("Maximum block distance for targeted ray casting")
    val rayTracingDistance: TrackedValue<Double> = value(DEFAULT_RAY_DISTANCE)

    @Comment("Enable fullbright gamma enhancement")
    val fullbrightBoost: TrackedValue<Boolean> = value(false)

    @Comment("Render target vectors and line-of-sight ray indicators")
    val showTargetedRay: TrackedValue<Boolean> = value(true)

    @Comment("Width of rendered ray traces in pixels")
    val rayThickness: TrackedValue<Float> = value(DEFAULT_THICKNESS)

    @Comment("Hexadecimal color format for visual rays (#AARRGGBB)")
    val rayColorHex: TrackedValue<String> = value(DEFAULT_RAY_COLOR)

    companion object {
        const val DEFAULT_RAY_DISTANCE: Double = 64.0
        const val MIN_RAY_DISTANCE: Double = 4.0
        const val MAX_RAY_DISTANCE: Double = 256.0

        const val DEFAULT_THICKNESS: Float = 2.0f
        const val MIN_THICKNESS: Float = 0.5f
        const val MAX_THICKNESS: Float = 10.0f

        const val DEFAULT_RAY_COLOR: String = "#8000E5FF"
    }
}
