package com.example.newprojeckt.presentation.adapter

import com.example.newprojeckt.data.model.FoodModel

interface FoodsItemClick{
    fun onFoodItemClick(foodModel: FoodModel)

    fun deleteAtFoodIndex(index: Int)

}
