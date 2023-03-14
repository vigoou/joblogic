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
import dagger.hilt.android.HiltAndroidApp

/**
 * A fragment representing a list of Items.
 */
@AndroidEntryPoint
class SellFragment : Fragment() {

    private val viewModel by viewModels<SellViewModel>()
    private lateinit var binding : FragmentSellBinding
    private val sellAdapter = SellAdapter()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding.rvSell.apply {
            layoutManager =LinearLayoutManager(context)
            adapter = sellAdapter
        }
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