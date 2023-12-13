package com.example.newprojeckt.presentation.main_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isNotEmpty
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.newprojeckt.R
import com.example.newprojeckt.data.fake_data.FoodSharedPref
import com.example.newprojeckt.data.model.FoodModel
import com.example.newprojeckt.databinding.FragmentMainFoodBasketBinding
import com.example.newprojeckt.presentation.adapter.FoodsAdapter
import com.example.newprojeckt.presentation.adapter.FoodsItemClick
import com.google.android.material.color.MaterialColors
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class MainFoodBasketFragment : Fragment(), FoodsItemClick {

    private val binding: FragmentMainFoodBasketBinding by lazy {
        FragmentMainFoodBasketBinding.inflate(layoutInflater)
    }

    private var foodList = mutableListOf<FoodModel>()


    private val sharedpref: FoodSharedPref by lazy {
        FoodSharedPref(requireContext())
    }
    private val adapter: FoodsAdapter by lazy {
        FoodsAdapter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View = binding.root


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewsAndAdapter()
        setUpViewStatusBar()
        setOnSearch()
        setUpViews()
        deleteFood()
    }

    private fun setUpViews() {
        val savedFoodList = sharedpref.getAllSavedFood()
        adapter.updateFoodList(savedFoodList)
        binding.recycliIv.adapter = adapter
    }

    private fun setUpViewStatusBar() {
        requireActivity().window.statusBarColor = resources.getColor(R.color.white)
        requireActivity().window.navigationBarColor = resources.getColor(R.color.white)
    }

    override fun onFoodItemClick(foodModel: FoodModel) {
    }

    override fun deleteAtFoodIndex(index: Int) {
        sharedpref.deleteFoodAtIndex(index)
        setupViewsAndAdapter()
    }


    private fun deleteFood() {
        binding.deleteCard.setOnClickListener {
            showDeleteNoteDiolog()
        }
        binding.key.setOnClickListener {
            findNavController().navigate(
                R.id.action_mainFoodBasketFragment_to_mainScreenFragment
            )
        }
    }

    private fun setupViewsAndAdapter() {
        val listOfNotes = sharedpref.getAllSavedFood()
        foodList = listOfNotes.toMutableList()
        adapter.updateFoodList(listOfNotes)
        binding.recycliIv.adapter = adapter
        if (listOfNotes.isNotEmpty()) {
            binding.apply {
                recycliIv.visibility = View.VISIBLE
            }
        } else {
            binding.recycliIv.visibility = View.GONE
        }
    }

    private fun showDeleteNoteDiolog() {
        if (binding.recycliIv.isNotEmpty()) {
            val alertDiolog = MaterialAlertDialogBuilder(requireContext())
            alertDiolog.setMessage("Вы хотите удалить все Вкусняшки?")
            alertDiolog.setPositiveButton("Да") { dialog, _ ->
                deleteAllSavedFoods()
                dialog.dismiss()
            }
            alertDiolog.setNegativeButton("Отмена") { dialog, _ ->
                dialog.dismiss()
            }
            alertDiolog.create().show()
        }
    }

    private fun fitherFood(title: String) {
        val fither = foodList.filter { name ->
            name.foodName.contains(title, ignoreCase = true)
        }
        adapter.updateFoodList(fither)
    }

    private fun setOnSearch() = binding.apply {
        cardFoodPrice.setOnQueryTextListener(object :
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let {
                    fitherFood(it)
                }
                return true
            }
        })
    }

    private fun deleteAllSavedFoods() {
        sharedpref.delelteAllFood()
        adapter.updateFoodList((emptyList()))
        binding.recycliIv.visibility = View.GONE
    }
}
