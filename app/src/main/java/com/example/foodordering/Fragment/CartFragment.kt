package com.example.foodordering.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodordering.R
import com.example.foodordering.adapter.CartAdapter
import com.example.foodordering.databinding.FragmentCartBinding



class CartFragment : Fragment() {
    private  lateinit var binding: FragmentCartBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCartBinding.inflate(inflater, container, false)

        val cartFoodName = listOf("Burger", "Pizza", "Burger", "Pizza","Burger", "Pizza","Burger", "Pizza")
        val cartFoodCost = listOf("$35", "$35", "$35", "$35","$35", "$35","$35", "$35")
        val cartImg = listOf(R.drawable.burger, R.drawable.pizza, R.drawable.burger, R.drawable.pizza, R.drawable.burger, R.drawable.pizza, R.drawable.burger, R.drawable.pizza)
        val adapter = CartAdapter(ArrayList(cartFoodName), ArrayList(cartFoodCost), ArrayList(cartImg))
        binding.cartRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.cartRecyclerView.adapter = adapter

        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CartFragment().apply {

            }
    }
}