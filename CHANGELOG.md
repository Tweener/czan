# Changelog

## [2.8.0] - January 12, 2025
- [AlertDialog](https://github.com/Tweener/czan/blob/main/czan/src/commonMain/kotlin/com/tweener/czan/designsystem/atom/dialog/AlertDialog.kt) now uses Material 3 for non-iOS targets and Cupertino for iOS target (via UIKit).
- [CarouselDashes](https://github.com/Tweener/czan/blob/main/czan/src/commonMain/kotlin/com/tweener/czan/designsystem/molecule/carousel/CarouselDashes.kt#L26) - Auto-switch to next dash animation can now be disabled using `animated = false`.
- Update Kotlin to 2.1.0.
- Update Compose Multiplatform to 1.7.3.
- Update Gradle to 8.11.1.
- New basic [sample apps](https://github.com/Tweener/czan/tree/main/sample) on Android and iOS to showcase CZAN. _For now, only `Button` and `AlertDialog` are added to the sample._
