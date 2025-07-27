# Scaffold

The `Scaffold` component provides the basic layout structure for screens, including top bar, bottom navigation, floating action button, and content area with proper padding and positioning.

<div style="position: relative; max-width: 800px; height: 540px; border-radius: 20px; overflow: hidden; border: 1px solid #777;">
    <iframe id="demoIframe" style="position: absolute; top: 0; left: 0; width: 100%; height: 100%; border: none;" src="../../demo/index.html?id=scaffold" title="Demo" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin"></iframe>
</div>

## Usage

### Basic Scaffold with Top Bar

```kotlin
Scaffold(
    topBar = {
        SimpleTopBar(
            title = "My App",
            textStyle = MaterialTheme.typography.titleLarge
        )
    }
) { paddingValues ->
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .padding(16.dp)
    ) {
        Text("Content goes here")
    }
}
```

### Scaffold with Navigation Bar

```kotlin
var selectedTab by remember { mutableIntStateOf(0) }

Scaffold(
    topBar = {
        SimpleTopBar(title = "Home")
    },
    navigationBar = {
        NavigationBar {
            NavigationBarItem(
                icon = Icons.Default.Home,
                selected = selectedTab == 0,
                onClick = { selectedTab = 0 },
                label = "Home"
            )
            NavigationBarItem(
                icon = Icons.Default.Search,
                selected = selectedTab == 1,
                onClick = { selectedTab = 1 },
                label = "Search"
            )
        }
    }
) { paddingValues ->
    // Content with proper padding
}
```

### Scaffold with Floating Action Button

```kotlin
Scaffold(
    topBar = {
        SimpleTopBar(title = "Tasks")
    },
    floatingActionButton = {
        FloatingActionButton(
            icon = Icons.Default.Add,
            onClick = { /* Add new task */ }
        )
    },
    floatingActionButtonPosition = FabPosition.End
) { paddingValues ->
    LazyColumn(
        modifier = Modifier.padding(paddingValues)
    ) {
        // List items
    }
}
```

### Complete Scaffold Layout

```kotlin
Scaffold(
    topBar = {
        TopBarWithBackButton(
            title = "Details",
            textStyle = MaterialTheme.typography.titleLarge,
            onBackClicked = { /* Navigate back */ },
            actions = {
                TopBarAction(
                    icon = Icons.Default.Share,
                    onClick = { /* Share */ }
                )
            }
        )
    },
    navigationBar = {
        NavigationBar {
            // Navigation items
        }
    },
    floatingActionButton = {
        FloatingActionButton(
            icon = Icons.Default.Edit,
            onClick = { /* Edit */ }
        )
    },
    snackbarHost = {
        SnackbarHost(hostState = snackbarHostState)
    }
) { paddingValues ->
    // Main content
}
```

### Scaffold with Custom Colors

```kotlin
Scaffold(
    containerColor = MaterialTheme.colorScheme.surface,
    contentColor = MaterialTheme.colorScheme.onSurface,
    topBar = { /* Top bar */ },
    navigationBar = { /* Navigation */ }
) { paddingValues ->
    // Content
}
```