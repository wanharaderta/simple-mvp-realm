package com.kat.simple_mvp.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.kat.simple_mvp.R
import com.kat.simple_mvp.SimpleApp
import com.kat.simple_mvp.presenter.RegisterPresenter
import com.kat.simple_mvp.utils.AuthUtils
import kotlinx.android.synthetic.main.activity_register.*
import javax.inject.Inject

class RegisterActivity : AppCompatActivity() {

    @Inject
    lateinit var authutils : AuthUtils

    var presenter: RegisterPresenter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SimpleApp.component.inject(this)
        presenter = RegisterPresenter(this,authutils)
        setContentView(R.layout.activity_register)


        btnRegister.setOnClickListener {

            presenter!!.insertUser(name.text.toString(),email.text.toString(),pass.text.toString())

        }

        login.setOnClickListener {

            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)

        }
    }
}
