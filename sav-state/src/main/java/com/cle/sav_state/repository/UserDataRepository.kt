package com.cle.sav_state.repository

import com.cle.sav_state.data.UserData

interface UserDataRepository {
    suspend fun saveUserData(userData: UserData)
    suspend fun saveUserDataForcibly(userData: UserData)
    suspend fun getUserData(): UserData?

    fun generateUrlByIdMap(
        idMap: Map<String, Int>,
        gadId: String,
        source: String,
        deepLink: String = "null",
        uId: String? = null,
        convData: Map<String, Any>? = null
    ): String

    fun generateUrlByStringMap(
        stringMap: Map<String, String>,
        gadId: String,
        source: String,
        deepLink: String = "null",
        uId: String? = null,
        convData: Map<String, Any>? = null
    ): String
}