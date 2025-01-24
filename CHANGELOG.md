# Changelog

## [2.9.0] - January 24, 2025
- Added [`Snackbar`](https://github.com/Tweener/czan/blob/main/czan/src/commonMain/kotlin/com/tweener/czan/designsystem/atom/snackbar/Snackbar.kt) composable to easily customize the default snackbar.
- Added [`RadioButton`](https://github.com/Tweener/czan/blob/main/czan/src/commonMain/kotlin/com/tweener/czan/designsystem/atom/radiobutton/RadioButton.kt) composable with automatic icon toggling when tapping on the radio button.
- Added [`PaywallProductCard`](https://github.com/Tweener/czan/blob/main/czan/src/commonMain/kotlin/com/tweener/czan/component/paywall/PaywallProductCard.kt) component to easily display the main information of a purchasable product on a paywall.
- Added `applySpanStyle()` [`String`](https://github.com/Tweener/czan/blob/main/czan/src/commonMain/kotlin/com/tweener/czan/_internal/kotlinextensions/StringExtensions.kt#L41) and [`AnnotatedString`](https://github.com/Tweener/czan/blob/main/czan/src/commonMain/kotlin/com/tweener/czan/_internal/kotlinextensions/StringExtensions.kt#L109) extension functions to apply a given `SpanStyle` to specified substrings within the main string, returning an `AnnotatedString`.
- Added [`onLifecycleEvents`](https://github.com/Tweener/czan/blob/main/czan/src/commonMain/kotlin/com/tweener/czan/_internal/kotlinextensions/LifecycleOwnerExtensions.kt) `LifecycleOwner` extension function to observe lifecycle events within a Composable and execute corresponding callbacks when events occur.

## [2.8.1] - January 13, 2025
- Add support for JVM targets.

## [2.8.0] - January 12, 2025
- [AlertDialog](https://github.com/Tweener/czan/blob/main/czan/src/commonMain/kotlin/com/tweener/czan/designsystem/atom/dialog/AlertDialog.kt) now uses Material 3 for non-iOS targets and Cupertino for iOS target (via UIKit).
- [CarouselDashes](https://github.com/Tweener/czan/blob/main/czan/src/commonMain/kotlin/com/tweener/czan/designsystem/molecule/carousel/CarouselDashes.kt#L26) - Auto-switch to next dash animation can now be disabled using `animated = false`.
- Update Kotlin to 2.1.0.
- Update Compose Multiplatform to 1.7.3.
- Update Gradle to 8.11.1.
- New basic [sample apps](https://github.com/Tweener/czan/tree/main/sample) on Android and iOS to showcase CZAN. _For now, only `Button` and `AlertDialog` are added to the sample._

## [2.7.0] - December 16, 2024
- **`[BREAKING]`** 🍎 Removed Cupertino look & feel on iOS due to [`compose-cupertino`](https://github.com/alexzhirkevich/compose-cupertino) being incompatible with Compose >= 1.7.0 (and apparently not maintained anymore).
- Added a new `LinearProgressBar` constructor for creating indeterminate progress bars.
- Authentication buttons now properly reflect the disabled state.
- `TextField` now allows customization of keyboard capitalization, defaulting to `KeyboardCapitalization.Sentences`, which capitalizes the first letter of each sentence.

## [2.6.0] - November 26, 2024
- **`[BREAKING]`** Removed extension function `StateFlow.collectAsStateMultiplatform`. Use [`StateFlow.collectAsStateWithLifecycle()`](https://developer.android.com/develop/ui/compose/state#use-other-types-of-state-in-jetpack-compose) instead.
- Added new composables: [`DashedLine`](https://github.com/Tweener/czan/blob/main/czan/src/commonMain/kotlin/com/tweener/czan/designsystem/atom/line/DashedLine.kt) and [`Slider`](https://github.com/Tweener/czan/blob/main/czan/src/commonMain/kotlin/com/tweener/czan/designsystem/atom/slider/Slider.kt).
- `SharedFlow.subscribe()` now collects only when the lifecycle is STARTED.
- `Carousel` now includes customization of page spacing.
- `Card`, `ExpandableCard`, and `CardTip` sizes are now encapsulated within a `CardSizes` object.
- `TopBar` offers more customization, including a `TopBarWithCustomIcon()` and granular color customization for title, navigationIcon, and actionIcon.
- **`[FIX]`** Resolved UI glitches in `LinearProgressBar` and `CarouselDash` after upgrading to CMP 1.7.0.

## [2.5.0] - October 16, 2024
- Update Compose Multiplatform to 1.7.0.

## [2.4.0] - October 16, 2024
- Added support for KS and WasmJS targets, enabling CZAN on the web.
- Added automatic documentation deployment on [czan.dev](https://www.czan.dev/).
- [`Button`](https://github.com/Tweener/czan/blob/main/czan/src/commonMain/kotlin/com/tweener/czan/designsystem/atom/button/Button.kt#L56) now includes a loading state with animations, displaying `...` when loading.
- [`AuthenticationButtons`](https://github.com/Tweener/czan/blob/main/czan/src/commonMain/kotlin/com/tweener/czan/designsystem/atom/button/AuthenticationButtons.kt#L44) now have a flag to enable or disable them.
- Added [`onHoldTouch()`](https://github.com/Tweener/czan/blob/main/czan/src/commonMain/kotlin/com/tweener/czan/_internal/kotlinextensions/ModifierExtensions.kt#L156) `Modifier` extension function to handle tap events when the user holds the composable.
- **`[FIX]`** Corrected border color for outlined [buttons](https://github.com/Tweener/czan/blob/main/czan/src/commonMain/kotlin/com/tweener/czan/designsystem/atom/button/Button.kt) to use `MaterialTheme.colorScheme.outline`.
- Update Kotlin to 2.0.21.
- Update Gradle to 8.7.0.

## [2.3.3] - September 26, 2024
- **`[BREAKING]`** [NavigationBars](https://github.com/Tweener/czan/blob/main/czan/src/commonMain/kotlin/com/tweener/czan/designsystem/atom/bars/NavigationBars.kt) now have a mandatory `icon` parameter and an optional `label`.
- **`[BREAKING]`** [`Chip`](https://github.com/Tweener/czan/blob/main/czan/src/commonMain/kotlin/com/tweener/czan/designsystem/atom/chip/Chip.kt) now includes distinct click callbacks: `onClick` for the entire chip and `onCloseClick` for the close icon.
- Added [`Color.parseColor(hex: String)`](https://github.com/Tweener/czan/blob/main/czan/src/commonMain/kotlin/com/tweener/czan/_internal/kotlinextensions/ColorExtensions.kt#L25) extension function to convert hex colors to `Color`:
```Kotlin
val colorNoHashNoAlpha: Color = Color.parseColor("00FF00")
val colorNoHashWithAlpha: Color = Color.parseColor("FF00FF00")
val colorWithHashNoAlpha: Color = Color.parseColor("#00FF00")
val colorWithHashWithAlpha: Color = Color.parseColor("#FF00FF00")
```
- Introduced [`TrailingIconText`](https://github.com/Tweener/czan/blob/main/czan/src/commonMain/kotlin/com/tweener/czan/designsystem/atom/text/TrailingIconText.kt) composable for displaying text with a trailing icon.
- [`LinearProgressBar`](https://github.com/Tweener/czan/blob/main/czan/src/commonMain/kotlin/com/tweener/czan/designsystem/atom/bars/progress/LinearProgressBar.kt) now features progress animation during rendering.
- [`AuthenticationButtons`](https://github.com/Tweener/czan/blob/main/czan/src/commonMain/kotlin/com/tweener/czan/designsystem/atom/button/AuthenticationButtons.kt) border color now defaults to `MaterialTheme.colorScheme.outline`.
- [`Card`](https://github.com/Tweener/czan/blob/main/czan/src/commonMain/kotlin/com/tweener/czan/designsystem/organism/card/Card.kt) now includes an `onClick` callback for user interactions.
- New Composable function [`colorResource(lightColor, darkColor?)`](https://github.com/Tweener/czan/blob/main/czan/src/commonMain/kotlin/com/tweener/czan/theme/CzanTheme.kt#L21-L22) to easily configure a `Color` with optional dark mode:
```
val light_myNewColor = Color(0xFF...)
val dark_myNewColor = Color(0xFF...)
val myNewColor = colorResource(colorLight = light_myNewColor, colorDark = dark_myNewColor)

Text(color = myNewColor, ...)
```

## [2.3.2] - August 28, 2024
- **`[BREAKING]`** `Switch` and `SwitchWithText` parameter `isChecked` renamed to `checked` for consistency.
- Added [`NoTitleTopBarWithBackButton`](https://github.com/Tweener/czan/blob/main/czan/src/commonMain/kotlin/com/tweener/czan/designsystem/atom/bars/TopBars.kt#L100) and [`NoTitleTopBarWithCloseButton`](https://github.com/Tweener/czan/blob/main/czan/src/commonMain/kotlin/com/tweener/czan/designsystem/atom/bars/TopBars.kt#L135) composables for simple top bars without titles.
- Simplified adding top bar actions with `TopBarAction` composable:
```Kotlin
SimpleTopBar(
    modifier = modifier,
    title = "Screen title",
    // ...
    actions = {
        TopBarAction(icon = Res.drawable.profile, onClick = onProfileClicked, contentDescription = stringResource(resource = Res.string.topbar_action_profile))
    }
)
```

## [2.3.1] - August 1, 2024
- Added [`CarouselDashes`](https://github.com/Tweener/c-zan/blob/main/czan/src/commonMain/kotlin/com/tweener/czan/designsystem/molecule/carousel/CarouselDashes.kt), an Instagram-like story dashes composable.
- Added [`PrimaryTabs` and `SecondaryTabs`](https://github.com/Tweener/c-zan/blob/main/czan/src/commonMain/kotlin/com/tweener/czan/designsystem/molecule/tabs/Tabs.kt) composables.
- Added a [`Modifier` extension](https://github.com/Tweener/c-zan/blob/main/czan/src/commonMain/kotlin/com/tweener/czan/_internal/kotlinextensions/ModifierExtensions.kt#L121) for applying shimmer effects.
- Added [authentication buttons](https://github.com/Tweener/c-zan/blob/main/czan/src/commonMain/kotlin/com/tweener/czan/designsystem/atom/button/AuthenticationButtons.kt) for Google, Apple, and email sign-up/login.
- Added `ON_PRIMARY`, `ON_SECONDARY`, and `ON_TERTIARY` styles for [`ButtonStyle`](https://github.com/Tweener/c-zan/blob/main/czan/src/commonMain/kotlin/com/tweener/czan/designsystem/atom/button/ButtonStyle.kt).

## [2.3.0] - May 28, 2024
- Official support for Kotlin 2.0.

## [2.2.1] - Apr 28, 2024
- Added [`CardTip`](https://github.com/Tweener/c-zan/blob/main/czan/src/commonMain/kotlin/com/tweener/czan/designsystem/molecule/cardtip/CardTip.kt) composable for displaying small tip messages with a leading icon.
- Added [`Checkbox`](https://github.com/Tweener/c-zan/blob/main/czan/src/commonMain/kotlin/com/tweener/czan/designsystem/atom/checkbox/Checkbox.kt) composable with optional text.
- Added [`LeadingIconText`](https://github.com/Tweener/c-zan/blob/main/czan/src/commonMain/kotlin/com/tweener/czan/designsystem/atom/text/LeadingIconText.kt) composable for displaying text with a leading icon.
- Added [`ExpandableNumericKeyboard`](https://github.com/Tweener/c-zan/blob/main/czan/src/commonMain/kotlin/com/tweener/czan/designsystem/molecule/keyboard/numeric/ExpandableNumericKeyboard.kt) for showing or hiding the numeric keyboard.
- **`[FIX]`** Resolved padding issues in [`Button`](https://github.com/Tweener/c-zan/commit/843b54f43aebb5a30df0cae604137cfe031c704f) between text and leading icon.
- **`[FIX]`** Removed decimal separator in [`NumericKeyboard`](https://github.com/Tweener/c-zan/commit/aa15f0eb6e99ee81ae472d68f948dbf3d5c48d2a) when deleting the last decimal.
- **`[FIX]`** Fixed incorrect decimal handling in [`NumericKeyboard`](https://github.com/Tweener/c-zan/commit/2064f088f2486d7139f9b0e014fc578efb65f5bc) when `allowDecimals = false`.

## [2.2.0] - April 5, 2024
- Added [`ContextMenu`](https://github.com/Tweener/c-zan/blob/main/czan/src/commonMain/kotlin/com/tweener/czan/designsystem/molecule/menu/contextmenu/ContextMenu.kt) composable, adapting the look & feel of the target platform: Material3 for Android, Cupertino for iOS.
- Added [`NumericKeyboard`](https://github.com/Tweener/c-zan/blob/main/czan/src/commonMain/kotlin/com/tweener/czan/designsystem/molecule/keyboard/numeric/NumericKeyboard.kt) composable for handling numeric inputs.
- [`Button`](https://github.com/Tweener/c-zan/blob/main/czan/src/commonMain/kotlin/com/tweener/czan/designsystem/atom/button/Button.kt) now supports `DrawableResource` for leading and trailing icons.
- Improved state management for [`Card`](https://github.com/Tweener/c-zan/blob/main/czan/src/commonMain/kotlin/com/tweener/czan/designsystem/organism/card/Card.kt) to prevent state loss during recomposition.
- [`TextField`](https://github.com/Tweener/c-zan/blob/main/czan/src/commonMain/kotlin/com/tweener/czan/designsystem/atom/textfield/TextField.kt) now offers three sizes: Small, Regular, Big ([`TextFieldSize`](https://github.com/Tweener/c-zan/blob/main/czan/src/commonMain/kotlin/com/tweener/czan/designsystem/atom/textfield/TextFieldSize.kt)).

## [2.1.2] - March 20, 2024
- Added [`Card`](https://github.com/Tweener/c-zan/blob/main/czan/src/commonMain/kotlin/com/tweener/czan/designsystem/organism/card/Card.kt) composable, enhancing Material3 Card with preconfigured header, content, and footer.
- Added [`ExpandableCard`](https://github.com/Tweener/c-zan/blob/main/czan/src/commonMain/kotlin/com/tweener/czan/designsystem/organism/card/ExpandableCard.kt) composable, allowing expansion or collapse on header click.
- Added [`Modifier.clickableRipple`](https://github.com/Tweener/c-zan/blob/main/czan/src/commonMain/kotlin/com/tweener/czan/_internal/kotlinextensions/ModifierExtensions.kt#L101) extension for easy ripple effect application.
- Added [`String.bold()`](https://github.com/Tweener/c-zan/blob/main/czan/src/commonMain/kotlin/com/tweener/czan/_internal/kotlinextensions/StringExtensions.kt#L13) extension function to apply bold styling to parts of a string.
- Provided color customization for [`NavigationBar`](https://github.com/Tweener/c-zan/blob/main/czan/src/commonMain/kotlin/com/tweener/czan/designsystem/atom/bars/NavigationBars.kt#L25) and [`NavigationBarItem`](https://github.com/Tweener/c-zan/blob/main/czan/src/commonMain/kotlin/com/tweener/czan/designsystem/atom/bars/NavigationBars.kt#L43).
- Improved color customization for [`TopBars`](https://github.com/Tweener/c-zan/blob/main/czan/src/commonMain/kotlin/com/tweener/czan/designsystem/atom/bars/TopBars.kt).
- Enhanced color customization and `strokeCap` for [`LinearProgressBar`](https://github.com/Tweener/c-zan/blob/main/czan/src/commonMain/kotlin/com/tweener/czan/designsystem/atom/bars/progress/LinearProgressBar.kt).

## [2.1.1] - March 6, 2024
- Update Compose Multiplatform to version 1.6.0.
- Dependencies are now managed through a Bill of Materials (BoM): [`kmp-bom`](https://github.com/Tweener/kmp-bom/).
- **`[FIX]`** Removed unused dependency [`placeholder-material3`](https://github.com/Tweener/placeholder-material3) that was preventing CZAN from functioning on Android.

## [2.1.0] - February 22, 2024
- **`[BREAKING]`** Introduced the [Compose Cupertino library](https://github.com/alexzhirkevich/compose-cupertino) to adapt the app's look & feel to the targeted platform (Material 3 for Android and Cupertino for iOS). Follow the provided [instructions](https://github.com/Tweener/c-zan?tab=readme-ov-file#3-theme-usage) to properly set up your app's theme.
- Added [`Scaffold`](https://github.com/Tweener/c-zan/blob/main/czan/src/commonMain/kotlin/com/tweener/czan/designsystem/atom/scaffold/Scaffold.kt) composable, which wraps the Material3 Scaffold class to automatically use the platform's look & feel.
- Added [`NavigationBar`](https://github.com/Tweener/c-zan/blob/main/czan/src/commonMain/kotlin/com/tweener/czan/designsystem/atom/bars/NavigationBars.kt#L23-L39) composable, which wraps the Material3 NavigationBar class to automatically use the platform's look & feel.
- Added [`NavigationBarItem`](https://github.com/Tweener/c-zan/blob/main/czan/src/commonMain/kotlin/com/tweener/czan/designsystem/atom/bars/NavigationBars.kt#L41-L73) composable, which wraps the Material3 NavigationBarItem class to automatically use the platform's look & feel.

## [2.0.2] - February 19, 2024
- Added a new implementation of [`Icon`](https://github.com/Tweener/c-zan/blob/main/czan/src/commonMain/kotlin/com/tweener/czan/designsystem/atom/icon/Icon.kt) that accepts a `Painter` as a parameter:
```Kotlin
fun Icon(
    modifier: Modifier = Modifier,
    painter: Painter,
    tint: Color = LocalContentColor.current,
    contentDescription: String? = null
)
```
- Update Compose Multiplatform to version 1.6.0-rc02.

## [2.0.1] - February 2, 2024
- Added [`BoxWithAnimatedBorder`](https://github.com/Tweener/c-zan/blob/main/czan/src/commonMain/kotlin/com/tweener/czan/designsystem/atom/box/BoxWithAnimatedBorder.kt) composable, which wraps a given composable with a surface featuring colored animated borders.
- Added new Kotlin extension functions to enhance functionality.

## [2.0.0] - January 8, 2025
- **`[BREAKING]`**: Migrated from JitPack to Maven Central. Update your dependency to:
```Kotlin
implementation("io.github.tweener:czan:2.0.0")
```
- 🎉 CZAN is now compatible with **Compose Multiplatform**!
- Replaced Glide with Coil for image fetching due to technical challenges with Compose Multiplatform.

## [1.1.4] - December 28, 2023
- Added more customization options to [`Chip`](https://github.com/Tweener/c-zan/blob/main/library/src/main/java/com/tweener/czan/android/designsystem/atom/chip/Chip.kt).
- Added more customization options to [`Chip`](https://github.com/Tweener/c-zan/blob/main/library/src/main/java/com/tweener/czan/android/designsystem/atom/image/Image.kt).
- Increased text sizes for [`Button`](https://github.com/Tweener/c-zan/blob/main/library/src/main/java/com/tweener/czan/android/designsystem/atom/button/Button.kt) for better readability.

## [1.1.3] - December 19, 2023
- **`[BREAKING]`**: Removed the `@UIModePreviews` annotation; replaced by the official `@PreviewLightDark` annotation in Compose.
- Added [`Chip`](https://github.com/Tweener/c-zan/blob/main/library/src/main/java/com/tweener/czan/android/designsystem/atom/chip/Chip.kt) composable, which wraps the Material3 `InputChip`.

## [1.1.2] - December 13, 2023
- Updated [`Image`](https://github.com/Tweener/c-zan/blob/main/library/src/main/java/com/tweener/czan/android/designsystem/atom/image/Image.kt) composable to include a wrapper for Material3's `Image` with `imageVector` support.

## [1.1.1] - December 13, 2023
- Added [`Icon`](https://github.com/Tweener/c-zan/blob/main/library/src/main/java/com/tweener/czan/android/designsystem/atom/icon/Icon.kt) atom to wrap Material3 `Icon`.
- Updated [`Image`](https://github.com/Tweener/c-zan/blob/main/library/src/main/java/com/tweener/czan/android/designsystem/atom/image/Image.kt) composable to support various image types, including drawable resources, bitmaps, and URLs (via Glide).

## [1.1.0] - November 27, 2023
- Updated packages hierarchy to apply atomic design system guidelines.

## [1.0.6] - November 27, 2023
- Renamed repository to `c-zan-android`.
- Updated all references from "Cezanne" to "Czan".

## [1.0.5] - November 3, 2023
- Added Glide dependency.
- Added [`Image`](https://github.com/Tweener/cezanne-android/blob/main/library/src/main/java/com/tweener/cezanne/android/component/image/Image.kt) composable to load image URLs.

## [1.0.4] - October 20, 2023
- Added [`Carousel`](https://github.com/Tweener/cezanne-android/blob/main/library/src/main/java/com/tweener/cezanne/android/component/carousel/Carousel.kt) component.
- Added [`StepProgressBar`](https://github.com/Tweener/cezanne-android/blob/main/library/src/main/java/com/tweener/cezanne/android/component/bars/progress/StepProgressBar.kt) component for multi-step flows (e.g., [`Carousel`](https://github.com/Tweener/cezanne-android/blob/main/library/src/main/java/com/tweener/cezanne/android/component/carousel/Carousel.kt)).
- Updated [`FloatingActionButton`](https://github.com/Tweener/cezanne-android/blob/main/library/src/main/java/com/tweener/cezanne/android/component/button/FloatinActionButton.kt) to use a regular-sized FAB.
- Improved [`Button`](https://github.com/Tweener/cezanne-android/blob/main/library/src/main/java/com/tweener/cezanne/android/component/button/Button.kt) by adjusting icon size and padding.

## [1.0.3] - October 12, 2023
- Updated `SystemBarsSystemUI` to allow customization.

## [1.0.2] - October 10, 2023
- Added `OutlineText` component.

## [1.0.1] - October 10, 2023
- Allowed color customization for the `CenterAlignedTopAppBar` component.

## [1.0.0] - September 27, 2023
- First release of the Design System Cezanne for Android.
