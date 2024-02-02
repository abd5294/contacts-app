package com.abdur.dictionary.util

import com.abdur.dictionary.data.remote.Word

data class WordState(
    val wordList : List<Word> = emptyList()
)