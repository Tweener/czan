# Search Input

The `SearchInput` component provides a specialized text input for search functionality with built-in search styling and query handling capabilities.

<div style="position: relative; max-width: 800px; height: 540px; border-radius: 20px; overflow: hidden; border: 1px solid #777;">
    <iframe id="demoIframe" style="position: absolute; top: 0; left: 0; width: 100%; height: 100%; border: none;" src="../../demo/index.html?id=searchinput" title="Demo" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin"></iframe>
</div>

## Usage

### Basic Search Input

```kotlin
SearchInput(
    modifier = Modifier.fillMaxWidth(),
    placeholderText = "Search...",
    onQueryChanged = { query ->
        // Handle search query
        performSearch(query)
    }
)
```

### Search with Custom Placeholder

```kotlin
SearchInput(
    modifier = Modifier.fillMaxWidth(),
    placeholderText = "Search for products, brands, or categories...",
    onQueryChanged = { query ->
        if (query.length >= 3) {
            searchProducts(query)
        }
    }
)
```

### Search with Query Validation

```kotlin
var searchQuery by remember { mutableStateOf("") }

Column {
    SearchInput(
        modifier = Modifier.fillMaxWidth(),
        placeholderText = "Type to search...",
        onQueryChanged = { query ->
            searchQuery = query
            if (query.length >= 3) {
                performSearch(query)
            }
        }
    )
    
    if (searchQuery.isNotEmpty() && searchQuery.length < 3) {
        Text(
            text = "Type at least 3 characters",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.error
        )
    }
}
```

### Multiple Search Inputs

```kotlin
Column(
    verticalArrangement = Arrangement.spacedBy(8.dp)
) {
    SearchInput(
        modifier = Modifier.fillMaxWidth(),
        placeholderText = "Search users...",
        onQueryChanged = { searchUsers(it) }
    )
    
    SearchInput(
        modifier = Modifier.fillMaxWidth(),
        placeholderText = "Search messages...",
        onQueryChanged = { searchMessages(it) }
    )
    
    SearchInput(
        modifier = Modifier.fillMaxWidth(),
        placeholderText = "Search files...",
        onQueryChanged = { searchFiles(it) }
    )
}
```

### Search with Real-time Results

```kotlin
var query by remember { mutableStateOf("") }
var results by remember { mutableStateOf(emptyList<String>()) }

LaunchedEffect(query) {
    if (query.isNotEmpty()) {
        // Debounce search
        delay(300)
        results = performSearch(query)
    } else {
        results = emptyList()
    }
}

Column {
    SearchInput(
        modifier = Modifier.fillMaxWidth(),
        placeholderText = "Search...",
        onQueryChanged = { query = it }
    )
    
    LazyColumn {
        items(results) { result ->
            Text(text = result)
        }
    }
}
```