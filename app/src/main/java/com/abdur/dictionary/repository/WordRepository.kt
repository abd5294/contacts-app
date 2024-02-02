package com.abdur.dictionary.repository

import com.abdur.dictionary.data.WordApi
import com.abdur.dictionary.data.remote.Word
import javax.inject.Inject

class WordRepository @Inject constructor(private val api: WordApi) {
    suspend fun getWord(query: String): List<Word> {
        val result = try {
            api.getWord(query)
        } catch (e : Exception){
            emptyList()
        }
        return result
    }
}