plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("maven-publish")
}

android {
    namespace = Dependencies.Versions.Cezanne.namespace
    compileSdk = Dependencies.Versions.Cezanne.compileSDK

    defaultConfig {
        minSdk = Dependencies.Versions.Cezanne.minSDK

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }

        getByName("debug") {
        }
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Dependencies.Versions.composeCompilerExtension
    }

    compileOptions {
        sourceCompatibility = Dependencies.Versions.Compiler.javaCompatibility
        targetCompatibility = Dependencies.Versions.Compiler.javaCompatibility

        isCoreLibraryDesugaringEnabled = true
    }

    kotlinOptions {
        jvmTarget = Dependencies.Versions.Compiler.jvmTarget
    }
}

dependencies {

    coreLibraryDesugaring(Dependencies.Libraries.desugarJdkLibs)

    implementation(Dependencies.Libraries.tweenerCommon)
    implementation(Dependencies.Libraries.napier)

    // Android
    implementation(Dependencies.Libraries.AndroidX.material3)
    implementation(Dependencies.Libraries.AndroidX.activity)

    // Accompanist
    implementation(Dependencies.Libraries.Accompanist.systemUIController)
    implementation(Dependencies.Libraries.Accompanist.placeholder)

    // Compose
    implementation(Dependencies.Libraries.AndroidX.Compose.ui)
    implementation(Dependencies.Libraries.AndroidX.Compose.uiTooling)
    implementation(Dependencies.Libraries.AndroidX.Compose.uiToolingPreview)
    implementation(Dependencies.Libraries.AndroidX.Compose.foundation)
    implementation(Dependencies.Libraries.AndroidX.Compose.material)
    implementation(Dependencies.Libraries.AndroidX.Compose.materialIconsCore)
    implementation(Dependencies.Libraries.AndroidX.Compose.materialIconsExtended)
    implementation(Dependencies.Libraries.AndroidX.Compose.activity)
    implementation(Dependencies.Libraries.AndroidX.Compose.navigation)
    implementation(Dependencies.Libraries.AndroidX.Compose.lifecycleRuntime)
}

afterEvaluate {
    publishing {
        publications {
            register("release", MavenPublication::class) {
                group = Dependencies.Versions.Cezanne.Jitpack.group
                artifactId = Dependencies.Versions.Cezanne.Jitpack.artifactId
                version = Dependencies.Versions.Cezanne.versionName

                from(components["release"])
            }
        }
    }
}
