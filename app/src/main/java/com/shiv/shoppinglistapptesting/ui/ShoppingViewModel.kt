package com.shiv.shoppinglistapptesting.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shiv.shoppinglistapptesting.data.local.ShoppingDao
import com.shiv.shoppinglistapptesting.data.local.ShoppingItem
import com.shiv.shoppinglistapptesting.data.remote.responses.ImageResponse
import com.shiv.shoppinglistapptesting.others.Event
import com.shiv.shoppinglistapptesting.others.Resource
import com.shiv.shoppinglistapptesting.repositories.ShoppingRepository
import kotlinx.coroutines.launch

class ShoppingViewModel @ViewModelInject constructor(
    private val repository: ShoppingRepository
) : ViewModel() {

    val shoppingItems = repository.observeAllShoppingItem()
    val totalPrice = repository.observeTotalPrice()

    private val _images = MutableLiveData<Event<Resource<ImageResponse>>>()
    val images : LiveData<Event<Resource<ImageResponse>>> = _images

    private val _curImageUrl = MutableLiveData<String>()
    val curImageUrl : LiveData<String> = _curImageUrl


    private val _insertShoppinItemStatus = MutableLiveData<Event<Resource<ShoppingItem>>>()
    val insertShoppingItemStatue : LiveData<Event<Resource<ShoppingItem>>> = _insertShoppinItemStatus

    fun setCurImageUrl(url:String){
        _curImageUrl.postValue(url)
    }

    fun deleteShoppingItem(shoppingItem: ShoppingItem) = viewModelScope.launch {
        repository.deleteShoppingItem(shoppingItem)
    }

    fun insertShoppingItemIntoDb(shoppingItem: ShoppingItem) = viewModelScope.launch {
        repository.insertShoppingItem(shoppingItem)
    }

    fun inserShoppingItem(name:String, amounStringt:String, priceString: String){

    }

    fun searchForImage(imageQuery : String) {

    }

}