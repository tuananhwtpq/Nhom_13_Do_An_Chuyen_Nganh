package com.example.foodordering.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodordering.adapter.MenuAdapter.*
import com.example.foodordering.databinding.MenuItemBinding

class MenuAdapter(private val menuItems: MutableList<String>, private  val menuImage : MutableList<Int>, private val menuCost : MutableList<String>): RecyclerView.Adapter<MenuViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        TODO("Not yet implemented")
    }



    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
    override fun getItemCount(): Int = menuItems.size

    inner class MenuViewHolder(private val binding: MenuItemBinding) : RecyclerView.ViewHolder(binding.root){


    }
}