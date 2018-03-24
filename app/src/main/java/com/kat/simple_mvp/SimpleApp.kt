package com.kat.simple_mvp

import android.app.Application
import com.kat.simple_mvp.Dagger.DaggerSimpleComponent
import com.kat.simple_mvp.Dagger.SimpleComponent
import io.realm.Realm

/**
 *
 * Created by Wanhar Aderta Daeng Maro on 3/23/2018.
 * Email : wanhardaengmaro@gmail.com
 *
 */
class SimpleApp : Application() {

    companion object {
        lateinit var instance: SimpleApp
        lateinit var component: SimpleComponent
    }

    override fun onCreate() {
        super.onCreate()

        instance = this
        component = setUpComponent()
        component.inject(this)
        Realm.init(this)
    }

    protected fun setUpComponent(): SimpleComponent {
        return DaggerSimpleComponent.builder().build()
    }

}