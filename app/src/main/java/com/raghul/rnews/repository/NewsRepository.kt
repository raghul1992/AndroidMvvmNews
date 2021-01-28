package com.raghul.rnews.repository

import com.raghul.rnews.api.RetrofitInstance
import com.raghul.rnews.db.ArticleDatbase

class NewsRepository(val db : ArticleDatbase) {

    suspend fun  getBreakingNews(countryCode : String, pageNumber : Int) =
            RetrofitInstance.api.getBreakingNews(countryCode,pageNumber)

    suspend fun getSearchNews(searchQuery : String, pageNumber: Int)=
            RetrofitInstance.api.searchForNews(searchQuery,pageNumber)

}