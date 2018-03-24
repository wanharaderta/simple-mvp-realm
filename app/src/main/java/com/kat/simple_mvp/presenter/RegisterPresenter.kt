package com.kat.simple_mvp.presenter

import android.util.Log
import android.widget.Toast
import com.kat.simple_mvp.activity.RegisterActivity
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
class RegisterPresenter(var view: RegisterActivity,var authutils: AuthUtils) {

    fun insertUser(name:String, email:String, pass:String){

        var config = RealmConfiguration.Builder().name("user.realm").build()
        var realm   = Realm.getInstance(config)
        var user:User

        realm.executeTransactionAsync({ realm ->

            user    = realm.createObject(User::class.java,getNextId())

            user.name   = name
            user.email   = email
            user.password   = pass

        }, {
            authutils.saveAccessToken(getNextId().toString())
            Log.e("id2",getNextId().toString())
            Toast.makeText(view.applicationContext,"Succes",Toast.LENGTH_LONG).show()
            realm.close()

        }, {
            Toast.makeText(view.applicationContext,"Try Again",Toast.LENGTH_LONG).show()
            realm.close()
        })


    }




    fun getNextId(): Int? {

        var config = RealmConfiguration.Builder().name("user.realm").build()
        var realm   = Realm.getInstance(config)

        var nextId: Int? = 1

        val maxUserId = realm.where(User::class.java).max("id")

        if (maxUserId != null) {
            nextId = maxUserId!!.toInt() + 1
        }
        return nextId
    }
}