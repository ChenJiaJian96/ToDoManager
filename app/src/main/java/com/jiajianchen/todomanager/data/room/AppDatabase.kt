package com.jiajianchen.todomanager.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.jiajianchen.todomanager.data.Constants
import com.jiajianchen.todomanager.ioThread

/**
 * Singleton database object. Note that for a real app, you should probably use a Dependency
 * Injection framework or Service Locator to create the singleton database.
 */
@Database(entities = arrayOf(Matter::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun matterDao(): MatterDao

    companion object {
        private var instance: AppDatabase? = null
        @Synchronized
        fun get(context: Context): AppDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java, "MatterDatabase"
                )
                    .addCallback(object : RoomDatabase.Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            // database init operation
                            fillInDb(context.applicationContext)
                        }
                    }).build()
            }
            return instance!!
        }

        /**
         * fill database with list of cheeses
         */
        private fun fillInDb(context: Context) {
            // inserts in Room are executed on the current thread, so we insert in the background
            ioThread {
                MATTER_DATA.forEach {
                    get(context).matterDao().insertMatter(it)
                }
            }
        }
    }
}

private val MATTER_DATA = arrayOf(
    Matter(
        mid = 0,
        title = "重要紧急的事情",
        description = "非常重要且马上要去做的！",
        createTs = 0L,
        endTs = 0L,
        isSolved = false,
        type = Constants.MatterType.ImportantUrgent
    ),
    Matter(
        mid = 0,
        title = "重要不紧急的事情",
        description = "非常重要但不需要马上去做的。",
        createTs = 0L,
        endTs = 0L,
        isSolved = false,
        type = Constants.MatterType.ImportantNotUrgent
    ),
    Matter(
        mid = 0,
        title = "紧急不重要的事情",
        description = "马上要去做但不重要的。",
        createTs = 0L,
        endTs = 0L,
        isSolved = false,
        type = Constants.MatterType.NotImportantUrgent
    ),
    Matter(
        mid = 0,
        title = "不重要不紧急的事情",
        description = "不重要也不需要马上去做的",
        createTs = 0L,
        endTs = 0L,
        isSolved = false,
        type = Constants.MatterType.NotImportantNotUrgent
    )
)