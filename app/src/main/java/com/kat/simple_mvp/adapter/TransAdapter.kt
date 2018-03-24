package com.kat.simple_mvp.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.kat.simple_mvp.R
import com.kat.simple_mvp.model.Transaction

/**
 *
 * Created by Wanhar Aderta Daeng Maro on 2/11/2018.
 * Email : wanhardaengmaro@gmail.com
 *
 */

open class TransAdapter(var context: Context, val trans: List<Transaction>) : RecyclerView.Adapter<TransAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): TransAdapter.ViewHolder{
        val v = LayoutInflater.from(parent!!.context).inflate(R.layout.item_list, parent, false)
        return ViewHolder(v)

    }

    override fun onBindViewHolder(holder: TransAdapter.ViewHolder, position: Int) {
        holder.bindItems(trans!![position])
    }


    class ViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bindItems(transaction: Transaction){
            with(transaction){
                val product = itemView.findViewById<TextView>(R.id.product)
                val price = itemView.findViewById<TextView>(R.id.price)
                product.text = transaction.product
                price.text = "Rp. "+transaction.price.toString()

            }
        }

    }


    override fun getItemCount(): Int {
        return trans!!.size
    }



}

//
//open class TransAdapter(var context: Context, var data: OrderedRealmCollection<Transaction>, var autoUpdate: Boolean ) : RecyclerView.Adapter<TransAdapter.ViewHolder>() {
//
//    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): TransAdapter.ViewHolder{
//        val v = LayoutInflater.from(parent!!.context).inflate(R.layout.item_list, parent, false)
//        return ViewHolder(v)
//
//    }
//
//    override fun onBindViewHolder(holder: TransAdapter.ViewHolder, position: Int) {
//        holder.bindItems(data!![position])
//    }
//
//
//    class ViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {
//        fun bindItems(transaction: Transaction){
//            with(transaction){
//                val product = itemView.findViewById<TextView>(R.id.product)
//                val price = itemView.findViewById<TextView>(R.id.price)
//                product.text = product.text
//                price.text = price.text
//
//            }
//        }
//
//    }
//
//
//    override fun getItemCount(): Int {
//        return data!!.size
//    }
//
//
//
//}
