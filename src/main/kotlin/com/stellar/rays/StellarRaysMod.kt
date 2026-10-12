package com.stellar.rays

import com.stellar.core.StellarCore
import com.stellar.core.config.ConfigManager
import com.stellar.rays.config.StellarRaysConfig
import net.fabricmc.api.ClientModInitializer
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * Dedicated client entry point for the Stellar Rays mod (100% client-side).
 */
class StellarRaysMod : ClientModInitializer {
    private val logger: Logger = LoggerFactory.getLogger(MOD_ID)

    override fun onInitializeClient() {
        StellarCore.logInfo("Initializing Stellar Rays under namespace ${StellarCore.NAMESPACE}")
        logger.info("Initializing client mod Stellar Rays")

        val config = ConfigManager.register(MOD_ID, "main", StellarRaysConfig::class.java)
        logger.info("Stellar Rays config loaded (enabled={})", config.enabled.value())
    }

    companion object {
        const val MOD_ID: String = "stellar_rays"
    }
}
