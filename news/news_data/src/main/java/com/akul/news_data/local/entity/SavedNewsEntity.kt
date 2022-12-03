package com.akul.news_data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SavedNewsEntity(
    val author: String,
    val content: String,
    val description: String,
    val dayOfMonth: Int,
    val month: Int,
    val year: Int,
    //val source: Source,//todo add table
    val title: String,
    val url: String?,
    val urlToImage: String?,
    @PrimaryKey val id :Int? = null
)