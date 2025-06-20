# TodoListAppDemo

A simple Android Todo List app built with Kotlin, MVVM architecture, Retrofit, LiveData, and Material Design. This project demonstrates modern Android development best practices, including clean architecture, network operations, and responsive UI.

## Video Pengerjaan
[Link Video Pengerjaan](https://drive.google.com/file/d/16sAo9WdF60IiljcDgBPvn9vjCu6SD-_l/view?usp=sharing)

## Features
- View a list of todos
- Add new todos
- Mark todos as completed
- Delete todos
- Live updates with ViewModel and LiveData
- Material Design UI

## Screenshots
<!-- Add screenshots here -->

## Architecture
- **MVVM (Model-View-ViewModel)**: Separation of concerns for easier testing and maintainability
- **Repository Pattern**: Abstracts data operations
- **LiveData**: Observes data changes and updates UI automatically
- **Coroutines**: For asynchronous operations

## API
This app uses the [DummyJSON](https://dummyjson.com/) API for todos:
- `GET /todos` - Fetch all todos
- `POST /todos/add` - Add a new todo
- `PUT /todos/{id}` - Update a todo (mark as completed)
- `DELETE /todos/{id}` - Delete a todo

**Base URL:** `https://dummyjson.com/`

## Getting Started

### Prerequisites
- Android Studio Hedgehog or newer
- Android SDK 24+
- Gradle 8.7+
- Internet connection (for API access)

### Setup
1. **Clone the repository:**
   ```bash
   git clone <your-repo-url>
   cd TodoListAppDemo
   ```
2. **Open in Android Studio**
3. **Build the project** (Gradle sync will download dependencies)
4. **Run on an emulator or device**

## Dependencies
- [Kotlin](https://kotlinlang.org/) 1.9.0
- [AndroidX Core KTX](https://developer.android.com/kotlin/ktx)
- [Material Components](https://material.io/develop/android)
- [Retrofit 2](https://square.github.io/retrofit/)
- [OkHttp Logging Interceptor](https://square.github.io/okhttp/)
- [Gson Converter](https://github.com/square/retrofit/tree/master/retrofit-converters/gson)
- [Coroutines](https://github.com/Kotlin/kotlinx.coroutines)
- [Lifecycle ViewModel & LiveData](https://developer.android.com/topic/libraries/architecture/viewmodel)
- [RecyclerView](https://developer.android.com/jetpack/androidx/releases/recyclerview)

## Project Structure
```
app/
  src/main/
    java/com/nahsbyte/todolistappdemo/
      MainActivity.kt         // Main UI logic
      TodoViewModel.kt       // ViewModel for todos
      TodoRepository.kt      // Repository for API calls
      ApiServices.kt         // Retrofit API interface
      RetrofitInstance.kt    // Retrofit setup
      Todo.kt                // Data model
      AddTodoRequest.kt      // Add request body
      UpdateTodoRequest.kt   // Update request body
      TodoListResponse.kt    // API response model
      TodoAdapter.kt         // RecyclerView adapter
      TodoDiffCallback.kt    // DiffUtil for RecyclerView
    res/
      layout/
        activity_main.xml    // Main screen layout
        item_todo.xml        // Todo item layout
      values/
        strings.xml, colors.xml, themes.xml
```

## Theming
- Uses Material3 DayNight theme for light/dark mode support
- Custom colors can be set in `colors.xml`

## Testing
- Unit tests: `app/src/test/java/...`
- Instrumented tests: `app/src/androidTest/java/...`

## License
This project is for educational/demo purposes. Add your license here if needed. 