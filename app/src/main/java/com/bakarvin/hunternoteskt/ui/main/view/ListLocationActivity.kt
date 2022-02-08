package com.bakarvin.hunternoteskt.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bakarvin.hunternoteskt.databinding.ActivityListLocationBinding

class ListLocationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListLocationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListLocationBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}