package com.example.newprojeckt.data.repository

import com.example.newprojeckt.data.fake_data.foodFakeDates
import com.example.newprojeckt.data.model.FoodModel

class GetAllFoodsRepositoryImpl : GetAllFoodsRepository {
    override suspend fun getAllFoods(): List<FoodModel> = foodFakeDates()

}