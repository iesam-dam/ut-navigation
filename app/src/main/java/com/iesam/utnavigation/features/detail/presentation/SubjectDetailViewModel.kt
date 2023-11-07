package com.iesam.utnavigation.features.detail.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.iesam.utnavigation.features.list.domain.Subject
import com.iesam.utnavigation.features.list.presentation.SubjectMock

class SubjectDetailViewModel : ViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> get() = _uiState

    fun loadSubject(subjectId: String) {
        SubjectMock.getMocks().first { it.id == subjectId }.apply {
            _uiState.value = UiState(this)
        }
    }

    data class UiState(val subject: Subject)
}