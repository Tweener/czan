// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version Dependencies.Versions.gradle apply false
    id("com.android.library") version Dependencies.Versions.gradle apply false
    kotlin("android") version Dependencies.Versions.kotlin apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
