package com.abdur.dictionary.word_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abdur.dictionary.data.remote.Word
import com.abdur.dictionary.repository.WordRepository
import com.abdur.dictionary.util.WordState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WordScreenViewModel @Inject constructor(
    private val repository: WordRepository
) : ViewModel() {

    private var _query = mutableStateOf("")
    val query : State<String> = _query

    private var _state = mutableStateOf(WordState())
    var state : State<WordState> = _state

    private var searchJob : Job? = null

    fun onSearch(searchedWord : String){
        _query.value = searchedWord
        searchJob?.cancel()
        searchJob = viewModelScope.launch {
            val response = repository.getWord(searchedWord)
            _state.value = _state.value.copy(
                wordList = response
            )
        }
    }
}
