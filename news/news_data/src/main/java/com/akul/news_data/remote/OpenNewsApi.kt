package com.akul.news_data.remote

import com.akul.news_data.remote.dto.ArticleDto
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenNewsApi {

    @GET("/v2/everything")
    suspend fun searchEverything(
        @Query("q") query: String
    ): ArticleDto

    @GET("/v2/everything")
    suspend fun searchForArticle(
        @Query("q") query: String,
        @Query("from") date: String,
        @Query("sortBy") sortingType: String
    )

    companion object {
        const val BASE_URL = "https://newsapi.org/"
        private const val HEADER_API_KEY = "X-Api-Key"
    }
}

//fun NewsService(apiKey: String): OpenNewsApi {
//    val okHttpClient = OkHttpClient.Builder()
//        .addInterceptor { chain ->
//            val authorizedRequest = chain.request().newBuilder()
//                .addHeader(HEADER_API_KEY, apiKey)
//                .build()
//
//            chain.proceed(authorizedRequest)
//        }
//        .build()
//
//    val retrofit = Retrofit.Builder()
//        .baseUrl("https://newsapi.org/")
//        .client(okHttpClient)
//        .addConverterFactory(Json.asConverterFactory(MediaType.parse("application/json")!!))
//        .build()
//
//    return retrofit.create(OpenNewsApi::class.java)
//}
//
//private const val HEADER_API_KEY = "X-Api-Key"

