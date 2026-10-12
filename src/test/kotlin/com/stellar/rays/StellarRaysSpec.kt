package com.stellar.rays

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldNotBeBlank

/**
 * Basic unit test verifying Stellar Rays metadata and constants.
 */
class StellarRaysSpec : FunSpec({
    test("stellar rays mod id should be valid") {
        StellarRaysMod.MOD_ID.shouldNotBeBlank()
        StellarRaysMod.MOD_ID shouldBe "stellar_rays"
    }
})
