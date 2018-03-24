package com.kat.simple_mvp.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.kat.simple_mvp.R
import com.kat.simple_mvp.SimpleApp
import com.kat.simple_mvp.presenter.LoginPresenter
import com.kat.simple_mvp.utils.AuthUtils
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

class LoginActivity : AppCompatActivity() {

    @Inject
    lateinit var authutils: AuthUtils

    var presenter: LoginPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SimpleApp.component.inject(this)
        presenter = LoginPresenter(this, authutils)
        setContentView(R.layout.activity_login)

        btnLogin.setOnClickListener {
            presenter!!.loginUser(email.text.toString(), pass.text.toString())

        }

        register.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    fun intent() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)

    }
}
