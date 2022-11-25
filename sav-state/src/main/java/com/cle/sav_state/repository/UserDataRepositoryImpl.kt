package com.cle.sav_state.repository

import android.content.Context
import com.cle.sav_state.data.UserData
import com.cle.sav_state.data.UserDataDao
import com.cle.sav_state.url.UrlBuilder

class UserDataRepositoryImpl(
    appContext: Context,
    baseLink: String
) : UserDataRepository {

    private val dao = UserDataDao(appContext)
    private val urlBuilder = UrlBuilder(appContext, baseLink)

    override suspend fun saveUserData(userData: UserData) {
        dao.saveData(userData)
    }

    override suspend fun saveUserDataForcibly(userData: UserData) {
        dao.saveUserDataForcibly(userData)
    }

    override suspend fun getUserData(): UserData? = dao.getData()

    override fun generateUrlByIdMap(
        idMap: Map<String, Int>,
        gadId: String,
        source: String,
        deepLink: String,
        uId: String?,
        convData: Map<String, Any>?
    ): String = urlBuilder.createByIdMap(
        idMap, gadId, source, deepLink, uId, convData
    )

    override fun generateUrlByStringMap(
        stringMap: Map<String, String>,
        gadId: String,
        source: String,
        deepLink: String,
        uId: String?,
        convData: Map<String, Any>?
    ): String = urlBuilder.createByStringMap(
        stringMap, gadId, source, deepLink, uId, convData
    )
}