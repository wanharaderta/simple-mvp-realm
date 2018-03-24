package com.kat.simple_mvp.Dagger

import android.content.Context
import com.kat.simple_mvp.SimpleApp
import com.kat.simple_mvp.db.SimpleSharedPref
import com.kat.simple_mvp.utils.AuthUtils
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 *
 * Created by Wanhar Aderta Daeng Maro on 3/23/2018.
 * Email : wanhardaengmaro@gmail.com
 *
 */

@Module
class AndroidModule{

    @Provides
    @Singleton
    fun providesContext(): Context {
        return SimpleApp.instance
    }

    @Provides
    @Singleton
    fun providesSimpleSharedPref(context: Context): SimpleSharedPref {
        return SimpleSharedPref(context)
    }

    @Provides
    @Singleton
    fun providesAuthUtils(sharedPref: SimpleSharedPref): AuthUtils {
        return AuthUtils(sharedPref)
    }
}