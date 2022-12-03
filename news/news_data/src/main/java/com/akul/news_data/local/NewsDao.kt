package com.akul.news_data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.akul.news_data.local.entity.SavedNewsEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSavedNews(savedNewsEntity: SavedNewsEntity)

    @Delete
    suspend fun deleteSavedNews(savedNewsEntity: SavedNewsEntity)

    @Query(
        """
            SELECT * FROM savednewsentity
            WHERE dayOfMonth = :day AND month = :month AND year = :year
        """
    )
    fun getNewsForDate(day: Int, month:Int, year: Int): Flow<List<SavedNewsEntity>>
}