# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

CZAN is a Kotlin Multiplatform design system for Compose Multiplatform, following Atomic Design methodology. It provides reusable UI components organized as atoms, molecules, and organisms.

## Build and Development Commands

### Common Gradle Tasks
- `./gradlew build` - Build the entire project
- `./gradlew test` - Run tests
- `./gradlew publishToMavenLocal` - Publish to local Maven (also copies demo samples to docs)
- `./gradlew dependencyUpdates` - Check for dependency updates
- `./gradlew copyDemoSamples` - Copy JS demo build to docs directory

### Platform-Specific Tasks
- `./gradlew jsBrowserDistribution` - Build JS distribution for web demos
- `./gradlew wasmJsBrowserDistribution` - Build WASM distribution
- `./gradlew assembleRelease` - Build Android release variant

### Documentation
- `mkdocs serve` - Start local documentation server (requires Python venv setup)
- `mkdocs build` - Build documentation site

## Architecture and Code Organization

### Module Structure
- **Main module**: `czan/` - Contains the design system library
- **Sample app**: `sample/` - Multiplatform demo application showcasing components
- **Documentation**: `docs/` - MkDocs-based documentation site

### Design System Organization
Components follow Atomic Design principles:

- **Atoms** (`czan/src/commonMain/kotlin/com/tweener/czan/designsystem/atom/`):
  - Basic building blocks: Button, Text, Icon, Checkbox, etc.
  - Each atom has its own directory with style enums and size configurations

- **Molecules** (`czan/src/commonMain/kotlin/com/tweener/czan/designsystem/molecule/`):
  - Combined atoms: Carousel, NumericKeyboard, ContextMenu, etc.

- **Organisms** (`czan/src/commonMain/kotlin/com/tweener/czan/designsystem/organism/`):
  - Complex components: Cards, etc.

### Platform-Specific Code
- `commonMain/` - Shared Compose UI code
- `androidMain/` - Android-specific implementations and previews
- `iosMain/` - iOS-specific code (limited)
- `jsMain/wasmJsMain/` - Web platform implementations
- `nonIosMain/` - Shared code for non-iOS platforms

### Key Files
- `buildSrc/src/main/kotlin/ProjectConfiguration.kt` - Project configuration and versioning
- `gradle/libs.versions.toml` - Dependency version catalog
- `czan/src/commonMain/kotlin/com/tweener/czan/theme/CzanTheme.kt` - Main theme component

### Preview System
Each component includes comprehensive Compose previews in:
- `czan/src/androidMain/kotlin/com/tweener/czan/preview/` - Preview implementations
- `czan/src/commonMain/kotlin/demo/` - Demo implementations for web builds

## Development Workflow

### Adding New Components
1. Create component in appropriate atomic level directory
2. Add companion style/size enums if needed
3. Create preview in `androidMain/preview/` directory
4. Add demo implementation in `demo/` directory
5. Update documentation in `docs/` if needed

### Publishing
The project uses Vanniktech Maven Publish plugin with automatic releases to Maven Central. Version is controlled in `ProjectConfiguration.kt:12`.

### Testing
- `./gradlew iosSimulatorArm64Test` - Run iOS simulator tests
- `./gradlew testReleaseUnitTest` - Run Android release unit tests

### Supported Platforms
- Android (minSdk 24, compileSdk 35)
- iOS (arm64, x64, simulator)
- JVM Desktop
- JavaScript (browser)
- WASM (browser)

## Contributing Guidelines
Pull requests should target the `develop` branch. Include visual assets (images, videos, GIFs) to showcase changes. Update documentation for API changes.