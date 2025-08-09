package com.example.foodordering.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodordering.adapter.MenuAdapter.*
import com.example.foodordering.databinding.MenuItemBinding

class MenuAdapter(private val menuItems: MutableList<String>, private  val menuImage : MutableList<Int>, private val menuCost : MutableList<String>): RecyclerView.Adapter<MenuViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val binding = MenuItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MenuViewHolder(binding)
    }

    fun updateData(newData: List<String>, newImage: List<Int>, newCost: List<String>) {
        menuItems.clear()
        menuItems.addAll(newData)
        menuImage.clear()
        menuImage.addAll(newImage)
        menuCost.clear()
        menuCost.addAll(newCost)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
    holder.bind(position)
    }
    override fun getItemCount(): Int = menuItems.size

    inner class MenuViewHolder(private val binding: MenuItemBinding) : RecyclerView.ViewHolder(binding.root){
    fun bind(position: Int){
        binding.apply {
        textViewName.text = menuItems[position]
        imageViewMenu.setImageResource(menuImage[position])
        textViewCost.text = menuCost[position]
        }
    }

    }
}