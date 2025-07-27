# Snackbar

The `Snackbar` component displays brief messages at the bottom of the screen, often with an optional action. It's typically used for notifications, confirmations, or error messages.

<div style="position: relative; max-width: 800px; height: 540px; border-radius: 20px; overflow: hidden; border: 1px solid #777;">
    <iframe id="demoIframe" style="position: absolute; top: 0; left: 0; width: 100%; height: 100%; border: none;" src="../../demo/index.html?id=snackbar" title="Demo" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin"></iframe>
</div>

## Usage

### Basic Snackbar Setup

```kotlin
val snackbarHostState = rememberSnackbarHostState()
val scope = rememberCoroutineScope()

Scaffold(
    snackbarHost = {
        Snackbar(hostState = snackbarHostState)
    }
) { paddingValues ->
    Button(
        onClick = {
            scope.launch {
                snackbarHostState.showSnackbar("Hello World!")
            }
        }
    ) {
        Text("Show Snackbar")
    }
}
```

### Snackbar with Action

```kotlin
Button(
    onClick = {
        scope.launch {
            val result = snackbarHostState.showSnackbar(
                message = "Message sent",
                actionLabel = "Undo"
            )
            when (result) {
                SnackbarResult.ActionPerformed -> {
                    // Handle undo action
                }
                SnackbarResult.Dismissed -> {
                    // Handle dismissal
                }
            }
        }
    }
) {
    Text("Send Message")
}
```

### Error Snackbar

```kotlin
Button(
    onClick = {
        scope.launch {
            snackbarHostState.showSnackbar(
                message = "Error: Failed to save changes",
                actionLabel = "Retry"
            )
        }
    }
) {
    Text("Show Error")
}
```

### Success Snackbar

```kotlin
Button(
    onClick = {
        scope.launch {
            snackbarHostState.showSnackbar(
                message = "✓ Changes saved successfully",
                actionLabel = "View"
            )
        }
    }
) {
    Text("Save Changes")
}
```

### Custom Snackbar Colors

```kotlin
Snackbar(
    hostState = snackbarHostState,
    colors = SnackbarDefaults.snackbarColors(
        containerColor = MaterialTheme.colorScheme.error,
        contentColor = MaterialTheme.colorScheme.onError,
        actionColor = MaterialTheme.colorScheme.errorContainer
    )
)
```

### Long Message Snackbar

```kotlin
Button(
    onClick = {
        scope.launch {
            snackbarHostState.showSnackbar(
                message = "This is a much longer snackbar message that demonstrates how text wraps in the snackbar component",
                actionLabel = "Dismiss"
            )
        }
    }
) {
    Text("Long Message")
}
```

### Multiple Snackbars (Queued)

```kotlin
Column {
    Button(
        onClick = {
            scope.launch {
                snackbarHostState.showSnackbar("First message")
            }
        }
    ) {
        Text("Show First")
    }
    
    Button(
        onClick = {
            scope.launch {
                snackbarHostState.showSnackbar("Second message")
            }
        }
    ) {
        Text("Show Second")
    }
}
```