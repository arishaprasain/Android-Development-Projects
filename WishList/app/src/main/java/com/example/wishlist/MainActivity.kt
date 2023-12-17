package com.example.wishlist

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var addsBtn : Button
    private lateinit var recv : RecyclerView
    private lateinit var wishList : ArrayList<Wish>
    private lateinit var wishAdapter: WishAdapter
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //set list
        wishList = ArrayList()

        //set find id
        addsBtn = findViewById(R.id.addButton)
        recv = findViewById(R.id.wishRv)

        //layout manager for recycler view
        recv.layoutManager = LinearLayoutManager(this)

        // set adapter
        wishAdapter = WishAdapter(this, wishList)
        recv.adapter = wishAdapter

        //set dialog
        addsBtn.setOnClickListener()
        {
            //call function for adding info
            addinfo()
        }
    }
        private fun addinfo() {
            val inflter = LayoutInflater.from(this)
            val v = inflter.inflate(R.layout.wish_item, null)

            //set views
            val wishItem = v.findViewById<EditText>(R.id.wish)
            val price = v.findViewById<EditText>(R.id.price)
            val source = v.findViewById<EditText>(R.id.source)

            val addDialog = AlertDialog.Builder(this)


            addDialog.setView(v)
            addDialog.setPositiveButton("Ok") { dialog, _ ->
                val item = wishItem.text.toString()
                val cost = price.text.toString()
                val find = source.text.toString()


                wishList.add(Wish("Wish : $item", "Price: $cost", "Source: $find"))
                wishAdapter.notifyDataSetChanged()
                Toast.makeText(this, "Adding to the list success", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            addDialog.setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss()
                Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show()

            }
            addDialog.create()
            addDialog.show()


        }
    }





