package com.quoctran.joblogic.presentation.ui.buy

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DividerItemDecoration
import com.quoctran.joblogic.R
import com.quoctran.joblogic.databinding.FragmentBuyBinding
import com.quoctran.joblogic.databinding.FragmentSellBinding
import com.quoctran.joblogic.presentation.core.Navigation
import dagger.hilt.android.AndroidEntryPoint

/**
 * A fragment representing a list of Items.
 */
@AndroidEntryPoint
class BuyFragment : Fragment() {
    private val viewModel by viewModels<BuyViewModel>()
    private val buyAdapter = BuyAdapter()
    lateinit var binding: FragmentBuyBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBuyBinding.inflate(inflater, container, false)
        binding.rvBuy.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = buyAdapter
            addItemDecoration(DividerItemDecoration(this.context,  DividerItemDecoration.VERTICAL))
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservations()
        val type = arguments?.getInt("type", 1)
        viewModel.getListProduct(type != 1)

        if (type != 1) {
            binding.fabAdd.visibility = View.VISIBLE
        } else {
            binding.fabAdd.visibility = View.GONE
        }

        binding.fabAdd.setOnClickListener{
            Navigation.navigationTo(R.id.action_buyFragment_to_sellFragment)
        }
    }

    private fun initObservations() {
        viewModel.listProductLiveData.observe(viewLifecycleOwner) {
            buyAdapter.updateProductList(it)
        }
    }
}