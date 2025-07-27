# TextField

The `TextField` component provides text input functionality with extensive customization options including different input types, sizes, validation states, and keyboard configurations. It supports single-line and multi-line input.

<div style="position: relative; max-width: 800px; height: 540px; border-radius: 20px; overflow: hidden; border: 1px solid #777;">
    <iframe id="demoIframe" style="position: absolute; top: 0; left: 0; width: 100%; height: 100%; border: none;" src="../../demo/index.html?id=textfield" title="Demo" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin"></iframe>
</div>

## Usage

### Basic TextField

```kotlin
var text by remember { mutableStateOf("") }

TextField(
    text = text,
    onValueChanged = { text = it },
    label = "Enter text",
    placeholderText = "Type here..."
)
```

### TextField with Different Types

```kotlin
var email by remember { mutableStateOf("") }
var password by remember { mutableStateOf("") }

TextField(
    text = email,
    onValueChanged = { email = it },
    label = "Email",
    type = TextFieldType.EMAIL,
    placeholderText = "your@email.com"
)

TextField(
    text = password,
    onValueChanged = { password = it },
    label = "Password",
    type = TextFieldType.PASSWORD_HIDDEN,
    placeholderText = "Enter password"
)
```

### TextField Sizes

```kotlin
TextField(
    text = "",
    onValueChanged = { },
    label = "Small",
    size = TextFieldSize.SMALL,
    placeholderText = "Small field"
)

TextField(
    text = "",
    onValueChanged = { },
    label = "Regular",
    size = TextFieldSize.REGULAR,
    placeholderText = "Regular field"
)

TextField(
    text = "",
    onValueChanged = { },
    label = "Big",
    size = TextFieldSize.BIG,
    placeholderText = "Big field"
)
```

### Multi-line TextField

```kotlin
var description by remember { mutableStateOf("") }

TextField(
    text = description,
    onValueChanged = { description = it },
    label = "Description",
    placeholderText = "Enter detailed description...",
    singleLine = false
)
```

### Search TextField

```kotlin
var searchQuery by remember { mutableStateOf("") }

TextField(
    text = searchQuery,
    onValueChanged = { searchQuery = it },
    label = "Search",
    type = TextFieldType.SEARCH,
    placeholderText = "Search for items..."
)
```

### Number Input

```kotlin
var phoneNumber by remember { mutableStateOf("") }

TextField(
    text = phoneNumber,
    onValueChanged = { phoneNumber = it },
    label = "Phone Number",
    type = TextFieldType.NUMBER,
    placeholderText = "+1 (555) 123-4567"
)
```

### TextField States

```kotlin
// Enabled field
TextField(
    text = "Enabled text field",
    onValueChanged = { },
    label = "Enabled",
    enabled = true
)

// Disabled field
TextField(
    text = "Disabled text field",
    onValueChanged = { },
    label = "Disabled",
    enabled = false
)
```

### TextField with Capitalization

```kotlin
TextField(
    text = "",
    onValueChanged = { },
    label = "Name",
    capitalization = KeyboardCapitalization.Words,
    placeholderText = "First Last"
)

TextField(
    text = "",
    onValueChanged = { },
    label = "Sentence",
    capitalization = KeyboardCapitalization.Sentences,
    placeholderText = "Start with capital letter"
)
```

### TextField with IME Actions

```kotlin
TextField(
    text = firstName,
    onValueChanged = { firstName = it },
    label = "First Name",
    imeAction = ImeAction.Next,
    onValueChanged = { firstName = it }
)

TextField(
    text = lastName,
    onValueChanged = { lastName = it },
    label = "Last Name",
    imeAction = ImeAction.Done,
    onValueChanged = { lastName = it }
)
```

### Form Example

```kotlin
Column(
    verticalArrangement = Arrangement.spacedBy(16.dp)
) {
    TextField(
        text = name,
        onValueChanged = { name = it },
        label = "Full Name",
        placeholderText = "Enter your name"
    )
    
    TextField(
        text = email,
        onValueChanged = { email = it },
        label = "Email",
        type = TextFieldType.EMAIL,
        placeholderText = "your@email.com"
    )
    
    TextField(
        text = message,
        onValueChanged = { message = it },
        label = "Message",
        placeholderText = "Enter your message...",
        singleLine = false
    )
}
```