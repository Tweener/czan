# Line

The `Line` components provide horizontal and vertical dashed lines for visual separation and layout structure. They support customizable dash patterns, colors, and thickness.

<div style="position: relative; max-width: 800px; height: 540px; border-radius: 20px; overflow: hidden; border: 1px solid #777;">
    <iframe id="demoIframe" style="position: absolute; top: 0; left: 0; width: 100%; height: 100%; border: none;" src="../../demo/index.html?id=line" title="Demo" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin"></iframe>
</div>

## Usage

### Basic Horizontal Dashed Line

```kotlin
HorizontalDashedLine(
    modifier = Modifier.fillMaxWidth()
)
```

### Horizontal Line with Custom Color

```kotlin
HorizontalDashedLine(
    modifier = Modifier.fillMaxWidth(),
    colors = LineDefaults.lineColors(
        strokeColor = MaterialTheme.colorScheme.primary
    )
)
```

### Horizontal Line with Custom Dash Pattern

```kotlin
HorizontalDashedLine(
    modifier = Modifier.fillMaxWidth(),
    colors = LineDefaults.lineColors(
        strokeColor = Color.Red
    ),
    sizes = LineDefaults.lineSizes(
        dashOn = 8.dp,
        dashOff = 4.dp,
        thickness = 2.dp
    )
)
```

### Vertical Dashed Line

```kotlin
Row(modifier = Modifier.height(100.dp)) {
    Text("Left Content")
    
    VerticalDashedLine(
        modifier = Modifier.padding(horizontal = 8.dp),
        colors = LineDefaults.lineColors(
            strokeColor = MaterialTheme.colorScheme.outline
        )
    )
    
    Text("Right Content")
}
```

### Thick Vertical Line

```kotlin
VerticalDashedLine(
    modifier = Modifier.height(50.dp),
    colors = LineDefaults.lineColors(
        strokeColor = Color.Blue
    ),
    sizes = LineDefaults.lineSizes(
        dashOn = 6.dp,
        dashOff = 3.dp,
        thickness = 4.dp
    )
)
```

### Fine Dotted Line

```kotlin
HorizontalDashedLine(
    modifier = Modifier.fillMaxWidth(),
    colors = LineDefaults.lineColors(
        strokeColor = MaterialTheme.colorScheme.onSurfaceVariant
    ),
    sizes = LineDefaults.lineSizes(
        dashOn = 2.dp,
        dashOff = 2.dp,
        thickness = 1.dp
    )
)
```