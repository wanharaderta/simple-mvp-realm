package com.kat.simple_mvp.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import com.kat.simple_mvp.R
import com.kat.simple_mvp.SimpleApp
import com.kat.simple_mvp.adapter.TransAdapter
import com.kat.simple_mvp.model.Transaction
import com.kat.simple_mvp.presenter.MainPresenter
import com.kat.simple_mvp.utils.AuthUtils
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject






class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var authutils : AuthUtils

    var presenter: MainPresenter? = null

    var rAdapter : TransAdapter? = null
    var realm: Realm? = null

    //var trans: List<Transaction>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SimpleApp.component.inject(this)
        presenter = MainPresenter(this)

        setContentView(R.layout.activity_main)

        setUpRecyclerView()

        presenter!!.getTrans(authutils.getAccessToken().toInt())
    }

    fun setUpRecyclerView(){
        val linearLayoutManager = LinearLayoutManager(this)
        recycleview.setLayoutManager(linearLayoutManager)
        recycleview.setHasFixedSize(true)
    }

    fun setList(findAll: ArrayList<Transaction>) {

        rAdapter = TransAdapter(this, findAll)
        recycleview.setAdapter(rAdapter)


    }

    fun onRefresh(){

    }




    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {


        when(item!!.itemId){
            R.id.action_add ->{
                presenter!!.insertTransaction(authutils.getAccessToken().toInt())
                rAdapter!!.notifyDataSetChanged()
            }

        }

        return super.onOptionsItemSelected(item)


    }
}
