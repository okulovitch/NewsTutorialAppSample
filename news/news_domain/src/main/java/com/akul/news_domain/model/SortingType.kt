package com.akul.news_domain.model

sealed class SortingType(val sortType: String) {
    object Popularity : SortingType("popularity")
    object Relevancy : SortingType("relevancy")
    object PublishedAt : SortingType("publishedAt")


    companion object {
        fun fromString(name: String): SortingType {
            return when (name) {
                "popularity" -> Popularity
                "relevancy" -> Relevancy
                "publishedAt" -> PublishedAt
                else -> Popularity
            }
        }
    }
}