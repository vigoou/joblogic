package com.quoctran.joblogic.presentation.ui.call

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.quoctran.joblogic.R
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel

/**
 * A fragment representing a list of Items.
 */
@AndroidEntryPoint
class CallFragment : Fragment() {
    private val callAdapter = CallAdapter()
    private val viewModel by viewModels<CallViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_call, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = LinearLayoutManager(context)
                adapter = callAdapter
            }
        }
        return view
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