package com.quoctran.joblogic.presentation.ui.addsell

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.quoctran.joblogic.R
import com.quoctran.joblogic.databinding.FragmentSellBinding
import com.quoctran.joblogic.presentation.core.Navigation
import com.quoctran.joblogic.presentation.model.ProductUI
import dagger.hilt.android.AndroidEntryPoint

/**
 * A fragment representing a list of Items.
 */
@AndroidEntryPoint
class AddSellFragment : Fragment() {

    private val viewModel by viewModels<SellViewModel>()
    private lateinit var binding: FragmentSellBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSellBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservations()
        binding.btnAdd.setOnClickListener {
            if (!validateInfo()) {
                Toast.makeText(
                    requireContext(),
                    getString(R.string.message_input_data),
                    Toast.LENGTH_LONG
                ).show()
            } else {
                val productUI = ProductUI(
                    -1,
                    binding.acetName.text.toString(),
                    binding.acetPrice.text?.toString()?.toLong() ?: 0L,
                    binding.acetQuantity.text?.toString()?.toInt() ?: 0,
                    2
                )
                viewModel.addProductToLocal(productUI)
            }
        }
    }

    private fun initObservations() {
        viewModel.productILiveData.observe(viewLifecycleOwner) {
            if(it != -1L){
                //back to pre fragment
                findNavController().popBackStack()
            }

        }
    }

    private fun validateInfo(): Boolean {
        if (binding.acetName.text.isNullOrBlank()) {
            return false
        }
        if (binding.acetPrice.text.isNullOrBlank()) {
            return false
        }
        if (binding.acetQuantity.text.isNullOrBlank()) {
            return false
        }
        return true
    }
}