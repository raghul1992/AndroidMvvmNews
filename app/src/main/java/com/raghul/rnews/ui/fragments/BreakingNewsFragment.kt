package com.raghul.rnews.ui.fragments

import android.opengl.Visibility
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.raghul.rnews.R
import com.raghul.rnews.adapters.NewsAdapter
import com.raghul.rnews.ui.NewsActivity
import com.raghul.rnews.ui.NewsViewModel
import com.raghul.rnews.utils.Resource
import kotlinx.android.synthetic.main.fragment_breaking_news.*
import com.bumptech.glide.load.engine.Resource as Resource1

class BreakingNewsFragment : Fragment(R.layout.fragment_breaking_news) {

    lateinit var viewModel: NewsViewModel
    lateinit var newsAdapter: NewsAdapter
     val TAG = "BREAKING_NEWS_FRAGMENT"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = (activity as NewsActivity).viewModel
        setupRecyclerView()
        viewModel.breakingNews.observe(viewLifecycleOwner, Observer {
            response ->
            when(response){
                is Resource.Success -> {
                    hideProgressBar()
                    response.data?.let {
                        newsResponse ->  newsAdapter.differ.submitList(newsResponse.articles)
                    }
                }

                is Resource.Error -> {
                    hideProgressBar()
                    response.message?.let {
                        message -> Log.e(TAG,"an error occured $message")
                    }
                }

                is Resource.Loading -> showProgressBar()


            }
        })
    }

    private fun hideProgressBar() {
        paginationProgressBar.visibility = View.INVISIBLE
    }

    private fun showProgressBar() {
        paginationProgressBar.visibility = View.VISIBLE
    }
    private fun setupRecyclerView(){

        newsAdapter = NewsAdapter()
        rvBreakingNews.apply {
            adapter=newsAdapter
            layoutManager = LinearLayoutManager(activity)

        }
    }

}