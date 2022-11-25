package com.cle.sav_state.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_data")
data class UserData(
    @PrimaryKey
    val googleAdvertsId: String,
    val link: String = "",
    val isAdb: Boolean = false
)
