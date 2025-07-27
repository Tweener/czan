# Switch

The `Switch` component allows users to toggle between two states (on/off). It provides visual feedback with customizable styles and supports both standalone switches and switches with accompanying text labels.

<div style="position: relative; max-width: 800px; height: 540px; border-radius: 20px; overflow: hidden; border: 1px solid #777;">
    <iframe id="demoIframe" style="position: absolute; top: 0; left: 0; width: 100%; height: 100%; border: none;" src="../../demo/index.html?id=switch" title="Demo" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin"></iframe>
</div>

## Usage

### Basic example

```kotlin
// A simple switch in checked state
Switch(
    checked = true,
    onCheckedChange = { isChecked -> /* Handle state change */ },
)

// A simple switch in unchecked state
Switch(
    checked = false,
    onCheckedChange = { isChecked -> /* Handle state change */ },
)
```

### Switch with different styles

```kotlin
// Primary style switch
Switch(
    style = SwitchStyle.PRIMARY,
    checked = true,
    onCheckedChange = { isChecked -> /* Handle state change */ },
)

// Secondary style switch
Switch(
    style = SwitchStyle.SECONDARY,
    checked = false,
    onCheckedChange = { isChecked -> /* Handle state change */ },
)

// Tertiary style switch
Switch(
    style = SwitchStyle.TERTIARY,
    checked = true,
    onCheckedChange = { isChecked -> /* Handle state change */ },
)
```

### Disabled switch

```kotlin
// Disabled switch in checked state
Switch(
    checked = true,
    enabled = false,
    onCheckedChange = null,
)

// Disabled switch in unchecked state
Switch(
    checked = false,
    enabled = false,
    onCheckedChange = null,
)
```

### Switch with text

```kotlin
// Switch with accompanying text label
SwitchWithText(
    text = "Enable notifications",
    checked = true,
    onCheckedChange = { isChecked -> /* Handle state change */ },
)

// Disabled switch with text
SwitchWithText(
    text = "Dark mode",
    checked = false,
    onCheckedChange = null,
)
```