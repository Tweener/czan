# Button

`Button` is highly customizable, allowing you to adjust styles, sizes, states, and add icons to fit various design and interaction needs.

<div style="position: relative; max-width: 800px; height: 340px; border-radius: 20px; overflow: hidden; border: 1px solid #777;">
    <iframe id="demoIframe" style="position: absolute; top: 0; left: 0; width: 100%; height: 100%; border: none;" src="../../demo/index.html" title="Demo" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin"></iframe>
</div>

## Usage

### Basic example

```kotlin
// Primary button with regular size
Button(
    text = "Primary",
    style = ButtonStyle.PRIMARY,
    size = ButtonSize.REGULAR,
    onClick = { /* Handle click */ },
)

// Secondary button with big size and text as a resource
Button(
    text = stringResource(resource = Res.string.my_button),
    style = ButtonStyle.SECONDARY,
    size = ButtonSize.BIG,
    onClick = { /* Handle click */ },
)

// Disabled button with small size
Button(
    text = "Disabled",
    enabled = false,
    style = ButtonStyle.PRIMARY,
    size = ButtonSize.SMALL,
    onClick = { /* Handle click */ },
)
```

### Button with icon

```kotlin
// Delete button with trash can leading icon
Button(
    text = "Leading Icon",
    style = ButtonStyle.ERROR,
    leadingIcon = Res.drawable.trash,
    onClick = { /* Handle click */ },
)
```

### Button with loading state

```kotlin
var loading by remember { mutableStateOf(false) }

Button(
    text = "Click to load",
    size = ButtonSize.SMALL,
    loading = loading,
    loadingStyle = ButtonLoadingStyle.FADE,
    onClick = { loading = loading.not() }
)
```
