package com.akul.news_data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.akul.news_data.local.entity.SavedNewsEntity

@Database(
    entities = [SavedNewsEntity::class],
    version = 1
)
abstract class NewsDatabase : RoomDatabase() {
    abstract val dao: NewsDao
}