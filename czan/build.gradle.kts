import org.jetbrains.dokka.gradle.DokkaTask
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import java.net.URL

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.jetbrains.compose.compiler)
    alias(libs.plugins.dokka)
    id("maven-publish")
    id("signing")
}

android {
    namespace = ProjectConfiguration.Czan.namespace
    compileSdk = ProjectConfiguration.Czan.compileSDK

    defaultConfig {
        minSdk = ProjectConfiguration.Czan.minSDK

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
        sourceCompatibility = ProjectConfiguration.Compiler.javaCompatibility
        targetCompatibility = ProjectConfiguration.Compiler.javaCompatibility

        isCoreLibraryDesugaringEnabled = true
    }

    dependencies {
        coreLibraryDesugaring(libs.android.desugarjdklibs)
    }
}

kotlin {
    applyDefaultHierarchyTemplate()

    androidTarget {
        publishLibraryVariants("release")

        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.fromTarget(ProjectConfiguration.Compiler.jvmTarget))
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

    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser {
            commonWebpackConfig {
                outputFileName = "czan.js"
            }
        }
        binaries.executable()
    }

    js(IR) {
        browser {
            commonWebpackConfig {
                outputFileName = "czan.js"
            }
        }
        binaries.executable()
    }

    sourceSets {
        commonMain.dependencies {
            implementation(project.dependencies.platform(libs.tweener.bom))
            implementation(libs.tweener.common)

            implementation(libs.shimmer)

            // Compose
            implementation(compose.ui)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.materialIconsExtended)
            implementation(compose.runtime)
            implementation(compose.components.resources)
            implementation(libs.compose.multiplatform.material3)
            implementation(libs.compose.multiplatform.lifecycle)

            // Coil (Image fetcher)
            implementation(libs.bundles.coil)
        }

        androidMain.dependencies {
            // Compose
            api(compose.preview)
            api(compose.uiTooling)
            implementation(libs.android.activity.compose)

            // Image fetcher
            implementation(libs.ktor.client.android) // HTTPClient to use with Coil to fetch images
        }

        iosMain.dependencies {
            // Image fetcher
            implementation(libs.ktor.client.ios) // HTTPClient to use with Coil to fetch images
        }
    }
}

// region Publishing

group = ProjectConfiguration.Czan.Maven.group
version = ProjectConfiguration.Czan.versionName

// Dokka configuration
tasks.register<Jar>("dokkaJavadocJar") {
    dependsOn(tasks.dokkaHtml)
    from(tasks.dokkaHtml.flatMap { it.outputDirectory })
    archiveClassifier.set("javadoc")
}

tasks.withType<DokkaTask>().configureEach {
    dokkaSourceSets.configureEach {
        jdkVersion.set(ProjectConfiguration.Compiler.jvmTarget.toInt())
        languageVersion.set(libs.versions.kotlin)

        sourceLink {
            localDirectory.set(rootProject.projectDir)
            remoteUrl.set(URL(ProjectConfiguration.Czan.Maven.packageUrl + "/tree/main"))
            remoteLineSuffix.set("#L")
        }
    }
}

publishing {
    publications {
        publications.withType<MavenPublication> {
            artifact(tasks["dokkaJavadocJar"])

            pom {
                name.set(ProjectConfiguration.Czan.Maven.name)
                description.set(ProjectConfiguration.Czan.Maven.description)
                url.set(ProjectConfiguration.Czan.Maven.packageUrl)

                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }

                issueManagement {
                    system.set("GitHub Issues")
                    url.set("${ProjectConfiguration.Czan.Maven.packageUrl}/issues")
                }

                developers {
                    developer {
                        id.set("Tweener")
                        name.set("Vivien Mahé")
                        email.set("vivien@tweener-labs.com")
                    }
                }

                scm {
                    connection.set("scm:git:git://${ProjectConfiguration.Czan.Maven.gitUrl}")
                    developerConnection.set("scm:git:ssh://${ProjectConfiguration.Czan.Maven.gitUrl}")
                    url.set(ProjectConfiguration.Czan.Maven.packageUrl)
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

// region Demo samples

tasks.register<Copy>("copyDemoSamples") {
    dependsOn("jsBrowserDistribution")
    from(layout.buildDirectory.dir("dist/js/productionExecutable"))
    into(layout.projectDirectory.dir("../docs/demo"))
}

tasks.named("publishToMavenLocal") {
    dependsOn("copyDemoSamples")
}

// endregion Demo samples
