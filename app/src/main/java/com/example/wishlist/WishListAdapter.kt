package com.example.wishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import java.net.URL

 class WishListAdapter(private val itemList: List<WishList>) : RecyclerView.Adapter<WishListAdapter.ViewHolder>() {

     inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
         val name = itemView.findViewById<TextView>(R.id.textView2)
         val linkurl = itemView.findViewById<TextView>(R.id.textView)
         val price = itemView.findViewById<TextView>(R.id.editTextNumberDecimal)

     }

     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WishListAdapter.ViewHolder {

         val context = parent.context
         val inflater = LayoutInflater.from(context)
         val listview = inflater.inflate(R.layout.wish_list, parent, false)
         return ViewHolder(listview)
     }

     override fun onBindViewHolder(holder: WishListAdapter.ViewHolder, position: Int) {

         val wlist : WishList = itemList[position]
         holder.name.text = wlist.name
         holder.linkurl.text = wlist.link
         holder.linkurl.autoLinkMask = android.text.util.Linkify.WEB_URLS
         holder.price.text = wlist.price.toString()
     }

     override fun getItemCount(): Int {

         return itemList.size
     }

 }