package com.abdur.dictionary.data.remote

data class Word(
    val meanings: List<Meaning>,
    val phonetic: String,
    val sourceUrls: List<String>,
    val word: String
)