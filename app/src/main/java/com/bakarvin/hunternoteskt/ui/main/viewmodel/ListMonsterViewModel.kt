package com.bakarvin.hunternoteskt.ui.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.bakarvin.hunternoteskt.data.repository.MainRepository
import com.bakarvin.hunternoteskt.util.Resource
import kotlinx.coroutines.Dispatchers

class ListMonsterViewModel(private val mainRepository: MainRepository): ViewModel() {
    fun getAllMonster() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = mainRepository.getAllMonster()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, msg = exception.message ?: "Error Occurred!"))
        }
    }
}