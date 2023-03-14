package com.quoctran.joblogic.presentation.ui.addsell

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.quoctran.joblogic.domain.usecase.AddProductToLocalUseCase
import com.quoctran.joblogic.presentation.model.ProductUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SellViewModel @Inject constructor(private val addProductToLocalUseCase: AddProductToLocalUseCase) : ViewModel(){
    private var _productId = MutableLiveData(-1L)
    var productILiveData: LiveData<Long> = _productId
    fun addProductToLocal(productUI: ProductUI){
        viewModelScope.launch {
            addProductToLocalUseCase(AddProductToLocalUseCase.Params(ProductUI.mapToDomain(productUI))){
                _productId.postValue(it)
            }
        }
    }
}