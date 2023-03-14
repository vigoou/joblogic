package com.quoctran.joblogic.presentation.ui.sell

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.quoctran.joblogic.databinding.FragmentSellBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * A fragment representing a list of Items.
 */
@AndroidEntryPoint
class AddSellFragment : Fragment() {

    private val viewModel by viewModels<SellViewModel>()
    private lateinit var binding : FragmentSellBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSellBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservations()
//        viewModel.getListSell()
    }

    private fun initObservations(){
//        viewModel.listProductLiveData.observe(viewLifecycleOwner){
//            sellAdapter.updateProductList(it)
//        }
    }
}