# Slider

The `Slider` component allows users to select a value from a range by dragging a thumb along a track. It supports custom ranges, steps, and colors for various use cases.

<div style="position: relative; max-width: 800px; height: 540px; border-radius: 20px; overflow: hidden; border: 1px solid #777;">
    <iframe id="demoIframe" style="position: absolute; top: 0; left: 0; width: 100%; height: 100%; border: none;" src="../../demo/index.html?id=slider" title="Demo" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin"></iframe>
</div>

## Usage

### Basic Slider

```kotlin
var sliderValue by remember { mutableFloatStateOf(0.5f) }

Slider(
    value = sliderValue,
    onValueChange = { sliderValue = it },
    modifier = Modifier.fillMaxWidth()
)
```

### Slider with Custom Range

```kotlin
var temperature by remember { mutableFloatStateOf(25f) }

Slider(
    value = temperature,
    onValueChange = { temperature = it },
    valueRange = 0f..100f,
    modifier = Modifier.fillMaxWidth()
)

Text("Temperature: ${temperature.roundToInt()}°C")
```

### Slider with Steps

```kotlin
var rating by remember { mutableFloatStateOf(5f) }

Slider(
    value = rating,
    onValueChange = { rating = it },
    valueRange = 0f..10f,
    steps = 9, // Creates 11 positions (0, 1, 2, ..., 10)
    modifier = Modifier.fillMaxWidth()
)

Text("Rating: ${rating.roundToInt()}/10")
```

### Slider with Custom Colors

```kotlin
var volume by remember { mutableFloatStateOf(0.7f) }

Slider(
    value = volume,
    onValueChange = { volume = it },
    colors = SliderDefaults.sliderColors(
        thumbColor = Color.Red,
        activeTrackColor = Color.Red,
        inactiveTrackColor = Color.Red.copy(alpha = 0.3f)
    ),
    modifier = Modifier.fillMaxWidth()
)

Text("Volume: ${(volume * 100).roundToInt()}%")
```

### Disabled Slider

```kotlin
Slider(
    value = 0.3f,
    onValueChange = { },
    enabled = false,
    modifier = Modifier.fillMaxWidth()
)

Text("Disabled at 30%")
```

### Brightness Control Slider

```kotlin
var brightness by remember { mutableFloatStateOf(0.8f) }

Column {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Icon(Icons.Default.Brightness2, contentDescription = "Low")
        
        Slider(
            value = brightness,
            onValueChange = { brightness = it },
            modifier = Modifier.weight(1f)
        )
        
        Icon(Icons.Default.BrightnessHigh, contentDescription = "High")
    }
    
    Text("Brightness: ${(brightness * 100).roundToInt()}%")
}
```

### Color Mixer Sliders

```kotlin
var red by remember { mutableFloatStateOf(0.8f) }
var green by remember { mutableFloatStateOf(0.6f) }
var blue by remember { mutableFloatStateOf(0.4f) }

Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
    // Red slider
    Column {
        Text("Red: ${(red * 255).roundToInt()}")
        Slider(
            value = red,
            onValueChange = { red = it },
            colors = SliderDefaults.sliderColors(
                thumbColor = Color.Red,
                activeTrackColor = Color.Red
            )
        )
    }
    
    // Green slider
    Column {
        Text("Green: ${(green * 255).roundToInt()}")
        Slider(
            value = green,
            onValueChange = { green = it },
            colors = SliderDefaults.sliderColors(
                thumbColor = Color.Green,
                activeTrackColor = Color.Green
            )
        )
    }
    
    // Blue slider
    Column {
        Text("Blue: ${(blue * 255).roundToInt()}")
        Slider(
            value = blue,
            onValueChange = { blue = it },
            colors = SliderDefaults.sliderColors(
                thumbColor = Color.Blue,
                activeTrackColor = Color.Blue
            )
        )
    }
    
    // Color preview
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(Color(red, green, blue))
    )
}
```