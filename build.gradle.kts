import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    kotlin("multiplatform").version(Dependencies.Versions.kotlin).apply(false)
    id("com.android.library").version(Dependencies.Versions.gradle).apply(false)
    id("org.jetbrains.compose").version(Dependencies.Versions.composeMultiplatform).apply(false)
    id("org.jetbrains.kotlin.plugin.compose").version(Dependencies.Versions.kotlin).apply(false)
    id("org.jetbrains.dokka").version(Dependencies.Versions.dokka).apply(false)
    id("io.github.gradle-nexus.publish-plugin").version(Dependencies.Versions.nexusSonatype)
    id("com.github.ben-manes.versions").version(Dependencies.Versions.dependencyVersionsPlugin) // ./gradlew dependencyUpdates
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

nexusPublishing {
    repositories {
        sonatype {
            nexusUrl.set(uri("https://s01.oss.sonatype.org/service/local/"))
            snapshotRepositoryUrl.set(uri("https://s01.oss.sonatype.org/content/repositories/snapshots/"))
            username.set(gradleLocalProperties(rootDir).getProperty("sonatype.username") ?: System.getenv("OSSRH_USERNAME"))
            password.set(gradleLocalProperties(rootDir).getProperty("sonatype.password") ?: System.getenv("OSSRH_PASSWORD"))
            stagingProfileId.set(gradleLocalProperties(rootDir).getProperty("sonatype.stagingProfileId") ?: System.getenv("OSSRH_STAGING_PROFILE_ID"))
        }
    }
}
