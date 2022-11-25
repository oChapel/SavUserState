package com.cle.sav_state.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDataRoomDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun saveData(userData: UserData)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveUserDataForcibly(userData: UserData)

    @Query("SELECT * FROM user_data")
    suspend fun getData(): UserData?
}