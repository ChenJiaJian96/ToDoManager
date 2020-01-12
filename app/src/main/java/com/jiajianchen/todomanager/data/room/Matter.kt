package com.jiajianchen.todomanager.data.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Matter(
    @PrimaryKey(autoGenerate = true) val mid: Int,
    @ColumnInfo val title: String?, // 事项的标题
    @ColumnInfo val description: String?, // 事项的描述
    @ColumnInfo val createTs: Long, // 事项的创建时间
    @ColumnInfo val endTs: Long, // 事项的结束时间
    @ColumnInfo val isSolved: Boolean, // 事项是否已经完成
    @ColumnInfo(name = "matter_type") val type: Int // 事项的类型
)