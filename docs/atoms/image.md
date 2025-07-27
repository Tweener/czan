# Image

The `Image` component displays images from various sources including vector graphics, drawable resources, and network URLs. It supports different content scales, alignments, and loading states.

<div style="position: relative; max-width: 800px; height: 540px; border-radius: 20px; overflow: hidden; border: 1px solid #777;">
    <iframe id="demoIframe" style="position: absolute; top: 0; left: 0; width: 100%; height: 100%; border: none;" src="../../demo/index.html?id=image" title="Demo" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin"></iframe>
</div>

## Usage

### Vector Image

```kotlin
Image(
    modifier = Modifier.size(48.dp),
    imageVector = Icons.Default.Star,
    contentDescription = "Star icon"
)
```

### Resource Image

```kotlin
Image(
    modifier = Modifier.size(64.dp),
    resource = Res.drawable.my_image,
    contentScale = ContentScale.Crop,
    contentDescription = "My image"
)
```

### Network Image with Placeholder

```kotlin
Image(
    modifier = Modifier.size(80.dp),
    imageUrl = "https://example.com/image.jpg",
    placeholderRes = Res.drawable.placeholder,
    imageSize = ImageSize(200, 200),
    contentDescription = "Network image"
)
```

### Circular Network Image

```kotlin
Image(
    modifier = Modifier.size(60.dp),
    imageUrl = "https://example.com/avatar.jpg",
    placeholderRes = Res.drawable.default_avatar,
    circleCrop = true,
    contentDescription = "User avatar"
)
```

### Image with Color Filter

```kotlin
Image(
    modifier = Modifier.size(32.dp),
    imageVector = Icons.Default.Favorite,
    colorFilter = ColorFilter.tint(Color.Red),
    contentDescription = "Red heart"
)
```

### Image with Different Content Scales

```kotlin
// Crop to fill
Image(
    modifier = Modifier.size(100.dp),
    resource = Res.drawable.photo,
    contentScale = ContentScale.Crop,
    contentDescription = "Cropped photo"
)

// Fit inside bounds
Image(
    modifier = Modifier.size(100.dp),
    resource = Res.drawable.photo,
    contentScale = ContentScale.Fit,
    contentDescription = "Fitted photo"
)
```