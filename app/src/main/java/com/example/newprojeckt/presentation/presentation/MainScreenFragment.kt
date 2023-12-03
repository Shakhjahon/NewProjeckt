package com.example.newprojeckt.presentation.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.newprojeckt.R
import com.example.newprojeckt.presentation.presentation.adapter.FoodsAdapter
import com.example.newprojeckt.databinding.FragmentMainScreenBinding


class MainScreenFragment : Fragment() {

    private val binding: FragmentMainScreenBinding by lazy {
        FragmentMainScreenBinding.inflate(layoutInflater)
    }
    private lateinit var viewModel: MainScreenViewModel

    private val adapter: FoodsAdapter by lazy {
        FoodsAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViewStatusBar()
        viewModel = ViewModelProvider(
            this, ViewModelProvider.NewInstanceFactory()
        )[MainScreenViewModel::class.java]
        viewModel.foodLiveData.observe(viewLifecycleOwner) { foodList ->
            Log.d("SSS", "$foodList")
            FoodsAdapter()

            adapter.upfoodList(foodList)
            binding.recycliview.adapter = adapter

        }
    }

    private fun setUpViewStatusBar() {
        requireActivity().window?.statusBarColor =
            resources.getColor(R.color.onBoarding_btn_backround)
        requireActivity().window?.navigationBarColor = resources.getColor(R.color.white)
    }
}