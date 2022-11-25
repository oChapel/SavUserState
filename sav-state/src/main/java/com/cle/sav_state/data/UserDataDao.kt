package com.cle.sav_state.data

import android.content.Context
import androidx.room.Room

class UserDataDao(appContext: Context) {

    private val userDataRoomDao: UserDataRoomDao? =
        Room.databaseBuilder(appContext, UserDataDatabase::class.java, "UserDataDB").build()
            .userDataDao()

    suspend fun saveData(userData: UserData) {
        userDataRoomDao?.saveData(userData)
    }

    suspend fun saveUserDataForcibly(userData: UserData) {
        userDataRoomDao?.saveUserDataForcibly(userData)
    }

    suspend fun getData(): UserData? = userDataRoomDao?.getData()
}