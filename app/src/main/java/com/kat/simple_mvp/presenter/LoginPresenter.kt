package com.kat.simple_mvp.presenter

import com.kat.simple_mvp.activity.LoginActivity
import com.kat.simple_mvp.model.User
import com.kat.simple_mvp.utils.AuthUtils
import io.realm.Realm
import io.realm.RealmConfiguration




/**
 *
 * Created by Wanhar Aderta Daeng Maro on 3/23/2018.
 * Email : wanhardaengmaro@gmail.com
 *
 */
class LoginPresenter(var view: LoginActivity, var authutils: AuthUtils) {


    fun loginUser(mEmail:String, mPass:String){

        var config = RealmConfiguration.Builder().name("user.realm").build()
        var realm   = Realm.getInstance(config)


        val user = realm.where(User::class.java).findAll()
        for (user: User in user){

            if (mEmail.equals(user.email) && mPass.equals(user.password)){
                authutils.saveAccessToken(user.id.toString())
                view.intent()
            }
        }

    }

}