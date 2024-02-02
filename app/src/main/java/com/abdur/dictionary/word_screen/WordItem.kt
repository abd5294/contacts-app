package com.abdur.dictionary.word_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.abdur.dictionary.data.remote.Word

@Composable

fun WordItem(
    word: Word,
    modifier: Modifier = Modifier,
) {

    val viewmodel: WordScreenViewModel = hiltViewModel()
    Surface(modifier = modifier.fillMaxWidth()) {
        Column(
            modifier = modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = modifier.height(8.dp))
            Text(text = word.word)
            Spacer(modifier = modifier.height(8.dp))
            Text(text = word.phonetic)
        }
    }
}