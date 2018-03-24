package com.kat.simple_mvp.utils

import com.kat.simple_mvp.db.SimpleSharedPref

/**
 *
 * Created by Wanhar Aderta Daeng Maro on 2/27/2018.
 * Email : wanhardaengmaro@gmail.com
 *
 */
class AuthUtils( var sharedPref: SimpleSharedPref) {

    private lateinit  var accessToken: String
    private lateinit  var email: String

    fun isLogin(): Boolean {
        accessToken = sharedPref.getAccessToken!!
        return accessToken != null
    }

    fun saveAccessToken(accessToken: String?) {
        sharedPref.saveAccessToken(accessToken!!)
    }
    fun getAccessToken(): String {
        return sharedPref.getAccessToken!!
    }


    fun clearSharedPref() {
        sharedPref.clear()
    }




}