package com.abdur.dictionary.data

import com.abdur.dictionary.data.remote.Word
import retrofit2.http.GET
import retrofit2.http.Path

interface WordApi {
    @GET("{word}")
    suspend fun getWord(
        @Path("word") query : String
    ) : List<Word>

    companion object{
        const val BASE_URL = "https://api.dictionaryapi.dev/api/v2/entries/en/"
    }
}