package com.example.newprojeckt.data.prefences.repositore

import com.example.newprojeckt.data.prefences.face_data.foodFaceDatas
import com.example.newprojeckt.data.prefences.model.FoodModel

class GetAllFoodsRipositoreImpl : GetAllFoodsRepositore {
    override fun getAllFoods(): List<FoodModel> = foodFaceDatas()

}