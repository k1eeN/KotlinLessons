package lesson_91_screen_state_as_flow

sealed interface ScreenState {

    data object Initial : ScreenState
    data object Loading : ScreenState
    data object NotFound : ScreenState
    data class DefinitionsLoaded(val definition: List<String>) : ScreenState
}