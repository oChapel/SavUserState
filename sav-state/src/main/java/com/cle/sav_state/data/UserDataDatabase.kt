package com.cle.sav_state.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [UserData::class], version = 1, exportSchema = false)
abstract class UserDataDatabase : RoomDatabase() {
    abstract fun userDataDao(): UserDataRoomDao?
}