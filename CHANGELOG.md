# Changelog

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
