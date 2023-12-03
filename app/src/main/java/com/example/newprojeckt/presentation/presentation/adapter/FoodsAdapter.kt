package com.example.newprojeckt.presentation.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newprojeckt.R
import com.example.newprojeckt.data.prefences.model.FoodModel
import com.example.newprojeckt.databinding.FooditemBinding

class FoodsAdapter() : RecyclerView.Adapter<FoodsAdapter.FoodViewHolder>() {

    var foodList = mutableListOf<FoodModel>()

    fun upfoodList(movieList: List<FoodModel>) {
        foodList.clear()
        foodList.addAll(movieList)
    }

    inner class FoodViewHolder(private val binding: FooditemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(foodModel: FoodModel) {
            foodList.indexOf(foodModel)
            binding.CupCaces.text = foodModel.foodName
            binding.find.text = foodModel.fooddescription
            binding.price.text = foodModel.foodPrice.toString()
            Glide.with(binding.root).load(foodModel.foodImg).into(binding.imgIv)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int,
    ): FoodViewHolder {
        val binding = FooditemBinding.bind(
            LayoutInflater.from(parent.context).inflate(R.layout.fooditem, parent, false)
        )
        return FoodViewHolder(binding)
    }

    override fun getItemCount(): Int = foodList.size


    override fun onBindViewHolder(
        holder: FoodViewHolder,
        position: Int,
    ) {
        holder.bind(foodList[position])

    }
}
 
