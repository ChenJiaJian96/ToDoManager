package com.jiajianchen.todomanager.data.room

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MatterDao {

    @Query("SELECT * FROM matter")
    fun getAllMatters(): DataSource.Factory<Int, Matter>

    @Query("SELECT * FROM matter WHERE matter_type = 1")
    fun getImportantUrgentMatters(): DataSource.Factory<Int, Matter>

    @Query("SELECT * FROM matter WHERE matter_type = 2")
    fun getImportantNotUrgentMatters(): DataSource.Factory<Int, Matter>

    @Query("SELECT * FROM matter WHERE matter_type = 3")
    fun getNotImportantUrgentMatters(): DataSource.Factory<Int, Matter>

    @Query("SELECT * FROM matter WHERE matter_type = 4")
    fun getNotImportantNotUrgentMatters(): DataSource.Factory<Int, Matter>

    @Query("SELECT * FROM matter WHERE isSolved = 1")
    fun getResolvedMatters(): DataSource.Factory<Int, Matter>

    @Query("SELECT * FROM matter WHERE isSolved = 0")
    fun getUnResolvedMatters(): DataSource.Factory<Int, Matter>

    @Insert
    fun insertMatter(matter: Matter)

    @Delete
    fun deleteMatter(matter: Matter)
}