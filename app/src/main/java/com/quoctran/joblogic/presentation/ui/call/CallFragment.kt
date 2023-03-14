package com.quoctran.joblogic.presentation.ui.call

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import com.quoctran.joblogic.R
import com.quoctran.joblogic.databinding.FragmentCallBinding
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel

/**
 * A fragment representing a list of Items.
 */
@AndroidEntryPoint
class CallFragment : Fragment() {
    private val callAdapter = CallAdapter()
    private val viewModel by viewModels<CallViewModel>()
    private lateinit var binding: FragmentCallBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCallBinding.inflate(inflater, container, false)
        binding.rvCall.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = callAdapter
            addItemDecoration(DividerItemDecoration(this.context,  DividerItemDecoration.VERTICAL))
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getListPerson()
        initObservations()
    }

    private fun initObservations(){
        viewModel.listPersonLiveData.observe(viewLifecycleOwner) {
            callAdapter.updatePersonList(it)
        }
    }

}