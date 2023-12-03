package com.example.newprojeckt.domian

import com.example.newprojeckt.data.model.FoodModel

interface GetAllFoodsUserCase {
   suspend fun getAllFoods(): List<FoodModel>
}
