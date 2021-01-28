package com.raghul.rnews.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.raghul.rnews.R
import com.raghul.rnews.db.ArticleDatbase
import com.raghul.rnews.repository.NewsRepository
import kotlinx.android.synthetic.main.activity_news.*

class NewsActivity : AppCompatActivity() {

    lateinit var viewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        val newsRepository = NewsRepository(ArticleDatbase(this))
        val viewModelProveiderFactory = NewsViewModelProveiderFactory(newsRepository)
        viewModel = ViewModelProvider(this,viewModelProveiderFactory).get(NewsViewModel::class.java)

        bottomNavigationView.setupWithNavController(newsNavHostFragment.findNavController())


    }
}