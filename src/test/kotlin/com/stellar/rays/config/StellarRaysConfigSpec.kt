package com.stellar.rays.config

import com.stellar.core.config.ConfigManager
import com.stellar.rays.StellarRaysMod
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

/**
 * Unit tests for StellarRaysConfig.
 */
class StellarRaysConfigSpec : FunSpec({
    test("config should register and initialize with expected defaults") {
        val config = ConfigManager.register(
            StellarRaysMod.MOD_ID,
            "test_config",
            StellarRaysConfig::class.java,
        )

        config.enabled.value() shouldBe true
        config.fullbrightBoost.value() shouldBe false
        config.showTargetedRay.value() shouldBe true
        config.rayTracingDistance.value() shouldBe StellarRaysConfig.DEFAULT_RAY_DISTANCE
        config.rayThickness.value() shouldBe StellarRaysConfig.DEFAULT_THICKNESS
        config.rayColorHex.value() shouldBe StellarRaysConfig.DEFAULT_RAY_COLOR
    }
})
