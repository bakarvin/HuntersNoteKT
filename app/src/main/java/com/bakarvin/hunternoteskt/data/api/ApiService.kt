package com.bakarvin.hunternoteskt.data.api

import com.bakarvin.hunternoteskt.data.model.monster.ModelMonster
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {


    //Get Spesific Monster
    @GET("monster/")
    suspend fun gOneMonster( @Query("q") q: String?): List<ModelMonster>
    @GET("monsters/")
    suspend fun getAllMonster(): List<ModelMonster>
}