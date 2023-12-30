import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties
import org.jetbrains.compose.ExperimentalComposeLibrary

plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("org.jetbrains.compose")
    id("org.jetbrains.dokka")
    id("maven-publish")
    id("signing")
}

android {
    namespace = Dependencies.Versions.Czan.namespace
    compileSdk = Dependencies.Versions.Czan.compileSDK

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")

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

    dependencies {
        coreLibraryDesugaring(Dependencies.Libraries.desugarJdkLibs)

        // Compose
        debugImplementation(Dependencies.Libraries.Android.AndroidX.Compose.uiTooling)
    }
}

kotlin {
    applyDefaultHierarchyTemplate()

    androidTarget {
        publishLibraryVariants("release")

        compilations.all {
            kotlinOptions {
                jvmTarget = Dependencies.Versions.Compiler.jvmTarget
            }
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "C-ZANLib"
            isStatic = true
        }
    }

    sourceSets {

        @OptIn(ExperimentalComposeLibrary::class)
        commonMain.dependencies {
            // Compose
            implementation(compose.ui)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.materialIconsExtended)
            implementation(compose.runtime)
            implementation(compose.components.resources)
        }

        androidMain.dependencies {
            // Tweener
            implementation(Dependencies.Libraries.Tweener.Android.common)
            implementation(Dependencies.Libraries.Tweener.Android.placeholder)

            // Android
            implementation(Dependencies.Libraries.Android.AndroidX.material3)
            implementation(Dependencies.Libraries.Android.AndroidX.activity)

            // Accompanist
            implementation(Dependencies.Libraries.Android.Accompanist.systemUIController)

            // Compose
            implementation(Dependencies.Libraries.Android.AndroidX.Compose.uiTooling)
            implementation(Dependencies.Libraries.Android.AndroidX.Compose.uiToolingPreview)
            implementation(Dependencies.Libraries.Android.AndroidX.Compose.materialIconsCore)
            implementation(Dependencies.Libraries.Android.AndroidX.Compose.activity)
            implementation(Dependencies.Libraries.Android.AndroidX.Compose.navigation)
            implementation(Dependencies.Libraries.Android.AndroidX.Compose.lifecycleRuntime)

            // Image fetcher
            implementation(Dependencies.Libraries.glide)
            implementation(Dependencies.Libraries.glidePlaceholder)
        }
    }
}

// region Publishing

// Dokka configuration
tasks.dokkaHtml {
    outputDirectory.set(file("$buildDir/dokka"))
}

val dokkaJar by tasks.creating(Jar::class) {
    group = JavaBasePlugin.DOCUMENTATION_GROUP
    archiveClassifier.set("javadoc")
    from(tasks.dokkaHtml)
}

publishing {
    repositories {
        maven {
            name = "OSS"
            url = uri("https://oss.sonatype.org/service/local/staging/deploy/maven2/")
            credentials {
                username = gradleLocalProperties(rootDir).getProperty("sonatype.username") ?: System.getenv("SONATYPE_USERNAME")
                password = gradleLocalProperties(rootDir).getProperty("sonatype.password") ?: System.getenv("SONATYPE_PASSWORD")
            }
        }
    }

    publications {
        publications.configureEach {
            if (this is MavenPublication) {
                artifact(dokkaJar)

                groupId = Dependencies.Versions.Czan.Maven.group
                artifactId = Dependencies.Versions.Czan.Maven.artifactId
                version = Dependencies.Versions.Czan.versionName

                pom {
                    name.set("C·ZAN Library")
                    description.set("C·ZAN Kotlin Multiplatform and Compose Multiplatform SDK")
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
}

signing {
    val signingKey = gradleLocalProperties(rootDir).getProperty("signing.key") ?: System.getenv("SIGNING_KEY")
    val signingPassword = gradleLocalProperties(rootDir).getProperty("signing.password") ?: System.getenv("SIGNING_PASSWORD")

    if (signingKey != null && signingPassword != null) {
        useInMemoryPgpKeys(signingKey, signingPassword)
        sign(publishing.publications)
    }
}

// endregion Publishing
