package com.example.composetoy.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composetoy.domain.ContentListRepository
import com.example.composetoy.domain.model.Section
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

data class MainUiState(
    val rawString: String,
)

sealed class MainSideEffect

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: ContentListRepository
): ViewModel(), ContainerHost<MainUiState, MainSideEffect> {

    override val container = container<MainUiState, MainSideEffect>(MainUiState(""))

    init {
        viewModelScope.launch {
            val sectionList = repository.getList()
            initializeUI(sectionList)
        }
    }

    private fun initializeUI(sectionList: List<Section>) = intent {
        reduce {
            state.copy(rawString = sectionList.toString())
        }
    }
}