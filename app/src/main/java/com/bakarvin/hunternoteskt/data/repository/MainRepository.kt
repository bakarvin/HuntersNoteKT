package com.bakarvin.hunternoteskt.data.repository

import com.bakarvin.hunternoteskt.data.api.ApiHelper

class MainRepository(private val apiHelper: ApiHelper) {
    suspend fun getAllMonster() = apiHelper.getAllMonster()
}