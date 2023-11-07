package com.iesam.utnavigation.features.list.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.iesam.utnavigation.features.list.domain.Subject

class SubjectListViewModel : ViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> get() = _uiState

    fun loadSubjects() {
        _uiState.value = UiState(SubjectMock.getMocks())
    }

    data class UiState(val subjects: List<Subject> = emptyList())

}