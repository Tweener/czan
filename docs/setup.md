# Setup

## Installation
In your `build.gradle.kts` file, add Maven Central to your repositories:

```kotlin title="build.gradle.ktx"
repositories {
    mavenCentral()
}
```

Then add CZAN dependency to your module:

=== "Version Catalog"
    ```toml title="libs.versions.toml"
    [versions]
    czan = "2.3.3" // Check latest version

    [libraries]
    czan = { group = "io.github.tweener", name = "czan", version.ref = "czan" }
    ```

    ```kotlin title="build.gradle.ktx"
    dependencies {
        implementation(libs.czan)
    }
    ```
=== "Dependencies"
    ```kotlin title="build.gradle.ktx"
    dependencies {
        val czan_version = "2.3.3" // Check latest version

        implementation("io.github.tweener:czan:$czan_version")
    }
    ```

The latest version is: [![](https://img.shields.io/maven-metadata/v?metadataUrl=https%3A%2F%2Fs01.oss.sonatype.org%2Fservice%2Flocal%2Frepo_groups%2Fpublic%2Fcontent%2Fio%2Fgithub%2Ftweener%2Fczan%2Fmaven-metadata.xml)](https://central.sonatype.com/artifact/io.github.tweener/czan)

## Theme customization

First, you must configure your theme and define your color palette, typography and shape, as explained in the
official [documentation](https://developer.android.com/jetpack/compose/designsystems/material3#material-theming) for Material 3 with Jetpack Compose.

### Colors

```kotlin
// Light color scheme
val md_theme_light_primary = Color(0xFF123456)

val MyAppLightColorScheme = lightColorScheme(
    primary = md_theme_light_primary,
    ...
)

// Dark color scheme, if needed
val md_theme_dark_primary = Color(0xFF654321)

val MyAppLightColorScheme = darkColorScheme(
    primary = md_theme_dark_primary,
    ...
)
```

### Typographies

```kotlin
val MyAppTypography = Typography(
    labelLarge = TextStyle(
        fontWeight = FontWeight.Medium,
        ...
    )
    ...
)
```

### Shapes

```kotlin
val MyAppShapes = Shapes(
    small = RoundedCornerShape(4.dp),
    medium = RoundedCornerShape(8.dp),
    large = RoundedCornerShape(12.dp),
    extraLarge = RoundedCornerShape(16.dp)
)

```

## Theme usage

Once you've customized your theme with colors, typographies and shapes, you can use your theme with `CzanTheme`. **CZAN** automatically handles light and dark modes if both color schemes are provided, depending on the device's settings.

=== "No dark mode"
    ```kotlin
    @Composable
    fun MyAppTheme(
        content: @Composable () -> Unit
    ) {
        CzanTheme(
            darkTheme = darkTheme,
            lightColorScheme = MyAppLightColorScheme,
            typography = MyAppTypography,
            shapes = MyAppShapes,
            content = content
        )
    }
    ```

=== "With dark mode"
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

    !!! note "Force specific theme"

        In some cases, you may need to force usage of light or dark mode on specific Composables or screens. _(For instance: a custom splash screen which always looks the same on both light and dark modes.)_<br/><br/>
        You can achieve this by using `ThemeType`.

        ```kotlin
        val themeType: ThemeType = ThemeType.DARK // If you want to use a ThemeType directly from your main Composable
        // or
        val themeType by viewModel.themeType.collectAsState() // If the ThemeType is provided by the ViewModel 

        MyAppTheme(darkTheme = shouldUseDarkTheme(themeType = themeType)) {
            MyScreen {
                ...
            }
        }
        ```
