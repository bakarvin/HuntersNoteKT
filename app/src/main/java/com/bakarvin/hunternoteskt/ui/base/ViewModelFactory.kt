package com.bakarvin.hunternoteskt.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bakarvin.hunternoteskt.data.api.ApiHelper
import com.bakarvin.hunternoteskt.data.repository.MainRepository
import com.bakarvin.hunternoteskt.ui.main.viewmodel.ListMonsterViewModel

class ViewModelFactory(private val apiHelper: ApiHelper): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ListMonsterViewModel::class.java)){
            return ListMonsterViewModel(MainRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}