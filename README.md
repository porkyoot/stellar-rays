<div align="center">

<img src="src/main/resources/assets/stellar_rays/icon.png" alt="Stellar Rays Icon" width="128" height="128" />

# ✨ Stellar Rays

**Purely client-side visual enhancement, camera control, and ray rendering mod for Minecraft.**

[![Minecraft](https://img.shields.io/badge/Minecraft-26.1.2+%20%2F%2026.2-blue.svg)](https://www.minecraft.net/)
[![Loader](https://img.shields.io/badge/Loader-Quilt-purple.svg)](https://quiltmc.org/)
[![Language](https://img.shields.io/badge/Kotlin-2.4-orange.svg)](https://kotlinlang.org/)
[![Java](https://img.shields.io/badge/Java-21-red.svg)](https://adoptium.net/)
[![Environment](https://img.shields.io/badge/Environment-100%25%20Client--Side-blueviolet.svg)](#-technical-details)

</div>

---

## 📖 About

**Stellar Rays** is a dedicated 100% client-side visual enhancement mod in the Stellar suite. It provides customizable ray tracing vectors, targeted line-of-sight visualizers, customizable gamma boost, and advanced rendering utilities without requiring any server-side dependencies.

---

## ⚙️ Features

* **Targeted Ray Tracing:** Visual line-of-sight ray indicators with customizable distance, thickness, and color.
* **Fullbright Boost:** Enhanced gamma boost for clear visibility in dark environments.
* **Cloth Config & ModMenu:** Fully integrated GUI configuration with hot-reloading settings.
* **Pure Client Execution:** Zero server-side packets or dependencies; safe for all client installations.

---

## 🛠️ Build & Development

```bash
# Build mod JAR
./gradlew :stellar-rays:build

# Run tests
./gradlew :stellar-rays:test

# Run Detekt linter
./gradlew :stellar-rays:detekt
```
