# Box

Here you will find the list of different boxes available.

## BoxWithAnimatedBorder

The `BoxWithAnimatedBorder` is a regular `Box` component that includes an animated border. It is useful for creating visually appealing containers that draw attention to their content.

<div style="position: relative; max-width: 800px; height: 540px; border-radius: 20px; overflow: hidden; border: 1px solid #777;">
    <iframe id="demoIframe" style="position: absolute; top: 0; left: 0; width: 100%; height: 100%; border: none;" src="../../demo/index.html?id=box" title="Demo" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin"></iframe>
</div>

## Usage

### Basic example

```kotlin
BoxWithAnimatedBorder(
    borderColors = listOf(
        MaterialTheme.colorScheme.primary,
        MaterialTheme.colorScheme.secondary,
        MaterialTheme.colorScheme.tertiary,
        MaterialTheme.colorScheme.tertiary,
        MaterialTheme.colorScheme.secondary,
        MaterialTheme.colorScheme.primary
    ),
    borderWidth = 2.dp,
) {
    Text(text = "Some content inside the Box with animated border")
}
```
