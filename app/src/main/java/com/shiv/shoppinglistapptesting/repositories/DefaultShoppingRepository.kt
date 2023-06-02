package com.shiv.shoppinglistapptesting.repositories

import androidx.lifecycle.LiveData
import com.shiv.shoppinglistapptesting.data.local.ShoppingDao
import com.shiv.shoppinglistapptesting.data.local.ShoppingItem
import com.shiv.shoppinglistapptesting.data.remote.PixelbayApi
import com.shiv.shoppinglistapptesting.data.remote.responses.ImageResponse
import com.shiv.shoppinglistapptesting.others.Resource
import retrofit2.Response
import javax.inject.Inject

class DefaultShoppingRepository @Inject constructor(
    private val shoppingDao: ShoppingDao,
    private val pixelbayApi: PixelbayApi
) : ShoppingRepository{
    override suspend fun insertShoppingItem(shoppingItem: ShoppingItem) {
        shoppingDao.insertShoppingItem(shoppingItem)
    }

    override suspend fun deleteShoppingItem(shoppingItem: ShoppingItem) {
        shoppingDao.deleteShoppingItem(shoppingItem)
    }

    override fun observeAllShoppingItem(): LiveData<List<ShoppingItem>> {
        return shoppingDao.observeAllShoppingItems()
    }

    override fun observeTotalPrice(): LiveData<Float> {
        return shoppingDao.observeTotalPrice()
    }

    override suspend fun searchForImage(imageQuery: String): Resource<ImageResponse> {
        return try {
            val response = pixelbayApi.searchForImage(imageQuery)
            if(response.isSuccessful){
                response.body()?.let{
                    return@let Resource.success(it)
                } ?: Resource.error("Unknown error occured",null)
            } else {
                Resource.error("Unknown error occured!",null)
            }
        } catch (e: java.lang.Exception){
            Resource.error("Couldnt reach the server check your internet!", null)
        }
    }

}