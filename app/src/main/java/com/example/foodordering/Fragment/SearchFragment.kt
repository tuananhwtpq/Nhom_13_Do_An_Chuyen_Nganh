package com.example.foodordering.Fragment

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.SearchView
import android.widget.TextView
import androidx.navigation.activity
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
        adapter = MenuAdapter(originalMenuNamelist.toMutableList(), originalMenuImageList.toMutableList(), originalMenuCostList.toMutableList())
        binding.searchRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.searchRecyclerView.adapter = adapter

        setupSearchView()
        return binding.root
    }
    private fun hideKeyboard() {
        val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
        var view = activity?.currentFocus
        if (view == null) {
            view = View(activity) // Nếu không có view nào có focus, tạo một view tạm để lấy window token
        }
        imm?.hideSoftInputFromWindow(view.windowToken, 0)
    }
    private fun setupSearchView() {
//        binding.editTextSearch.addTextChangedListener(object : TextWatcher {
//            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
//
//            }
//
//            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//
//            }
//
//            override fun afterTextChanged(s: Editable?) {
//                filterMenuItems(s.toString())
//
//            }
//        })
        binding.editTextSearch.setOnEditorActionListener(TextView.OnEditorActionListener { v, actionId, event ->
            // Kiểm tra xem sự kiện có phải là nhấn phím Enter/Search không
            // actionId có thể là EditorInfo.IME_ACTION_SEARCH, IME_ACTION_DONE, IME_ACTION_GO, IME_ACTION_NEXT, IME_ACTION_SEND
            // event != null && event.keyCode == KeyEvent.KEYCODE_ENTER cũng là một cách kiểm tra, nhưng actionId thường đáng tin cậy hơn cho các hành động IME.
            if (actionId == EditorInfo.IME_ACTION_SEARCH ||
                actionId == EditorInfo.IME_ACTION_DONE ||
                actionId == EditorInfo.IME_ACTION_GO ||
                (event != null && event.action == KeyEvent.ACTION_DOWN && event.keyCode == KeyEvent.KEYCODE_ENTER)) {

                // 1. Thực hiện tìm kiếm
                val query = binding.editTextSearch.text.toString()
                filterMenuItems(query) // Gọi hàm lọc của bạn

                // 2. Ẩn bàn phím
                hideKeyboard()

                return@OnEditorActionListener true // Trả về true để báo rằng sự kiện đã được xử lý
            }
            false // Trả về false nếu không xử lý sự kiện này (để hệ thống xử lý tiếp)
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
            binding.searchRecyclerView.adapter = adapter
        }
        else {
            filterMenuNamelist.addAll(originalMenuNamelist.filter { it.contains(query, ignoreCase = true) })
            filterMenuCostList.addAll(originalMenuCostList.filterIndexed { index, _ -> originalMenuNamelist[index].contains(query, ignoreCase = true) })
            filterMenuImageList.addAll(originalMenuImageList.filterIndexed { index, _ -> originalMenuNamelist[index].contains(query, ignoreCase = true) })
            adapter.updateData(filterMenuNamelist, filterMenuImageList, filterMenuCostList)

        }
        adapter.updateData(filterMenuNamelist, filterMenuImageList, filterMenuCostList)



    }

}