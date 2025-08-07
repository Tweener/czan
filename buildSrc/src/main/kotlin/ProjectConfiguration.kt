import org.gradle.api.JavaVersion

/**
 * @author Vivien Mahe
 * @since 23/07/2022
 */

object ProjectConfiguration {

    object Czan {
        const val packageName = "com.tweener.czan"
        const val versionName = "2.9.8"
        const val namespace = "$packageName.android"
        const val compileSDK = 35
        const val minSDK = 24

        object Maven {
            const val name = "CZAN"
            const val description = "A Kotlin/Compose Multiplatform design system that allows you to easily create components and screens."
            const val group = "io.github.tweener"
            const val packageUrl = "https://github.com/Tweener/czan"
            const val gitUrl = "github.com:Tweener/czan.git"

            object Developer {
                const val id = "Tweener"
                const val name = "Vivien Mahé"
                const val email = "vivien@tweener-labs.com"
            }
        }
    }

    object Compiler {
        val javaCompatibility = JavaVersion.VERSION_21
        val jvmTarget = javaCompatibility.toString()
    }
}
