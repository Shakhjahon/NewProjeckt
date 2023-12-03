package com.example.newprojeckt.presentation.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newprojeckt.data.prefences.model.FoodModel
import com.example.newprojeckt.domian.getAllFoodsUserCaseImpl
import kotlinx.coroutines.launch

class MainScreenViewModel : ViewModel() {

    private val getAllFoodsUseCase = getAllFoodsUserCaseImpl()

    val foodLiveData: MutableLiveData<List<FoodModel>> = MutableLiveData()

    init {
        getAllFoods()
    }

    private fun getAllFoods() {
        viewModelScope.launch {
            val responce = getAllFoodsUseCase.getAllFoods()
            foodLiveData.postValue(responce)
        }
    }
}