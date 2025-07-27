import com.vanniktech.maven.publish.JavadocJar
import com.vanniktech.maven.publish.KotlinMultiplatform
import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.jetbrains.compose.compiler)
    alias(libs.plugins.dokka)
    alias(libs.plugins.maven.publish)
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
    }
}

kotlin {
    applyDefaultHierarchyTemplate()

    androidTarget {
        publishLibraryVariants("release")

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

    jvm()

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
            implementation(libs.shimmer)

            // Compose
            implementation(compose.ui)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.materialIconsExtended)
            implementation(compose.runtime)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
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

        val nonIosMain by creating {
            dependsOn(commonMain.get())
            androidMain.get().dependsOn(this)
            jsMain.get().dependsOn(this)
            wasmJsMain.get().dependsOn(this)
            jvmMain.get().dependsOn(this)
        }
    }
}

// region Publishing

group = ProjectConfiguration.Czan.Maven.group
version = ProjectConfiguration.Czan.versionName

mavenPublishing {
    publishToMavenCentral(automaticRelease = true)

    // Only disable signing if the flag is explicitly set to false
    val signAllPublicationsProperty = findProperty("mavenPublishing.signAllPublications")
    if (signAllPublicationsProperty == null || signAllPublicationsProperty.toString().toBoolean()) {
        signAllPublications()
    }

    coordinates(groupId = group.toString(), artifactId = ProjectConfiguration.Czan.Maven.name.lowercase(), version = version.toString())
    configure(
        platform = KotlinMultiplatform(
            javadocJar = JavadocJar.Dokka("dokkaHtml"),
            sourcesJar = true,
        )
    )

    pom {
        name = ProjectConfiguration.Czan.Maven.name
        description = ProjectConfiguration.Czan.Maven.description
        url = ProjectConfiguration.Czan.Maven.packageUrl

        licenses {
            license {
                name = "The Apache License, Version 2.0"
                url = "http://www.apache.org/licenses/LICENSE-2.0.txt"
            }
        }

        issueManagement {
            system = "GitHub Issues"
            url = "${ProjectConfiguration.Czan.Maven.packageUrl}/issues"
        }

        developers {
            developer {
                id = ProjectConfiguration.Czan.Maven.Developer.id
                name = ProjectConfiguration.Czan.Maven.Developer.name
                email = ProjectConfiguration.Czan.Maven.Developer.email
            }
        }

        scm {
            connection = "scm:git:git://${ProjectConfiguration.Czan.Maven.gitUrl}"
            developerConnection = "scm:git:ssh://${ProjectConfiguration.Czan.Maven.gitUrl}"
            url = ProjectConfiguration.Czan.Maven.packageUrl
        }
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
