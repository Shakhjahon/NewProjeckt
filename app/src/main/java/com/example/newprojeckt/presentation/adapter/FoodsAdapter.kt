package com.example.newprojeckt.presentation.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newprojeckt.R
import com.example.newprojeckt.data.model.FoodModel
import com.example.newprojeckt.databinding.FooditemBinding

class FoodsAdapter(
    private val listner: FoodsItemClick,
) : RecyclerView.Adapter<FoodsAdapter.FoodViewHolder>() {

    private var foodList = mutableListOf<FoodModel>()

    fun updateFoodList(movieList: List<FoodModel>) {
        this.foodList.clear()
        this.foodList.addAll(movieList)
        Log.d("FFF", "updateFoodList $movieList")
        notifyDataSetChanged()
    }

    inner class FoodViewHolder(private val binding: FooditemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(foodModel: FoodModel) {
            binding.apply {
                foodList.indexOf(foodModel)
                CupCaces.text = foodModel.foodName
                find.text = foodModel.fooddescription
                price.text = "${foodModel.foodPrice}$"
                itemCard.setOnClickListener {
                    listner.onFoodItemClick(foodModel)
                }
                Glide.with(binding.root).load(foodModel.foodImg).into(binding.imgIv)

                deleteCard.setOnClickListener {
                    listner.deleteAtFoodIndex(foodList.indexOf(foodModel))
                }
            }
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