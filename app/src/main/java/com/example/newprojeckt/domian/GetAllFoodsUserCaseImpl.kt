package com.example.newprojeckt.domian

import com.example.newprojeckt.data.prefences.model.FoodModel
import com.example.newprojeckt.data.prefences.repositore.GetAllFoodsRipositoreImpl

class getAllFoodsUserCaseImpl : GetAllFoodsUserCase {

    private val foodsRipository = GetAllFoodsRipositoreImpl()

    override fun getAllFoods(): List<FoodModel> {
        return foodsRipository.getAllFoods()
    }
}