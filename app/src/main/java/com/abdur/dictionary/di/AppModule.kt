package com.abdur.dictionary.di

import com.abdur.dictionary.data.WordApi
import com.abdur.dictionary.repository.WordRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    @Singleton
    fun provideWordApi() : WordApi {
        return Retrofit.Builder()
            .baseUrl(WordApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WordApi::class.java)
    }

    @Provides
    @Singleton
    fun provideWordRepository(api : WordApi) : WordRepository {
        return WordRepository(api)
    }
}