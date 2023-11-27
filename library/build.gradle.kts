plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("maven-publish")
}

android {
    namespace = Dependencies.Versions.Czan.namespace
    compileSdk = Dependencies.Versions.Czan.compileSDK

    defaultConfig {
        minSdk = Dependencies.Versions.Czan.minSDK

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

    // Tweener
    implementation(Dependencies.Libraries.Tweener.Android.common)
    implementation(Dependencies.Libraries.Tweener.Android.placeholder)

    // Android
    implementation(Dependencies.Libraries.AndroidX.material3)
    implementation(Dependencies.Libraries.AndroidX.activity)

    // Accompanist
    implementation(Dependencies.Libraries.Accompanist.systemUIController)

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

    // Image fetcher
    implementation(Dependencies.Libraries.glide)
    implementation(Dependencies.Libraries.glidePlaceholder)
}

afterEvaluate {
    publishing {
        publications {
            register("release", MavenPublication::class) {
                group = Dependencies.Versions.Czan.Jitpack.group
                artifactId = Dependencies.Versions.Czan.Jitpack.artifactId
                version = Dependencies.Versions.Czan.versionName

                from(components["release"])
            }
        }
    }
}
