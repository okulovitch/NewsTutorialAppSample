package com.akul.news_domain.model

import java.time.LocalDate

data class TrackableNews(
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: LocalDate,
    val title: String,
    val urlToImage: String
)