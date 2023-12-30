// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    kotlin("multiplatform").version(Dependencies.Versions.kotlin).apply(false)
    id("com.android.library").version(Dependencies.Versions.gradle).apply(false)
    id("org.jetbrains.compose").version(Dependencies.Versions.composeMultiplatform).apply(false)
    id("org.jetbrains.dokka").version(Dependencies.Versions.dokka).apply(false)
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
