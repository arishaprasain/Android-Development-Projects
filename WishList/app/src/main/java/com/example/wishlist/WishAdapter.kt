package com.example.wishlist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WishAdapter(val c : Context, val wishList : ArrayList<Wish>) : RecyclerView.Adapter<WishAdapter.ViewHolder>()
{
    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)
    {
        val wishEditText : TextView
        val priceEditText : TextView
        val sourceEditText : TextView

        init
        {
            wishEditText = itemView.findViewById(R.id.wish)
            priceEditText = itemView.findViewById(R.id.price)
            sourceEditText = itemView.findViewById(R.id.source)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.wish_item, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val  wish = wishList[position]
        holder.wishEditText.text = wish.wishItem
        holder.priceEditText.text = wish.price
        holder.sourceEditText.text = wish.source



    }


    override fun getItemCount(): Int {

        return wishList.size
    }


}