package com.demo.kotlin.room.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.demo.kotlin.room.repository.WordRepository

class WordViewModelFactory(private val wordRepository: WordRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WordViewModel::class.java)) {
            return WordViewModel(wordRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}