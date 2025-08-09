package com.example.foodordering.Fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodordering.R
import com.example.foodordering.adapter.MenuAdapter
import com.example.foodordering.databinding.FragmentSearchBinding
import org.w3c.dom.Text


class SearchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding
    private lateinit var adapter: MenuAdapter
    private val originalMenuNamelist = listOf("Burger","Pizza","Hotdog","Pizza","Hotdog", "Burger", "Pizza", "Burger", "Pizza","Burger", "Pizza","Burger", "Pizza")
    private val originalMenuCostList = listOf("$5","$6","$7","$8","$9", "$35", "$36", "$37", "$38","$39", "$40","$44", "$53")
    private val originalMenuImageList = listOf(
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
    private val filterMenuNamelist = mutableListOf<String>()
    private val filterMenuCostList = mutableListOf<String>()
    private val filterMenuImageList = mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        adapter = MenuAdapter(filterMenuNamelist, filterMenuImageList, filterMenuCostList)
        binding.searchRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.searchRecyclerView.adapter = adapter

        setupSearchView()
        return binding.root
    }

    private fun setupSearchView() {
        binding.editTextSearch.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                filterMenuItems(s.toString())
            }
        })
        }

    private fun filterMenuItems(query: String) {
        filterMenuNamelist.clear()
        filterMenuCostList.clear()
        filterMenuImageList.clear()
        if(query.isEmpty()) {
            filterMenuNamelist.addAll(originalMenuNamelist)
            filterMenuCostList.addAll(originalMenuCostList)
            filterMenuImageList.addAll(originalMenuImageList)
            adapter.updateData(filterMenuNamelist, filterMenuImageList, filterMenuCostList)
            binding.searchRecyclerView.layoutManager = LinearLayoutManager(requireContext())
            binding.searchRecyclerView.adapter = adapter
        }
        else {
            filterMenuNamelist.addAll(originalMenuNamelist.filter { it.contains(query, ignoreCase = true) })
            filterMenuCostList.addAll(originalMenuCostList.filterIndexed { index, _ -> originalMenuNamelist[index].contains(query, ignoreCase = true) })
            filterMenuImageList.addAll(originalMenuImageList.filterIndexed { index, _ -> originalMenuNamelist[index].contains(query, ignoreCase = true) })
            adapter.updateData(filterMenuNamelist, filterMenuImageList, filterMenuCostList)
            binding.searchRecyclerView.layoutManager = LinearLayoutManager(requireContext())
            binding.searchRecyclerView.adapter = adapter

        }

    }

}