import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("org.jetbrains.compose")
    id("org.jetbrains.kotlin.plugin.compose")
    id("org.jetbrains.dokka")
    id("maven-publish")
    id("signing")
}

android {
    namespace = Dependencies.Versions.Czan.namespace
    compileSdk = Dependencies.Versions.Czan.compileSDK

    defaultConfig {
        minSdk = Dependencies.Versions.Czan.minSDK

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

    compileOptions {
        sourceCompatibility = Dependencies.Versions.Compiler.javaCompatibility
        targetCompatibility = Dependencies.Versions.Compiler.javaCompatibility

        isCoreLibraryDesugaringEnabled = true
    }

    dependencies {
        coreLibraryDesugaring(Dependencies.Libraries.Android.desugarJdkLibs)
    }
}

kotlin {
    applyDefaultHierarchyTemplate()

    androidTarget {
        publishLibraryVariants("release")


        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.fromTarget(Dependencies.Versions.Compiler.jvmTarget))
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "czan"
            isStatic = true
        }
    }

    sourceSets {

        commonMain.dependencies {
            implementation(project.dependencies.platform(Dependencies.Libraries.Tweener.bom))
            implementation(Dependencies.Libraries.Tweener.common)

            implementation(Dependencies.Libraries.annotations)
            implementation(Dependencies.Libraries.shimmer)

            // Compose
            implementation(compose.ui)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.materialIconsExtended)
            implementation(compose.runtime)
            implementation(compose.components.resources)
            implementation(Dependencies.Libraries.ComposeMultiplatform.material3)

            // Image fetcher
            implementation(Dependencies.Libraries.Coil.compose)
            implementation(Dependencies.Libraries.Coil.network)

            // Cupertino Compose: iOS look & feel
            implementation(Dependencies.Libraries.cupertinoCompose)
        }

        androidMain.dependencies {
            // Accompanist
            implementation(Dependencies.Libraries.Android.Accompanist.systemUIController)

            // Compose
            api(compose.preview)
            api(compose.uiTooling)
            implementation(Dependencies.Libraries.Android.AndroidX.Compose.activity)
            implementation(Dependencies.Libraries.Android.AndroidX.Compose.lifecycleRuntime)

            // Image fetcher
            implementation(Dependencies.Libraries.Ktor.Client.Android.okhttp) // HTTPClient to use with Coil to fetch images
        }

        iosMain.dependencies {
            // Image fetcher
            implementation(Dependencies.Libraries.Ktor.Client.iOS.client) // HTTPClient to use with Coil to fetch images
        }
    }
}

// region Publishing

// Dokka configuration
val dokkaOutputDir = buildDir.resolve("dokka")
tasks.dokkaHtml { outputDirectory.set(file(dokkaOutputDir)) }
val deleteDokkaOutputDir by tasks.register<Delete>("deleteDokkaOutputDirectory") { delete(dokkaOutputDir) }
val javadocJar = tasks.create<Jar>("javadocJar") {
    archiveClassifier.set("javadoc")
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    dependsOn(deleteDokkaOutputDir, tasks.dokkaHtml)
    from(dokkaOutputDir)
}

group = Dependencies.Versions.Czan.Maven.group
version = Dependencies.Versions.Czan.versionName

publishing {
    publications {
        publications.withType<MavenPublication> {
            artifact(javadocJar)

            pom {
                name.set("C-ZAN")
                description.set("C-ZAN Design System for Kotlin Multiplatform and Compose Multiplatform")
                url.set(Dependencies.Versions.Czan.Maven.packageUrl)

                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }

                issueManagement {
                    system.set("GitHub Issues")
                    url.set("${Dependencies.Versions.Czan.Maven.packageUrl}/issues")
                }

                developers {
                    developer {
                        id.set("Tweener")
                        name.set("Vivien Mahé")
                        email.set("vivien@tweener-labs.com")
                    }
                }

                scm {
                    connection.set("scm:git:git://${Dependencies.Versions.Czan.Maven.gitUrl}")
                    developerConnection.set("scm:git:ssh://${Dependencies.Versions.Czan.Maven.gitUrl}")
                    url.set(Dependencies.Versions.Czan.Maven.packageUrl)
                }
            }
        }
    }
}

signing {
    if (project.hasProperty("signing.gnupg.keyName")) {
        println("Signing lib...")
        useGpgCmd()
        sign(publishing.publications)
    }
}

// endregion Publishing
