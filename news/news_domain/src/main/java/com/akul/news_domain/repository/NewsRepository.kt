package com.akul.news_domain.repository

import com.akul.news_domain.model.TrackableNews
import com.akul.news_domain.model.TrackedNews
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

interface NewsRepository {

    suspend fun searchNews(
        query: String,
        from: String,
        sortBy: String
    ): Result<List<TrackableNews>>

    suspend fun searchNews(
        query: String,
        page: Int,//todo maybe shift in data layer for pagination
        pageSize: Int,
    ): Result<List<TrackableNews>>

    suspend fun insertTrackedNews(news: TrackedNews)

    suspend fun deleteTrackedNews(news: TrackedNews)

    fun getNewsForDate(localDate: LocalDate): Flow<List<TrackedNews>>
}