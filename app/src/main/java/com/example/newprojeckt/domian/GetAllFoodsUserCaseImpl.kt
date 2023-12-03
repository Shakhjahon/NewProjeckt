package com.example.newprojeckt.domian

import com.example.newprojeckt.data.model.FoodModel
import com.example.newprojeckt.data.repository.GetAllFoodsRepositoryImpl

class GetAllFoodsUserCaseImpl : GetAllFoodsUserCase {

    private val foodsRepository = GetAllFoodsRepositoryImpl()

    override suspend fun getAllFoods(): List<FoodModel> {
        return foodsRepository.getAllFoods()
    }
}