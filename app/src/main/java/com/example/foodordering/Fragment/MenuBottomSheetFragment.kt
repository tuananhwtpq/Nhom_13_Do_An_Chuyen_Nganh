package com.example.foodordering.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodordering.R
import com.example.foodordering.adapter.MenuAdapter
import com.example.foodordering.adapter.PopularAdapter
import com.example.foodordering.databinding.FragmentMenuBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class MenuBottomSheetFragment : BottomSheetDialogFragment() {
private lateinit var binding: FragmentMenuBottomSheetBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMenuBottomSheetBinding.inflate(inflater, container, false)
        binding.imageButtonClose.setOnClickListener {
            dismiss()
        }
        val menuNamelist = listOf("Burger","Pizza","Hotdog","Pizza","Hotdog", "Burger", "Pizza", "Burger", "Pizza","Burger", "Pizza","Burger", "Pizza")
        val menuCostList = listOf("$5","$6","$7","$8","$9", "$35", "$36", "$37", "$38","$39", "$40","$44", "$53")
        val menuImageList = listOf(
            R.drawable.burger,
            R.drawable.pizza,
            R.drawable.hotdog,
            R.drawable.pizza,
            R.drawable.hotdog,
            R.drawable.burger,
            R.drawable.pizza,
            R.drawable.burger,
            R.drawable.pizza,
            R.drawable.burger,
            R.drawable.pizza,
            R.drawable.burger,
            R.drawable.pizza)
        val adapter = MenuAdapter(menuNamelist.toMutableList(),menuImageList.toMutableList(),menuCostList.toMutableList())
        binding.menuRecyclerViewBottomSheet.layoutManager = LinearLayoutManager(requireContext())
        binding.menuRecyclerViewBottomSheet.adapter = adapter
        return binding.root
    }

    companion object {


    }
}