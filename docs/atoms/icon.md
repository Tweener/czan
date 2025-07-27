# Icon

The `Icon` component displays icons from various sources including Material Design icons, vector graphics, drawable resources, and painters. It supports customizable sizes, colors, and tinting.

<div style="position: relative; max-width: 800px; height: 540px; border-radius: 20px; overflow: hidden; border: 1px solid #777;">
    <iframe id="demoIframe" style="position: absolute; top: 0; left: 0; width: 100%; height: 100%; border: none;" src="../../demo/index.html?id=icon" title="Demo" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin"></iframe>
</div>

## Usage

### Material Design Icons

```kotlin
Icon(
    imageVector = Icons.Default.Home,
    contentDescription = "Home"
)

Icon(
    imageVector = Icons.Default.Favorite,
    contentDescription = "Favorite"
)

Icon(
    imageVector = Icons.Default.Settings,
    contentDescription = "Settings"
)
```

### Icon with Custom Tint

```kotlin
Icon(
    imageVector = Icons.Default.Favorite,
    tint = Color.Red,
    contentDescription = "Red heart"
)

Icon(
    imageVector = Icons.Default.Star,
    tint = MaterialTheme.colorScheme.primary,
    contentDescription = "Primary star"
)
```

### Drawable Resource Icons

```kotlin
Icon(
    resource = Res.drawable.my_icon,
    contentDescription = "Custom icon"
)

Icon(
    resource = Res.drawable.logo,
    tint = MaterialTheme.colorScheme.onSurface,
    contentDescription = "Logo"
)
```

### Different Icon Sizes

```kotlin
Icon(
    modifier = Modifier.size(16.dp),
    imageVector = Icons.Default.Star,
    contentDescription = "Small star"
)

Icon(
    modifier = Modifier.size(24.dp),
    imageVector = Icons.Default.Star,
    contentDescription = "Medium star"
)

Icon(
    modifier = Modifier.size(48.dp),
    imageVector = Icons.Default.Star,
    contentDescription = "Large star"
)
```

### Icon with Painter

```kotlin
val painter = painterResource(Res.drawable.my_icon)

Icon(
    painter = painter,
    contentDescription = "Painter icon"
)

Icon(
    painter = painter,
    tint = Color.Blue,
    contentDescription = "Blue painter icon"
)
```

### Themed Icons

```kotlin
// Primary themed icon
Icon(
    imageVector = Icons.Default.Add,
    tint = MaterialTheme.colorScheme.primary,
    contentDescription = "Add"
)

// Error themed icon
Icon(
    imageVector = Icons.Default.Error,
    tint = MaterialTheme.colorScheme.error,
    contentDescription = "Error"
)

// On surface icon
Icon(
    imageVector = Icons.Default.Info,
    tint = MaterialTheme.colorScheme.onSurface,
    contentDescription = "Info"
)
```