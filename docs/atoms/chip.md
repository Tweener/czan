# Chip

A Chip is a compact UI element that represents an input, attribute, or action. The `Chip` component is likely implemented as a reusable UI atom in your design system, typically used to display information, filter content, or trigger actions. Chips often include text, icons, or avatars and can be interactive (clickable, removable) or static, depending on their configuration.

<div style="position: relative; max-width: 800px; height: 540px; border-radius: 20px; overflow: hidden; border: 1px solid #777;">
    <iframe id="demoIframe" style="position: absolute; top: 0; left: 0; width: 100%; height: 100%; border: none;" src="../../demo/index.html?id=chip" title="Demo" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin"></iframe>
</div>

## Usage

### Basic example

```kotlin
// A simple chip with a title
Chip(
    title = "Chip title",
    leadingIconVector = null,
    canBeDeleted = false,
    onClick = { /* Handle chip click */ },
)

// A simple chip with selected state
Chip(
    title = "Chip title",
    leadingIconVector = null,
    canBeDeleted = false,
    selected = true,
)
```

### Chip with leading icon

```kotlin
Chip(
    title = "Chip title",
    leadingIconVector = Icons.Filled.AccountCircle,
    canBeDeleted = false,
)
```

### Chip deletable

```kotlin
Chip(
    title = "Chip title",
    leadingIconVector = null,
    canBeDeleted = true,
    onCloseClick = { /* Handle close chip */ },
)
```

### Chip with custom style

```kotlin
Chip(
    title = "Chip customized",
    leadingIconVector = Icons.Filled.Person,
    canBeDeleted = true,
    textStyle = MaterialTheme.typography.titleMedium,
    colors = ChipDefaults.chipColors(
        leadingIconBackgroundColor = Color.Gray,
        leadingIconBorderColor = Color.Red
    ),
    sizes = ChipDefaults.chipSizes(
        iconsSize = 32.dp,
        iconBorderWidth = 1.dp,
        iconPadding = 3.dp,
    ),
    contentPadding = PaddingValues(vertical = 12.dp),
)
```
