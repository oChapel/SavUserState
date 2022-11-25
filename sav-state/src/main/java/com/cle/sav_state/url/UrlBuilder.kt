package com.cle.sav_state.url

import android.content.Context
import androidx.core.net.toUri
import java.util.*

class UrlBuilder(
    appContext: Context,
    private val baseLink: String
) {

    private val res = appContext.resources

    fun createByIdMap(
        idMap: Map<String, Int>,
        gadId: String,
        source: String,
        deepLink: String,
        uId: String?,
        convData: Map<String, Any>?
    ): String {

        fun getStringFromMap(key: String): String {
            idMap[key]?.let { id ->
                return res.getString(id)
            } ?: throw RuntimeException("Key { $key } is not present in idMap")
        }

        return baseLink.toUri().buildUpon().apply {
            appendQueryParameter(
                getStringFromMap("secure_get_parametr"),
                getStringFromMap("secure_key")
            )
            appendQueryParameter(getStringFromMap("dev_tmz_key"), TimeZone.getDefault().id)
            appendQueryParameter(getStringFromMap("gadid_key"), gadId)
            appendQueryParameter(getStringFromMap("deeplink_key"), deepLink)
            appendQueryParameter(getStringFromMap("source_key"), source)
            appendQueryParameter(getStringFromMap("af_id_key"), uId.toString())
            appendQueryParameter(
                getStringFromMap("adset_id_key"),
                convData?.get("adset_id").toString()
            )
            appendQueryParameter(
                getStringFromMap("campaign_id_key"),
                convData?.get("campaign_id").toString()
            )
            appendQueryParameter(
                getStringFromMap("app_campaign_key"),
                convData?.get("campaign").toString()
            )
            appendQueryParameter(getStringFromMap("adset_key"), convData?.get("adset").toString())
            appendQueryParameter(
                getStringFromMap("adgroup_key"),
                convData?.get("adgroup").toString()
            )
            appendQueryParameter(
                getStringFromMap("orig_cost_key"),
                convData?.get("orig_cost").toString()
            )
            appendQueryParameter(
                getStringFromMap("af_siteid_key"),
                convData?.get("af_siteid").toString()
            )
        }.toString()
    }

    fun createByStringMap(
        stringMap: Map<String, String>,
        gadId: String,
        source: String,
        deepLink: String = "null",
        uId: String? = null,
        convData: Map<String, Any>? = null
    ): String = baseLink.toUri().buildUpon().apply {
        appendQueryParameter(stringMap["secure_get_parametr"], stringMap["secure_key"])
        appendQueryParameter(stringMap["dev_tmz_key"], TimeZone.getDefault().id)
        appendQueryParameter(stringMap["gadid_key"], gadId)
        appendQueryParameter(stringMap["deeplink_key"], deepLink)
        appendQueryParameter(stringMap["source_key"], source)
        appendQueryParameter(stringMap["af_id_key"], uId.toString())
        appendQueryParameter(stringMap["adset_id_key"], convData?.get("adset_id").toString())
        appendQueryParameter(stringMap["campaign_id_key"], convData?.get("campaign_id").toString())
        appendQueryParameter(stringMap["campaign_key"], convData?.get("campaign").toString())
        appendQueryParameter(stringMap["adset_key"], convData?.get("adset").toString())
        appendQueryParameter(stringMap["adgroup_key"], convData?.get("adgroup").toString())
        appendQueryParameter(stringMap["orig_cost_key"], convData?.get("orig_cost").toString())
        appendQueryParameter(stringMap["af_siteid_key"], convData?.get("af_siteid").toString())
    }.toString()
}
