// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    kotlin("multiplatform").version(Dependencies.Versions.kotlin).apply(false)
    id("com.android.library").version(Dependencies.Versions.gradle).apply(false)
    id("org.jetbrains.compose").version(Dependencies.Versions.composeMultiplatform).apply(false)
    id("org.jetbrains.dokka").version(Dependencies.Versions.dokka).apply(false)
    id("io.github.gradle-nexus.publish-plugin").version(Dependencies.Versions.nexusSonatype)
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

group = Dependencies.Versions.Czan.Maven.group
version = Dependencies.Versions.Czan.versionName

nexusPublishing {
    repositories {
        sonatype {
            nexusUrl.set(uri("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2"))
            snapshotRepositoryUrl.set(uri("https://s01.oss.sonatype.org/content/repositories/snapshots/"))
        }
    }
}
