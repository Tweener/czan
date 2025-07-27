# Bars

The `Bars` components provide navigation and top app bar functionality for your application. They include both navigation bars for bottom navigation and various top app bar configurations.

<div style="position: relative; max-width: 800px; height: 540px; border-radius: 20px; overflow: hidden; border: 1px solid #777;">
    <iframe id="demoIframe" style="position: absolute; top: 0; left: 0; width: 100%; height: 100%; border: none;" src="../../demo/index.html?id=bars" title="Demo" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin"></iframe>
</div>

## Usage

### Navigation Bar

```kotlin
NavigationBar {
    NavigationBarItem(
        icon = Icons.Default.Home,
        selected = selectedItem == 0,
        onClick = { selectedItem = 0 },
        label = "Home"
    )
    NavigationBarItem(
        icon = Icons.Default.Search,
        selected = selectedItem == 1,
        onClick = { selectedItem = 1 },
        label = "Search"
    )
}
```

### Simple Top Bar

```kotlin
SimpleTopBar(
    title = "My App",
    textStyle = MaterialTheme.typography.titleLarge,
    actions = {
        TopBarAction(
            icon = Icons.Default.Settings,
            onClick = { /* Handle action */ },
            contentDescription = "Settings"
        )
    }
)
```

### Top Bar with Back Button

```kotlin
TopBarWithBackButton(
    title = "Details",
    textStyle = MaterialTheme.typography.titleLarge,
    onBackClicked = { /* Handle back navigation */ },
    actions = {
        TopBarAction(
            icon = Icons.Default.Share,
            onClick = { /* Handle share */ },
            contentDescription = "Share"
        )
    }
)
```

### Center Aligned Top Bar

```kotlin
CenterAlignedTopAppBar(
    title = "Centered Title",
    textStyle = MaterialTheme.typography.titleLarge,
    logo = painterResource(R.drawable.logo),
    actions = {
        TopBarAction(
            icon = Icons.Default.MoreVert,
            onClick = { /* Handle menu */ },
            contentDescription = "More options"
        )
    }
)
```