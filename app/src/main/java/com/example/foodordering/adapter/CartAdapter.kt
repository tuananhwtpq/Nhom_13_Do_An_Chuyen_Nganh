package com.example.foodordering.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodordering.adapter.CartAdapter.*
import com.example.foodordering.databinding.CartItemBinding

class CartAdapter(private val cartItems : MutableList<String>, private val cartItemCost : MutableList<String>, private val cartImage : MutableList<Int>) : RecyclerView.Adapter<CartViewHolder>() {

private val itemQuantity = IntArray(cartItems.size) { 1 }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding = CartItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CartViewHolder(binding)
    }



    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bind(position)
    }
    override fun getItemCount(): Int = cartItems.size

    inner class CartViewHolder(private val binding: CartItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int){
            binding.apply {
                textNameInCart.text = cartItems[position]
                textCostInCart.text = cartItemCost[position]
                imgCart.setImageResource(cartImage[position])
                textQuantityInCart.text = itemQuantity[position].toString()
            }
        }
    }
}