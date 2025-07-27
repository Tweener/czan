# Dialog

The `AlertDialog` component displays important information or requests user confirmation. It supports customizable titles, messages, actions, and icons across different platforms.

<div style="position: relative; max-width: 800px; height: 540px; border-radius: 20px; overflow: hidden; border: 1px solid #777;">
    <iframe id="demoIframe" style="position: absolute; top: 0; left: 0; width: 100%; height: 100%; border: none;" src="../../demo/index.html?id=dialog" title="Demo" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin"></iframe>
</div>

## Usage

### Basic Alert Dialog

```kotlin
AlertDialog(
    title = "Confirm Action",
    message = "Are you sure you want to continue?",
    confirmButtonLabel = "Continue",
    dismissButtonLabel = "Cancel",
    onConfirmButtonClicked = { /* Handle confirm */ },
    onDismiss = { /* Handle dismiss */ }
)
```

### Confirmation Only Dialog

```kotlin
AlertDialog(
    title = "Information",
    message = "This is an informational message.",
    confirmButtonLabel = "Got it",
    onConfirmButtonClicked = { /* Handle confirm */ },
    onDismiss = { /* Handle dismiss */ }
)
```

### Dialog with Icon

```kotlin
AlertDialog(
    title = "Warning",
    message = "This action cannot be undone.",
    confirmButtonLabel = "Delete",
    dismissButtonLabel = "Cancel",
    icon = Icons.Default.Warning,
    onConfirmButtonClicked = { /* Handle confirm */ },
    onDismiss = { /* Handle dismiss */ }
)
```

### Success Dialog

```kotlin
AlertDialog(
    title = "Success",
    message = "Your changes have been saved successfully.",
    confirmButtonLabel = "Continue",
    icon = Icons.Default.CheckCircle,
    onConfirmButtonClicked = { /* Handle confirm */ },
    onDismiss = { /* Handle dismiss */ }
)
```