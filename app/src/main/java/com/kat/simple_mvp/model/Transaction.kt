package com.kat.simple_mvp.model

import io.realm.RealmObject
import io.realm.annotations.Index
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass

/**
 *
 * Created by Wanhar Aderta Daeng Maro on 3/23/2018.
 * Email : wanhardaengmaro@gmail.com
 *
 */

@RealmClass
open class Transaction: RealmObject(){



    @PrimaryKey
    var id : Int? = null
    var user: User? = null
    @Index
    var userId: Int? = null
    var product: String? = null
    var price: Int? = null
}