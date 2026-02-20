import ProjectConfiguration.Czan.namespace
import com.vanniktech.maven.publish.JavadocJar
import com.vanniktech.maven.publish.KotlinMultiplatform
import com.vanniktech.maven.publish.SourcesJar
import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.kotlin.multiplatform.library)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.jetbrains.compose.compiler)
    alias(libs.plugins.dokka)
    alias(libs.plugins.maven.publish)
}

kotlin {
    applyDefaultHierarchyTemplate()

    androidLibrary {
        namespace = ProjectConfiguration.Czan.namespace
        compileSdk = ProjectConfiguration.Czan.compileSDK
        minSdk = ProjectConfiguration.Czan.minSDK

        withHostTestBuilder {}

        compilerOptions {
            jvmTarget.set(JvmTarget.fromTarget(ProjectConfiguration.Compiler.jvmTarget))
        }
    }

    listOf(
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
            implementation(libs.kmpkit)

            // Compose
            implementation(libs.bundles.compose)

            // Coil (Image fetcher)
            implementation(libs.bundles.coil)
        }

        androidMain.dependencies {
            // Compose
            implementation(libs.compose.multiplatform.uiToolingPreview)
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
            javadocJar = JavadocJar.Dokka("dokkaGeneratePublicationHtml"),
            sourcesJar = SourcesJar.Sources(),
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

//tasks.named("publishToMavenLocal") {
//    dependsOn("copyDemoSamples")
//}

// endregion Demo samples
