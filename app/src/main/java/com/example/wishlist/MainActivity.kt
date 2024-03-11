package com.example.wishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var rview: RecyclerView
    lateinit var submitbttn: Button
    lateinit var price: EditText
    lateinit var linkurl: EditText
    lateinit var nameText: EditText
    lateinit var adapter: WishListAdapter

    val  itemList = ArrayList<WishList>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rview = findViewById(R.id.recyclerView)
        submitbttn = findViewById(R.id.button)
        price = findViewById(R.id.editTextNumberDecimal)
        linkurl = findViewById(R.id.editTextText2)
        nameText = findViewById(R.id.editTextText)
        rview.layoutManager = LinearLayoutManager(this)


         adapter = WishListAdapter(itemList)
        rview.adapter = adapter
        submitbttn.setOnClickListener{
            addItem(it)
        }
    }
    fun addItem(view: View) {
        val name = nameText.text.toString().trim()
        val prices = price.text.toString().trim().toDoubleOrNull()
        val link = linkurl.text.toString().trim()

        if (name.isNotEmpty() && prices != null && link.isNotEmpty()) {
            // Add item to the list
            val newItem = WishList(name, prices, link)
            itemList.add(newItem)

            // Clear the TextInputEditText fields
            nameText.text?.clear()
            price.text?.clear()
            linkurl.text?.clear()

            // Notify the adapter about the data change


            adapter.notifyDataSetChanged()
        }
        }
}