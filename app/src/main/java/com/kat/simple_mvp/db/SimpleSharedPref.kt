package com.kat.simple_mvp.db

import android.content.Context
import android.content.SharedPreferences

/**
 *
 * Created by Wanhar Aderta Daeng Maro on 3/23/2018.
 * Email : wanhardaengmaro@gmail.com
 *
 */
class SimpleSharedPref(context: Context){

    companion object {
        private val SHARED_PREF_AUTH    = "simple-auth"
    }

    private var authSharedPref: SharedPreferences? = null

    init {
        this.authSharedPref = context.getSharedPreferences(SHARED_PREF_AUTH, Context.MODE_PRIVATE)
    }

    private val KEY_ACCESS_TOKEN          = "access-token"

    fun saveAccessToken(accessToken: String) {
        authSharedPref!!.edit().putString(KEY_ACCESS_TOKEN, accessToken).apply()
    }
    val getAccessToken: String?
        get() = authSharedPref!!.getString(KEY_ACCESS_TOKEN, "")

    fun clear() {
        authSharedPref!!.edit().clear().apply()
    }
}