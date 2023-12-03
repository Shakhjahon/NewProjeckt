package com.example.newprojeckt.data.prefences.repositore

import com.example.newprojeckt.data.prefences.model.FoodModel

interface GetAllFoodsRepositore {
    fun getAllFoods(): List<FoodModel>
}