package com.example.todoapp_atheer_alharabi

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.adapter.*
import kotlinx.android.synthetic.main.adapter.view.*

class Adapter(val context: Context, val input:ArrayList<item>) : RecyclerView.Adapter<Adapter.itemViewHolder>() {

    class itemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


    override fun onBindViewHolder(holder: itemViewHolder, position: Int) {
        //take ont data and add it to textview up
        val message = input[position]

        holder.itemView.apply {

            tv1.setTextColor(Color.BLACK)

            tv1.text = message.item
            CB.setOnClickListener {

                if (CB.isChecked) {
                    message.checked = true

                    tv1.setTextColor(Color.GRAY)

                } else {
                    message.checked = false
                    tv1.setTextColor(Color.BLACK)

                }

            }


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): itemViewHolder {
        return itemViewHolder(

            LayoutInflater.from(context).inflate(
                R.layout.adapter,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = input.size

}
