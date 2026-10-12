package com.stellar.rays.config

import com.stellar.core.config.ConfigManager
import com.stellar.rays.StellarRaysMod
import me.shedaniel.clothconfig2.api.ConfigBuilder
import me.shedaniel.clothconfig2.api.ConfigCategory
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder
import net.minecraft.client.gui.screens.Screen
import net.minecraft.network.chat.Component

/**
 * Factory for creating the Cloth Config GUI screen bound to StellarRaysConfig.
 */
object RaysClothConfigScreen {
    fun create(parent: Screen?): Screen {
        val config = ConfigManager.get<StellarRaysConfig>(StellarRaysMod.MOD_ID, "main")
            ?: ConfigManager.register(StellarRaysMod.MOD_ID, "main", StellarRaysConfig::class.java)

        val builder = ConfigBuilder.create()
            .setParentScreen(parent)
            .setTitle(Component.translatable("stellar_rays.config.title"))

        builder.setSavingRunnable {
            config.save()
        }

        val entryBuilder = builder.entryBuilder()
        buildGeneralCategory(builder, entryBuilder, config)
        buildRenderingCategory(builder, entryBuilder, config)

        return builder.build()
    }

    private fun buildGeneralCategory(builder: ConfigBuilder, entries: ConfigEntryBuilder, config: StellarRaysConfig) {
        val category = builder.getOrCreateCategory(Component.translatable("stellar_rays.config.category.general"))

        val enabledEntry = entries
            .startBooleanToggle(
                Component.translatable("stellar_rays.config.enabled"),
                config.enabled.value(),
            )
            .setDefaultValue(true)
            .setTooltip(Component.translatable("stellar_rays.config.enabled.tooltip"))
            .setSaveConsumer { value -> config.enabled.setValue(value, true) }
            .build()

        val fullbrightEntry = entries
            .startBooleanToggle(
                Component.translatable("stellar_rays.config.fullbright_boost"),
                config.fullbrightBoost.value(),
            )
            .setDefaultValue(false)
            .setTooltip(Component.translatable("stellar_rays.config.fullbright_boost.tooltip"))
            .setSaveConsumer { value -> config.fullbrightBoost.setValue(value, true) }
            .build()

        category.addEntry(enabledEntry)
        category.addEntry(fullbrightEntry)
    }

    private fun buildRenderingCategory(builder: ConfigBuilder, entries: ConfigEntryBuilder, config: StellarRaysConfig) {
        val category = builder.getOrCreateCategory(Component.translatable("stellar_rays.config.category.rendering"))
        addRayDisplayEntries(category, entries, config)
        addRayStyleEntries(category, entries, config)
    }

    private fun addRayDisplayEntries(category: ConfigCategory, entries: ConfigEntryBuilder, config: StellarRaysConfig) {
        val showTargetedRayEntry = entries
            .startBooleanToggle(
                Component.translatable("stellar_rays.config.show_targeted_ray"),
                config.showTargetedRay.value(),
            )
            .setDefaultValue(true)
            .setTooltip(Component.translatable("stellar_rays.config.show_targeted_ray.tooltip"))
            .setSaveConsumer { value -> config.showTargetedRay.setValue(value, true) }
            .build()

        val rayDistanceEntry = entries
            .startDoubleField(
                Component.translatable("stellar_rays.config.ray_tracing_distance"),
                config.rayTracingDistance.value(),
            )
            .setDefaultValue(StellarRaysConfig.DEFAULT_RAY_DISTANCE)
            .setMin(StellarRaysConfig.MIN_RAY_DISTANCE)
            .setMax(StellarRaysConfig.MAX_RAY_DISTANCE)
            .setTooltip(Component.translatable("stellar_rays.config.ray_tracing_distance.tooltip"))
            .setSaveConsumer { value -> config.rayTracingDistance.setValue(value, true) }
            .build()

        category.addEntry(showTargetedRayEntry)
        category.addEntry(rayDistanceEntry)
    }

    private fun addRayStyleEntries(category: ConfigCategory, entries: ConfigEntryBuilder, config: StellarRaysConfig) {
        val rayThicknessEntry = entries
            .startFloatField(
                Component.translatable("stellar_rays.config.ray_thickness"),
                config.rayThickness.value(),
            )
            .setDefaultValue(StellarRaysConfig.DEFAULT_THICKNESS)
            .setMin(StellarRaysConfig.MIN_THICKNESS)
            .setMax(StellarRaysConfig.MAX_THICKNESS)
            .setTooltip(Component.translatable("stellar_rays.config.ray_thickness.tooltip"))
            .setSaveConsumer { value -> config.rayThickness.setValue(value, true) }
            .build()

        val rayColorEntry = entries
            .startStrField(
                Component.translatable("stellar_rays.config.ray_color"),
                config.rayColorHex.value(),
            )
            .setDefaultValue(StellarRaysConfig.DEFAULT_RAY_COLOR)
            .setTooltip(Component.translatable("stellar_rays.config.ray_color.tooltip"))
            .setSaveConsumer { value -> config.rayColorHex.setValue(value.trim(), true) }
            .build()

        category.addEntry(rayThicknessEntry)
        category.addEntry(rayColorEntry)
    }
}
