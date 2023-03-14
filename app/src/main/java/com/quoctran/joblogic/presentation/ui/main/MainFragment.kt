package com.quoctran.joblogic.presentation.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.quoctran.joblogic.R
import com.quoctran.joblogic.databinding.FragmentMainBinding
import com.quoctran.joblogic.presentation.core.Navigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {
    lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)

        binding.btnCallList.setOnClickListener {
            Navigation.navigationTo(R.id.action_mainFragment_to_callFragment)
        }

        binding.btnBuyList.setOnClickListener {
            val args = Bundle()
            args.putInt("type", 1)
            Navigation.navigationTo(R.id.action_mainFragment_to_buyFragment, args)
        }
        binding.btnSellList.setOnClickListener {
            val args = Bundle()
            args.putInt("type", 2)
            Navigation.navigationTo(R.id.action_mainFragment_to_buyFragment, args)
        }
        return binding.root
    }

}