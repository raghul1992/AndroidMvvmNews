package com.raghul.rnews.api

import com.raghul.rnews.models.NewsResponse
import com.raghul.rnews.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPI {

    @GET("v2/top-headlines")
    suspend fun getBreakingNews(
            @Query("country")
            countryCode: String = "in",
            @Query("page")
            pageNumber: Int =1,
            @Query("apikey")
            apikey:String=Constants.API_KEY
    ):Response<NewsResponse>


    @GET("v2/top-headlines")
    suspend fun searchForNews(
            @Query("q")
            searchQuery: String ,
            @Query("page")
            pageNumber: Int =1,
            @Query("apikey")
            apikey:String=Constants.API_KEY
    ):Response<NewsResponse>


}