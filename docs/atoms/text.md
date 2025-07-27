# Text

The `Text` component displays text content with extensive customization options including typography styles, colors, alignment, overflow handling, and font properties. It supports both string literals and string resources.

<div style="position: relative; max-width: 800px; height: 540px; border-radius: 20px; overflow: hidden; border: 1px solid #777;">
    <iframe id="demoIframe" style="position: absolute; top: 0; left: 0; width: 100%; height: 100%; border: none;" src="../../demo/index.html?id=text" title="Demo" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin"></iframe>
</div>

## Usage

### Basic Text

```kotlin
Text(text = "Hello World")

Text(
    text = "Welcome to CZAN",
    style = MaterialTheme.typography.headlineMedium
)
```

### Typography Styles

```kotlin
Text(
    text = "Display Large",
    style = MaterialTheme.typography.displayLarge
)

Text(
    text = "Headline Medium",
    style = MaterialTheme.typography.headlineMedium
)

Text(
    text = "Body Large",
    style = MaterialTheme.typography.bodyLarge
)

Text(
    text = "Label Small",
    style = MaterialTheme.typography.labelSmall
)
```

### Text Colors

```kotlin
Text(
    text = "Primary Color",
    color = MaterialTheme.colorScheme.primary
)

Text(
    text = "Error Color",
    color = MaterialTheme.colorScheme.error
)

Text(
    text = "Custom Red",
    color = Color.Red
)
```

### Font Weights and Styles

```kotlin
Text(
    text = "Bold Text",
    fontWeight = FontWeight.Bold,
    style = MaterialTheme.typography.bodyLarge
)

Text(
    text = "Light Text",
    fontWeight = FontWeight.Light,
    style = MaterialTheme.typography.bodyLarge
)

Text(
    text = "Italic Text",
    fontStyle = FontStyle.Italic,
    style = MaterialTheme.typography.bodyLarge
)
```

### Text Alignment

```kotlin
Text(
    modifier = Modifier.fillMaxWidth(),
    text = "Center Aligned",
    textAlign = TextAlign.Center,
    style = MaterialTheme.typography.bodyLarge
)

Text(
    modifier = Modifier.fillMaxWidth(),
    text = "Right Aligned",
    textAlign = TextAlign.End,
    style = MaterialTheme.typography.bodyLarge
)
```

### Text Overflow

```kotlin
Text(
    text = "This is a very long text that will be truncated with ellipsis",
    maxLines = 1,
    overflow = TextOverflow.Ellipsis,
    style = MaterialTheme.typography.bodyMedium
)

Text(
    text = "This text is limited to 2 lines maximum and will show ellipsis after that",
    maxLines = 2,
    overflow = TextOverflow.Ellipsis,
    style = MaterialTheme.typography.bodyMedium
)
```

### String Resources

```kotlin
Text(
    text = stringResource(Res.string.welcome_message),
    style = MaterialTheme.typography.headlineSmall
)

Text(
    text = stringResource(Res.string.app_description),
    style = MaterialTheme.typography.bodyMedium,
    color = MaterialTheme.colorScheme.onSurfaceVariant
)
```

### Multi-line Text

```kotlin
Text(
    text = """
        This is a multi-line text example.
        It demonstrates how text wraps across
        multiple lines automatically.
    """.trimIndent(),
    style = MaterialTheme.typography.bodyMedium
)
```

### Styled Text Combinations

```kotlin
Text(
    text = "Important Notice",
    style = MaterialTheme.typography.titleMedium,
    fontWeight = FontWeight.SemiBold,
    color = MaterialTheme.colorScheme.error
)

Text(
    text = "Subtitle with custom styling",
    style = MaterialTheme.typography.bodySmall,
    fontStyle = FontStyle.Italic,
    color = MaterialTheme.colorScheme.onSurfaceVariant
)
```