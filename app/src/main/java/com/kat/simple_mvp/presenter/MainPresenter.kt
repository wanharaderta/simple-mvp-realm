package com.kat.simple_mvp.presenter

import com.kat.simple_mvp.activity.MainActivity
import com.kat.simple_mvp.model.Transaction
import io.realm.Realm
import io.realm.RealmConfiguration






/**
 *
 * Created by Wanhar Aderta Daeng Maro on 3/23/2018.
 * Email : wanhardaengmaro@gmail.com
 *
 */
class MainPresenter(var view: MainActivity) {

    var config = RealmConfiguration.Builder().name("transaction.realm").build()
    var realm   = Realm.getInstance(config)

    fun insertTransaction(userId:Int){


        realm.beginTransaction()

        var transaction    = realm.createObject(Transaction::class.java,getNextId())

        transaction.product   = "Samsung"
        transaction.price     = 500000
        transaction.userId    = userId

        realm.commitTransaction()

        val allTrans  = realm.where(Transaction::class.java).equalTo("userId",userId).findAll()

            allTrans.forEach{
                transaction: Transaction? ->  println("trans : ${transaction!!.product}: ${transaction!!.userId}")
            }

    }



    fun getTrans(userid: Int){

        val list = ArrayList( realm.where(Transaction::class.java).equalTo("userId",userid).findAll())

        view.setList(list)
    }


    fun getNextId(): Int? {


        var nextId: Int? = 1

        val maxUserId = realm.where(Transaction::class.java).max("id")

        if (maxUserId != null) {
            nextId = maxUserId!!.toInt() + 1
        }
        return nextId
    }


}