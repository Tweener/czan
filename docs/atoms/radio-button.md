# Radio Button

The `RadioButton` component allows users to select one option from a set of mutually exclusive choices. It supports custom colors and can be grouped with other radio buttons for single selection.

<div style="position: relative; max-width: 800px; height: 540px; border-radius: 20px; overflow: hidden; border: 1px solid #777;">
    <iframe id="demoIframe" style="position: absolute; top: 0; left: 0; width: 100%; height: 100%; border: none;" src="../../demo/index.html?id=radiobutton" title="Demo" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin"></iframe>
</div>

## Usage

### Basic Radio Button

```kotlin
RadioButton(
    checked = isSelected,
    onCheckedChange = { isSelected = it }
)
```

### Radio Button Group

```kotlin
val options = listOf("Option 1", "Option 2", "Option 3")
var selectedOption by remember { mutableIntStateOf(0) }

Column {
    options.forEachIndexed { index, option ->
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                checked = selectedOption == index,
                onCheckedChange = { selectedOption = index }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = option)
        }
    }
}
```

### Radio Button with Custom Colors

```kotlin
RadioButton(
    checked = isSelected,
    onCheckedChange = { isSelected = it },
    colors = RadioButtonDefaults.colors(
        contentColor = Color.Blue,
        checkedContentColor = Color.Blue
    )
)
```

### Disabled Radio Button

```kotlin
RadioButton(
    checked = true,
    onCheckedChange = null,
    colors = RadioButtonDefaults.colors(
        disabledContentColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f)
    )
)
```

### Radio Button Group with Different Styles

```kotlin
val styleOptions = listOf("Small", "Medium", "Large")
val textStyles = listOf(
    MaterialTheme.typography.bodySmall,
    MaterialTheme.typography.bodyMedium,
    MaterialTheme.typography.bodyLarge
)
var selectedStyle by remember { mutableIntStateOf(0) }

Column {
    styleOptions.forEachIndexed { index, option ->
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                checked = selectedStyle == index,
                onCheckedChange = { selectedStyle = index }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = option,
                style = textStyles[index]
            )
        }
    }
}
```