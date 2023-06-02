package com.shiv.shoppinglistapptesting.repositories

import androidx.lifecycle.LiveData
import com.shiv.shoppinglistapptesting.data.local.ShoppingItem
import com.shiv.shoppinglistapptesting.data.remote.responses.ImageResponse
import com.shiv.shoppinglistapptesting.others.Resource
import retrofit2.Response

interface ShoppingRepository {
    suspend fun insertShoppingItem(shoppingItem: ShoppingItem)

    suspend fun deleteShoppingItem(shoppingItem: ShoppingItem)

    fun observeAllShoppingItem() : LiveData<List<ShoppingItem>>

    fun observeTotalPrice() : LiveData<Float>

    suspend fun searchForImage(imageQuery: String) : Resource<ImageResponse>
}