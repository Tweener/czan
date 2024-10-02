import org.gradle.api.JavaVersion

/**
 * @author Vivien Mahe
 * @since 23/07/2022
 */

object ProjectConfiguration {

    object Czan {
        const val packageName = "com.tweener.czan"
        const val versionName = "2.3.4"
        const val namespace = "$packageName.android"
        const val compileSDK = 34
        const val minSDK = 24

        object Maven {
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
