package com.example.composetoy.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composetoy.domain.ContentListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: ContentListRepository
): ViewModel() {

    fun getList()  {
        viewModelScope.launch {
            Log.d("TTT", repository.getList().toString())
        }
    }
}