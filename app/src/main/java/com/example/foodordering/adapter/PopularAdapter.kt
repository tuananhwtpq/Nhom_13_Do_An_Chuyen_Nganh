package com.example.foodordering.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodordering.databinding.PopularItemBinding

class PopularAdapter(private val popularList: List<String>, private val costList: List<String>, private val image:List<Int>) : RecyclerView.Adapter<PopularAdapter.PopularViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        return  PopularViewHolder(PopularItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }



    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        val item = popularList[position]
        val imgs = image[position]
        val cost = costList[position]
        holder.bind(item,cost, imgs)
    }
    override fun getItemCount(): Int {
        return popularList.size
    }
    class PopularViewHolder(private val binding : PopularItemBinding) : RecyclerView.ViewHolder(binding.root) {
        private val imageView = binding.imageViewPopular
        fun bind(item: String, cost: String, imgs: Int) {
            binding.textViewName.text = item
            binding.textViewCost.text = cost
            binding.imageViewPopular.setImageResource(imgs)
        }

    }

}


