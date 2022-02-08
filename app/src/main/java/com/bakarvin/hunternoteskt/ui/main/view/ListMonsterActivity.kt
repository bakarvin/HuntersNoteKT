package com.bakarvin.hunternoteskt.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bakarvin.hunternoteskt.data.api.ApiHelper
import com.bakarvin.hunternoteskt.data.api.ConfigRetrofit
import com.bakarvin.hunternoteskt.data.model.monster.ModelMonster
import com.bakarvin.hunternoteskt.databinding.ActivityListMonsterBinding
import com.bakarvin.hunternoteskt.ui.base.ViewModelFactory
import com.bakarvin.hunternoteskt.ui.main.adapter.MonsterAdapter
import com.bakarvin.hunternoteskt.ui.main.viewmodel.ListMonsterViewModel
import com.bakarvin.hunternoteskt.util.*

class ListMonsterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListMonsterBinding
    private lateinit var viewModel: ListMonsterViewModel
    private lateinit var monsterAdapter: MonsterAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListMonsterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViewModel()
        setupUi()
        setupObserver()
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider( this, ViewModelFactory(ApiHelper(ConfigRetrofit.apiService))
        ).get(ListMonsterViewModel::class.java)
    }

    private fun setupUi() {
        binding.rvHome.layoutManager = LinearLayoutManager(this)
        monsterAdapter = MonsterAdapter(arrayListOf())
        binding.rvHome.addItemDecoration(
            DividerItemDecoration(
                binding.rvHome.context,
                (binding.rvHome.layoutManager as LinearLayoutManager
                        ).orientation
            )
        )
        binding.rvHome.adapter = monsterAdapter
    }

    private fun setupObserver() {
        viewModel.getAllMonster().observe(this, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        binding.rvHome.visibility = View.VISIBLE
                        binding.progressBar.visibility = View.GONE
                        resource.data?.let { listMonster -> retrieveList(listMonster) }
                    } Status.ERROR -> {
                    binding.rvHome.visibility = View.VISIBLE
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                } Status.LOADING -> {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.rvHome.visibility = View.GONE
                }

                }
            }
        })
    }

    private fun retrieveList(monster: List<ModelMonster>) {
        monsterAdapter.apply {
            addMonsters(monster)
            notifyDataSetChanged()
        }
    }
}