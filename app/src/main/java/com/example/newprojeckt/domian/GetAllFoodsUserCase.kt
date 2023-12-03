package com.example.newprojeckt.domian

import com.example.newprojeckt.data.prefences.model.FoodModel

interface GetAllFoodsUserCase {
    fun getAllFoods(): List<FoodModel>
}
