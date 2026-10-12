package com.stellar.rays.config

import com.terraformersmc.modmenu.api.ConfigScreenFactory
import com.terraformersmc.modmenu.api.ModMenuApi

/**
 * ModMenu integration for Stellar Rays.
 */
class StellarRaysModMenu : ModMenuApi {
    override fun getModConfigScreenFactory(): ConfigScreenFactory<*> {
        return ConfigScreenFactory { parent ->
            RaysClothConfigScreen.create(parent)
        }
    }
}
