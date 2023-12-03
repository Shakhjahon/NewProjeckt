package com.example.newprojeckt.data.repository

import com.example.newprojeckt.data.model.FoodModel

interface GetAllFoodsRepository {
  suspend fun getAllFoods(): List<FoodModel>
}