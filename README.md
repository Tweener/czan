![Logo   text](https://github.com/Tweener/c-zan-android/assets/596985/45ee247c-c8da-461a-8544-2e08578882db)

<h2 align="center">Design System library for apps running on Jetpack Compose</h2>

[![X/Twitter](https://img.shields.io/twitter/follow/VivienMahe)](https://twitter.com/VivienMahe)
[![Website](https://img.shields.io/badge/Website-vivienmahe.com-orange)](https://vivienmahe.com/)

[![](https://jitpack.io/v/Tweener/c-zan.svg)](https://jitpack.io/#Tweener/c-zan)
![kotlin-version](https://img.shields.io/badge/kotlin-1.9.10-blue)
![gradle-version](https://img.shields.io/badge/gradle-8.1.1-blue)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

---

# ⭐️ Introduction

Introducing the **C·ZAN** design system, named in honor of Paul Cezanne, a renowned painter from Aix-en-Provence, France. This framework is a wrapper of [Material 3](https://m3.material.io/), Google's
open-source design system, and is specifically adapted for apps running on [Jetpack Compose](https://developer.android.com/jetpack/compose).

This system is following the [Atomic Design](https://bradfrost.com/blog/post/atomic-web-design/) methodology, where atoms, molecules, organisms and templates are the different levels of design you can
use to build your app.

➡️ Be sure to show your support by starring ⭐️ this repository, and feel free to [contribute](#-contributing) if you're interested!

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

🔄 Sync Project with Gradle files and that's it!

# 🗺️ Roadmap

The C·ZAN design system, still in its early stages, has an exciting journey of development ahead. Checkout the [roadmap](https://github.com/users/Tweener/projects/1/views/1) to know all about the
upcoming tasks, presented in no specific order and without set deadlines.

Feel free to check out the range of `Composable`s that are already available [here](https://github.com/Tweener/c-zan/tree/main/library/src/main/java/com/tweener/czan/android/designsystem)!

# 👨‍💻 Contributing

We love your input and welcome any contributions! Please read our [contribution guidelines](https://github.com/Tweener/c-zan-android/blob/master/CONTRIBUTING.md) before submitting a pull request.

# 🪪 Licence

C·ZAN is licensed under the [Apache-2.0](https://github.com/Tweener/c-zan-android?tab=Apache-2.0-1-ov-file#readme).
