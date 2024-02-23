![Logo   text](https://github.com/Tweener/c-zan-android/assets/596985/45ee247c-c8da-461a-8544-2e08578882db)

<h2 align="center">Design System library for apps running on Kotlin/Compose Multiplatform</h2>

[![Website](https://img.shields.io/badge/Author-vivienmahe.com-orange)](https://vivienmahe.com/)
[![X/Twitter](https://img.shields.io/twitter/follow/VivienMahe)](https://twitter.com/VivienMahe)

[![](https://img.shields.io/maven-metadata/v?metadataUrl=https%3A%2F%2Fs01.oss.sonatype.org%2Fservice%2Flocal%2Frepo_groups%2Fpublic%2Fcontent%2Fio%2Fgithub%2Ftweener%2Fczan%2Fmaven-metadata.xml)](https://central.sonatype.com/artifact/io.github.tweener/czan)
[![Kotlin](https://img.shields.io/badge/kotlin-1.9.21-blue.svg?logo=kotlin)](http://kotlinlang.org)
![gradle-version](https://img.shields.io/badge/gradle-8.1.4-blue?logo=gradle)
[![License](https://img.shields.io/badge/License-Apache%202.0-green.svg)](https://opensource.org/licenses/Apache-2.0)

---

# ⭐️ Introduction

Introducing the **C·ZAN** design system, named in honor of [Paul Cezanne](https://en.wikipedia.org/wiki/Paul_C%C3%A9zanne), a renowned painter from Aix-en-Provence, France.

This framework is specifically adapted for apps running on [Compose Multiplatform](https://www.jetbrains.com/lp/compose-multiplatform/) and will apply a specific look & feel for the targeted platforms:
- Android: [Material 3](https://m3.material.io/), Google's open-source design system
- iOS: Cupertino, Apple's design system

**C·ZAN** is following the [Atomic Design](https://bradfrost.com/blog/post/atomic-web-design/) methodology, where atoms, molecules, organisms and templates are the different levels of design you can
use to build your app.

➡️ Be sure to show your support by starring ⭐️ this repository, and feel free to [contribute](#-contributing) if you're interested!

# 💾 Installation

Add the dependency in your common module's commonMain sourceSet:

```groovy
implementation('io.github.tweener:czan:$czan_version')
```

The latest version
is: [![](https://img.shields.io/maven-metadata/v?metadataUrl=https%3A%2F%2Fs01.oss.sonatype.org%2Fservice%2Flocal%2Frepo_groups%2Fpublic%2Fcontent%2Fio%2Fgithub%2Ftweener%2Fczan%2Fmaven-metadata.xml)](https://central.sonatype.com/artifact/io.github.tweener/czan)

# ⚙️ Usage

### 1. Theme configuration

First, you must configure your theme and define your color palette, typography and shape, as explained in the
official [documentation](https://developer.android.com/jetpack/compose/designsystems/material3#material-theming) for Material 3 with Jetpack Compose.

- Colors:

```kotlin
val md_theme_light_primary = Color(0xFF123456)

val MyAppLightColorScheme = lightColorScheme(
    primary = md_theme_light_primary,
    ...
)

val md_theme_dark_primary = Color(0xFF123456)

val MyAppLightColorScheme = darkColorScheme(
    primary = md_theme_dark_primary,
    ...
)
```

- Typography:

```kotlin
val MyAppTypography = Typography(
    labelLarge = TextStyle(
        fontWeight = FontWeight.Medium,
        ...
    )
    ...
)
````

- Shapes:

```kotlin
val MyAppShapes = Shapes(
    small = RoundedCornerShape(4.dp),
    medium = RoundedCornerShape(8.dp),
    large = RoundedCornerShape(12.dp),
    extraLarge = RoundedCornerShape(16.dp)
)

```

### 2. Theme declaration

Then, declare your app theme using `CzanTheme` as follows:

```kotlin
@Composable
fun MyAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    CzanTheme(
        darkTheme = darkTheme,
        lightColorScheme = MyAppLightColorScheme,
        darkColorScheme = MyAppDarkColorScheme,
        typography = MyAppTypography,
        shapes = MyAppShapes,
        content = content
    )
}
```

_Note: if your app does not need a dark theme, use `darkColorScheme = null`._

### 3. Theme usage

C·ZAN wraps some default Material 3 classes to properly adapt the look & feel to the targeted platform. Make sure to use the following ones:
- `androidx.compose.material3.Scaffold` -> `com.tweener.czan.designsystem.atom.scaffold.Scaffold`
- `androidx.compose.material3.NavigationBar` -> `com.tweener.czan.designsystem.atom.bars.NavigationBar`
- `androidx.compose.material3.NavigationBarItem` -> `com.tweener.czan.designsystem.atom.bars.NavigationBarItem`

```kotlin
import com.tweener.czan.designsystem.atom.scaffold.Scaffold
import com.tweener.czan.designsystem.atom.bars.NavigationBar
import com.tweener.czan.designsystem.atom.bars.NavigationBarItem

@Composable
fun App(
  modifier: Modifier = Modifier
) {
    Surface {
        MyAppTheme {
            Scaffold(
                navigationBar = {
                    NavigationBar {
                        NavigationBarItem(...)
                        NavigationBarItem(...)
                        NavigationBarItem(...)
                    }
                },
                ...
            ) { innerPadding ->
                ...
            }
        }
    }
}
```

### 4. Light & Dark mode

If you declared a `darkColorScheme` in step 2, C·ZAN will automatically adapts the theme to light or dark mode depending on the device's settings.

To override it, you can achieve it by using [`ThemeType`](https://github.com/Tweener/c-zan/blob/main/library/src/main/java/com/tweener/czan/android/theme/ThemeType.kt) as follows:

```kotlin
val themeType: ThemeType = ThemeType.DARK // If you want to use a ThemeType directly from your main Composable
// or
val themeType by viewModel.themeType.collectAsState() // If the ThemeType is provided by the ViewModel 

MyAppTheme(darkTheme = shouldUseDarkTheme(themeType = themeType)) {
    ...
}
```

# 🗺️ Roadmap

The C·ZAN design system, still in its early stages, has an exciting journey of development ahead. Checkout the [roadmap](https://github.com/users/Tweener/projects/1/views/1) to know all about the
upcoming tasks, presented in no specific order and without set deadlines.

Feel free to check out the range of `Composable`s that are already available [here](https://github.com/Tweener/c-zan/tree/main/czan/src/commonMain/kotlin/com/tweener/czan/designsystem)!

# 👨‍💻 Contributing

We love your input and welcome any contributions! Please read our [contribution guidelines](https://github.com/Tweener/c-zan-android/blob/master/CONTRIBUTING.md) before submitting a pull request.

# 🪪 Licence

C·ZAN is licensed under the [Apache-2.0](https://github.com/Tweener/c-zan-android?tab=Apache-2.0-1-ov-file#readme).
