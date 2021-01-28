package com.raghul.rnews.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.raghul.rnews.R
import com.raghul.rnews.ui.NewsActivity
import com.raghul.rnews.ui.NewsViewModel

class ArticleFragment : Fragment(R.layout.fragment_article) {
    lateinit var viewModel: NewsViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = (activity as NewsActivity).viewModel
    }
}