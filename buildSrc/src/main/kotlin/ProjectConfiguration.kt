import org.gradle.api.JavaVersion

/**
 * @author Vivien Mahe
 * @since 23/07/2022
 */

object ProjectConfiguration {

    object Czan {
        const val packageName = "com.tweener.czan"
        const val versionName = "2.7.1"
        const val namespace = "$packageName.android"
        const val compileSDK = 34
        const val minSDK = 24

        object Maven {
            const val name = "CZAN"
            const val description = "CZAN Atomic Design System for Kotlin Multiplatform and Compose Multiplatform"
            const val group = "io.github.tweener"
            const val packageUrl = "https://github.com/Tweener/czan"
            const val gitUrl = "github.com:Tweener/czan.git"
        }
    }

    object Compiler {
        const val jvmTarget = "17"
        val javaCompatibility = JavaVersion.VERSION_17
    }
}
