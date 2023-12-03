package com.example.newprojeckt.presentation.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.newprojeckt.R
import com.example.newprojeckt.data.prefences.face_data.UserEnteredSharedpref
import com.example.newprojeckt.databinding.FragmentOnBoardingScreenBinding

class OnBoardingScreenFragment : Fragment() {

    private val binding: FragmentOnBoardingScreenBinding by lazy {
        FragmentOnBoardingScreenBinding.inflate(layoutInflater)
    }
    private val sharedPreferences: UserEnteredSharedpref by lazy {
        UserEnteredSharedpref(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViewStatusBar()
        if (sharedPreferences.getIsUserFirstSign()) {
            binding.getStartingBtn.setOnClickListener {
                findNavController().navigate(
                    R.id.action_onBoardingScreenFragment_to_mainScreenFragment
                )
            }
        } else {
            binding.getStartingBtn.setOnClickListener {
                sharedPreferences.setUserFirstSign(true)
                findNavController().navigate(
                    R.id.action_onBoardingScreenFragment_to_mainScreenFragment
                )
            }
        }
    }

    private fun setUpViewStatusBar() {
        requireActivity().window?.statusBarColor = resources.getColor(R.color.gren)
        requireActivity().window?.navigationBarColor = resources.getColor(R.color.gren)
    }
}