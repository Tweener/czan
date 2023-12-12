![Logo   text](https://github.com/Tweener/c-zan-android/assets/596985/45ee247c-c8da-461a-8544-2e08578882db)

<h1 align="center">C·ZAN Android</h1>

<p align="center">Design System library for apps running on Jetpack Compose</p>

[![](https://jitpack.io/v/Tweener/c-zan-android.svg)](https://jitpack.io/#Tweener/c-zan-android)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

# ⭐️ Introduction

Introducing the **C·ZAN** design system, named in honor of Paul Cezanne, a renowned painter from Aix-en-Provence, France. This framework is a wrapper of [Material 3](https://m3.material.io/), Google's
open-source design system, and is specifically adapted for apps running on [Jetpack Compose](https://developer.android.com/jetpack/compose).

This system is following the [Atomic Design](https://bradfrost.com/blog/post/atomic-web-design/) methodology, where atoms, molecules, organisms and templates are the different levels of design you can
use to build your app.

# 💾 Installation

We are using [Jitpack](https://jitpack.io/) to publish the library.
Add the following block in your root `build.gradle.kts` at the end of repositories, (or in your `settings.gradle.kts` if you have one):

```groovy
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenCentral()
        maven { url 'https://jitpack.io' } // <- This line
    }
}
```

Then add C·ZAN dependency to your app `build.gradle.ktx`:

```groovy
implementation('com.github.Tweener:c-zan-android:$czan_version')
```

The latest version is: [![](https://jitpack.io/v/Tweener/c-zan-android.svg)](https://jitpack.io/#Tweener/c-zan-android)

Sync Project with Gradle files and that's it!

# 👨‍💻 Contributing

We love your input and welcome any contributions! See our [contributing guidelines](https://github.com/Tweener/c-zan-android/blob/master/CONTRIBUTING.md) for more details.

# Licence

C·ZAN is released under the Apache-2.0 license. See [LICENCE](https://github.com/Tweener/c-zan-android?tab=Apache-2.0-1-ov-file#readme) for more details.
