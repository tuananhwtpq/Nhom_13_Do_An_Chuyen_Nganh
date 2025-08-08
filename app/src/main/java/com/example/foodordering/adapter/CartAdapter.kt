package com.example.foodordering.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodordering.adapter.CartAdapter.*
import com.example.foodordering.databinding.CartItemBinding

class CartAdapter(private val CartItems : MutableList<String>, private val cartItemCost : MutableList<String>, private val cartImage : MutableList<Int>) : RecyclerView.Adapter<CartViewHolder>() {

private val itemQuantity = IntArray(CartItems.size) { 1 }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding = CartItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CartViewHolder(binding)
    }



    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bind(position)
    }
    override fun getItemCount(): Int = CartItems.size

    inner class CartViewHolder(private val binding: CartItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int){
            binding.apply {
                textNameInCart.text = CartItems[position]
                textCostInCart.text = cartItemCost[position]
                imgCart.setImageResource(cartImage[position])
                textQuantityInCart.text = itemQuantity[position].toString()

                btnLess.setOnClickListener{
                decreaseQuantity(position)
                }
                btnPlus.setOnClickListener{
                increaseQuantity(position)
                }
                btnDelete.setOnClickListener{
                    val itemPosition = adapterPosition
                    if (itemPosition != RecyclerView.NO_POSITION){
                        removeItem(itemPosition)
                    }
                }
            }
        }
        private  fun decreaseQuantity(position: Int){
            if (itemQuantity[position] > 1){
                itemQuantity[position]--
                binding.textQuantityInCart.text = itemQuantity[position].toString()
            }
        }
        private fun increaseQuantity(position: Int){
            itemQuantity[position]++
            binding.textQuantityInCart.text = itemQuantity[position].toString()

        }
        private fun removeItem(position: Int){
            CartItems.removeAt(position)
            cartItemCost.removeAt(position)
            cartImage.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, CartItems.size)
        }
    }
}