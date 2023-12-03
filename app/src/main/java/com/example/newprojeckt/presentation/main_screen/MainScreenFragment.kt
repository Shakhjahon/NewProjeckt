package com.example.newprojeckt.presentation.main_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.newprojeckt.R
import com.example.newprojeckt.databinding.FragmentMainScreenBinding
import com.example.newprojeckt.presentation.adapter.FoodsAdapter


class MainScreenFragment : Fragment() {

    private val binding: FragmentMainScreenBinding by lazy {
        FragmentMainScreenBinding.inflate(layoutInflater)
    }
    private lateinit var viewModel: MainScreenViewModel

    private val foodAdapter: FoodsAdapter by lazy {
        FoodsAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(
            this, ViewModelProvider.NewInstanceFactory()
        )[MainScreenViewModel::class.java]

        setUpViewStatusBar()
        setUpObserveData()
        setUpViews()
    }

    private fun setUpViewStatusBar() {
        requireActivity().window?.statusBarColor =
            resources.getColor(R.color.onBoarding_btn_backround)
        requireActivity().window?.navigationBarColor = resources.getColor(R.color.white)
    }

    private fun setUpObserveData() = viewModel.apply {
        foodLiveData.observe(viewLifecycleOwner) { foodList ->
            foodAdapter.updateFoodList(foodList)
        }
    }
    private fun setUpViews() = binding.apply {
        recycliview.adapter = foodAdapter
    }
}