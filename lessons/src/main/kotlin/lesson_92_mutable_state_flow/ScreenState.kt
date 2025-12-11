package lesson_92_mutable_state_flow

sealed interface ScreenState {

    data object Initial : ScreenState
    data object Loading : ScreenState
    data object NotFound : ScreenState
    data class DefinitionsLoaded(val definition: List<String>) : ScreenState
}