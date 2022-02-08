package com.bakarvin.hunternoteskt.data.api

class ApiHelper(private val apiService: ApiService) {
    suspend fun getAllMonster() = apiService.getAllMonster()
}