package com.quoctran.joblogic.presentation.ui.buy

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.quoctran.joblogic.domain.usecase.GetListProductUseCase
import com.quoctran.joblogic.presentation.model.ProductUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BuyViewModel @Inject constructor(private val getListProductUseCase: GetListProductUseCase)  : ViewModel(){

    private var _productList = MutableLiveData<List<ProductUI>>()
    var listProductLiveData: LiveData<List<ProductUI>> = _productList
    fun getListProduct(isLocal: Boolean){
        viewModelScope.launch {
            val listProduct =  ProductUI.mapFromDomainToUI(getListProductUseCase.getListProduct(isLocal))
            _productList.value = listProduct
        }
    }
}