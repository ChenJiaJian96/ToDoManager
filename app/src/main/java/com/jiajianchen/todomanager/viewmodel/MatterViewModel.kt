package com.jiajianchen.todomanager.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.paging.Config
import androidx.paging.toLiveData
import com.jiajianchen.todomanager.data.room.AppDatabase
import com.jiajianchen.todomanager.data.room.Matter
import com.jiajianchen.todomanager.ioThread

class MatterViewModel(app: Application) : AndroidViewModel(app) {

    private val dao = AppDatabase.get(app).matterDao()

    val allMatters =
        dao.getAllMatters().toLiveData(Config(pageSize = 20, enablePlaceholders = true))

    val importantUrgentMatters =
        dao.getImportantUrgentMatters().toLiveData(Config(pageSize = 20, enablePlaceholders = true))

    val importantNotUrgentMatters =
        dao.getImportantNotUrgentMatters()
            .toLiveData(Config(pageSize = 20, enablePlaceholders = true))

    val notImportantUrgentMatters =
        dao.getNotImportantUrgentMatters()
            .toLiveData(Config(pageSize = 20, enablePlaceholders = true))

    val notImportantNotUrgentMatters =
        dao.getNotImportantNotUrgentMatters()
            .toLiveData(Config(pageSize = 20, enablePlaceholders = true))

    val resolvedList =
        dao.getResolvedMatters().toLiveData(Config(pageSize = 20, enablePlaceholders = true))

    val unResolvedList =
        dao.getUnResolvedMatters().toLiveData(Config(pageSize = 20, enablePlaceholders = true))

    fun insert(matter: Matter) = ioThread {
        dao.insertMatter(matter)
    }

    fun remove(matter: Matter) = ioThread {
        dao.deleteMatter(matter)
    }
}