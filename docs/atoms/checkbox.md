# Checkbox

The `Checkbox` component has a checked or unchecked state, allowing users to select or deselect an option. It is customizable in appearance and behavior to fit different use cases and design
requirements.

<div style="position: relative; max-width: 800px; height: 540px; border-radius: 20px; overflow: hidden; border: 1px solid #777;">
    <iframe id="demoIframe" style="position: absolute; top: 0; left: 0; width: 100%; height: 100%; border: none;" src="../../demo/index.html?id=checkbox" title="Demo" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin"></iframe>
</div>

## Usage

### Basic example

```kotlin
// A simple checkbox already checked
Checkbox(
    checked = true,
    onCheckedChange = { checked -> /* Handle checked state change */ },
)

// A simple checkbox not checked
Checkbox(
    checked = false,
    onCheckedChange = { checked -> /* Handle checked state change */ },
)
```

### Checkbox with text

```kotlin
Checkbox(
    text = "This is checkbox",
    checked = true,
    onCheckedChange = { checked -> /* Handle checked state change */ },
)
```

### Checkbox with custom style

```kotlin
Checkbox(
    text = "This is a customized checkbox",
    checked = true,
    textStyle = MaterialTheme.typography.titleLarge,
    colors = CheckboxDefaults.colors(
        contentColor = MaterialTheme.colorScheme.primary,
        checkedColor = Color.LightGray,
        checkmarkColor = Color.Red,
    ),
    contentPadding = 8.dp,
)
```
