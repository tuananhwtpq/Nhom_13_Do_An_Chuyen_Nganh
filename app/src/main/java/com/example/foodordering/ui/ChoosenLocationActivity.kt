package com.example.foodordering.ui

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.foodordering.R
import com.example.foodordering.databinding.ActivityChoosenLocationBinding

class ChoosenLocationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityChoosenLocationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityChoosenLocationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val locationList: Array<String> = arrayOf("Ha Noi","Ho Chi Minh","Da Nang","Can Tho","Vung Tau")
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, locationList)
        val autoCompleteTextView = binding.listOfLocation
        autoCompleteTextView.setAdapter(adapter)
    }
}