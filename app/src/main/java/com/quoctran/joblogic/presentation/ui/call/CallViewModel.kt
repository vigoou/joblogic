package com.quoctran.joblogic.presentation.ui.call

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.quoctran.joblogic.domain.usecase.GetListPersonUseCase
import com.quoctran.joblogic.presentation.model.PersonUI
import com.quoctran.joblogic.presentation.model.ProductUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CallViewModel @Inject constructor(private val getPersonUseCase: GetListPersonUseCase) : ViewModel() {

    private var _personList = MutableLiveData<List<PersonUI>>()
    var listPersonLiveData: LiveData<List<PersonUI>> = _personList


    fun getListPerson(){
        viewModelScope.launch {
            _personList.value = PersonUI.mapFromDomainToUI(getPersonUseCase.getListPerson())
        }
    }
}