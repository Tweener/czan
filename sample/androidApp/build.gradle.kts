plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.compose.compiler)
}

android {
    namespace = ProjectConfiguration.Czan.packageName + ".sample"
    compileSdk = ProjectConfiguration.Czan.compileSDK

    defaultConfig {
        applicationId = ProjectConfiguration.Czan.packageName + ".sample"
        minSdk = ProjectConfiguration.Czan.minSDK
        targetSdk = ProjectConfiguration.Czan.compileSDK
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = ProjectConfiguration.Compiler.javaCompatibility
        targetCompatibility = ProjectConfiguration.Compiler.javaCompatibility
    }

    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(project(":sample:shared"))
    implementation(libs.android.activity)
    implementation(libs.android.activity.compose)
}
