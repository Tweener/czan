plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.kotlin.multiplatform.library)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.jetbrains.compose.compiler)
}

kotlin {
    applyDefaultHierarchyTemplate()

    androidLibrary {
        namespace = ProjectConfiguration.Czan.packageName + ".sample.shared"
        compileSdk = ProjectConfiguration.Czan.compileSDK
        minSdk = ProjectConfiguration.Czan.minSDK
    }

    listOf(
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "shared"
            isStatic = true

            export(project(":czan"))
        }
    }

    sourceSets {
        commonMain.dependencies {
            api(project(":czan"))

            // Compose
            implementation(libs.compose.multiplatform.runtime)
            implementation(libs.compose.multiplatform.foundation)
            implementation(libs.compose.multiplatform.material)
            implementation(libs.compose.multiplatform.ui)
            implementation(libs.compose.multiplatform.material3)
        }
    }
}
