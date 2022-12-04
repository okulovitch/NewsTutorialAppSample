package com.akul.news_data.repository

import com.akul.news_data.local.NewsDao
import com.akul.news_data.remote.OpenNewsApi
import com.akul.news_domain.model.TrackableNews
import com.akul.news_domain.model.TrackedNews
import com.akul.news_domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

class NewsRepositoryImpl(
    private val dao: NewsDao,
    private val api: OpenNewsApi
) : NewsRepository {

    override suspend fun searchNews(
        query: String,
        from: String,
        sortBy: String
    ): Result<List<TrackableNews>> {
        TODO("Not yet implemented")
    }

    override suspend fun searchNews(
        query: String,
        page: Int,
        pageSize: Int
    ): Result<List<TrackableNews>> {
        TODO("Not yet implemented")
    }

    override suspend fun insertTrackedNews(news: TrackedNews) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteTrackedNews(news: TrackedNews) {
        TODO("Not yet implemented")
    }

    override fun getNewsForDate(localDate: LocalDate): Flow<List<TrackedNews>> {
        TODO("Not yet implemented")
    }
}