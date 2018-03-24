package com.kat.simple_mvp.Dagger

import com.kat.simple_mvp.SimpleApp
import com.kat.simple_mvp.activity.LoginActivity
import com.kat.simple_mvp.activity.MainActivity
import com.kat.simple_mvp.activity.RegisterActivity
import dagger.Component
import javax.inject.Singleton

/**
 *
 * Created by Wanhar Aderta Daeng Maro on 3/23/2018.
 * Email : wanhardaengmaro@gmail.com
 *
 */

@Singleton
@Component(modules = arrayOf(AndroidModule::class))
interface SimpleComponent{

    fun inject(simpleApp: SimpleApp) {}

    fun inject(mainActivity: MainActivity) {}
    fun inject(loginActivity: LoginActivity)
    fun inject(registerActivity: RegisterActivity)


}