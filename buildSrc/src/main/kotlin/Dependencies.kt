import org.gradle.api.JavaVersion

/**
 * @author Vivien Mahe
 * @since 23/07/2022
 */

object Dependencies {

    object Versions {

        const val kotlin = "1.9.21"
        const val gradle = "8.1.4"
        const val nexusSonatype = "2.0.0-rc-1"
        const val composeMultiplatform = "1.5.11"
        const val dokka = "1.9.10"
        const val composeCompilerExtension = "1.5.7"
        const val compose = "1.6.0-alpha03"
        const val activityCompose = "1.7.2"
        const val navigationCompose = "2.7.2"
        const val desugarJdkLibs = "2.0.3"
        const val accompanist = "0.32.0"
        const val coil = "3.0.0-alpha01"
        const val ktor = "2.3.4"
        const val annotations = "1.7.1"
        const val shimmer = "1.2.0"

        object Czan {
            const val packageName = "com.tweener.czan"
            const val versionName = "2.0.0"
            const val namespace = "$packageName.android"
            const val compileSDK = 34
            const val minSDK = 24

            object Maven {
                const val group = "io.github.tweener"
                const val packageUrl = "https://github.com/Tweener/c-zan"
                const val gitUrl = "github.com:Tweener/c-zan.git"
            }
        }

        object Compiler {
            const val jvmTarget = "17"
            val javaCompatibility = JavaVersion.VERSION_17
        }

        object Tweener {
            object Android {
                const val common = "2.0.8"
                const val placeholder = "1.0.0"
            }
        }

        object AndroidX {
            const val activity = "1.8.0-alpha07"
            const val lifecycle = "2.6.2"
        }
    }

    object Libraries {

        const val desugarJdkLibs = "com.android.tools:desugar_jdk_libs:${Versions.desugarJdkLibs}"
        const val shimmer = "com.valentinilk.shimmer:compose-shimmer:${Versions.shimmer}"
        const val ktor = "io.ktor:ktor-client-okhttp:${Versions.ktor}"
        const val annotations = "androidx.annotation:annotation:${Versions.annotations}"

        object Tweener {
            object Android {
                const val common = "com.github.Tweener:common-android:${Versions.Tweener.Android.common}"
                const val placeholder = "com.github.Tweener:placeholder-material3:${Versions.Tweener.Android.placeholder}"
            }
        }

        object Coil {
            const val compose = "io.coil-kt.coil3:coil-compose:${Versions.coil}"
            const val network = "io.coil-kt.coil3:coil-network:${Versions.coil}"
        }

        object Ktor {
            object Client {
                object Android {
                    const val okhttp = "io.ktor:ktor-client-okhttp:${Versions.ktor}"
                }

                object iOS {
                    const val client = "io.ktor:ktor-client-darwin:${Versions.ktor}"
                }
            }
        }

        object ComposeMultiplatform {
            const val material3 = "org.jetbrains.compose.material3:material3:${Versions.composeMultiplatform}"
        }

        object Android {
            object AndroidX {
                const val activity = "androidx.activity:activity-ktx:${Versions.AndroidX.activity}"

                object Compose {
                    const val ui = "androidx.compose.ui:ui:${Versions.compose}"
                    const val uiTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
                    const val uiToolingPreview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
                    const val foundation = "androidx.compose.foundation:foundation:${Versions.compose}"
                    const val material = "androidx.compose.material:material:${Versions.compose}"
                    const val materialIconsCore = "androidx.compose.material:material-icons-core:${Versions.compose}"
                    const val materialIconsExtended = "androidx.compose.material:material-icons-extended:${Versions.compose}"
                    const val activity = "androidx.activity:activity-compose:${Versions.activityCompose}"
                    const val navigation = "androidx.navigation:navigation-compose:${Versions.navigationCompose}"
                    const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-compose:${Versions.AndroidX.lifecycle}"
                }
            }

            object Accompanist {
                const val systemUIController = "com.google.accompanist:accompanist-systemuicontroller:${Versions.accompanist}"
            }
        }
    }
}
