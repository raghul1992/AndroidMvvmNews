package com.raghul.rnews.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.raghul.rnews.repository.NewsRepository

class NewsViewModelProveiderFactory
(val newsRepository: NewsRepository)
    : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return  NewsViewModel(newsRepository) as T
    }
}