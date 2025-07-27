package com.example.foodordering.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.denzcoskun.imageslider.models.SlideModel

import com.example.foodordering.R
import com.example.foodordering.adapter.PopularAdapter
import com.example.foodordering.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater)
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imgList = ArrayList<SlideModel>()
        imgList.add(SlideModel(R.drawable.banner1,  ScaleTypes.FIT))
        imgList.add(SlideModel(R.drawable.banner2, ScaleTypes.FIT))
        imgList.add(SlideModel(R.drawable.banner3, ScaleTypes.FIT))

        val imageSlider = binding.imageSlider
        imageSlider.setImageList(imgList)
        imageSlider.setImageList(imgList, ScaleTypes.FIT)
        imageSlider.setItemClickListener(object : ItemClickListener {
            override fun doubleClick(position: Int) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(position: Int) {
                val itemPos = imgList[position]
                val item = "Selected Image $position"
                Toast.makeText(requireContext(), item, Toast.LENGTH_SHORT).show()
            }
        }
        )
        val poularlist = listOf("Burger","Pizza","Hotdog","Pizza","Hotdog")
        val costList = listOf("$5","$6","$7","$8","$9")
        val imageList = listOf(R.drawable.burger,R.drawable.pizza,R.drawable.hotdog,R.drawable.pizza,R.drawable.hotdog)
        val adapter = PopularAdapter(poularlist,costList,imageList)
        binding.popularRecyclerViewHome.layoutManager = LinearLayoutManager(requireContext())
        binding.popularRecyclerViewHome.adapter = adapter
    }
    companion object{


    }
}