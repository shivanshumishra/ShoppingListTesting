package com.shiv.shoppinglistapptesting.di

import android.content.Context
import androidx.room.Room
import com.shiv.shoppinglistapptesting.data.local.ShoppingDao
import com.shiv.shoppinglistapptesting.data.local.ShoppingItemDatabase
import com.shiv.shoppinglistapptesting.data.remote.PixelbayApi
import com.shiv.shoppinglistapptesting.others.Constants.BASE_URL
import com.shiv.shoppinglistapptesting.others.Constants.DATABASE_NAME
import com.shiv.shoppinglistapptesting.repositories.DefaultShoppingRepository
import com.shiv.shoppinglistapptesting.repositories.ShoppingRepository
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@dagger.Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideShoppingItemDatabase(
        @ApplicationContext context:Context
    ) = Room.databaseBuilder(context,ShoppingItemDatabase::class.java,DATABASE_NAME).build()


    @Singleton
    @Provides
    fun provideDefaultShoppingRepository(
        dao:ShoppingDao,
        api : PixelbayApi
    ) = DefaultShoppingRepository(dao,api) as ShoppingRepository

    @Singleton
    @Provides
    fun provideShoppingDao(
        database: ShoppingItemDatabase
    ) = database.shoppingDao()

    @Singleton
    @Provides
    fun providePixelbayAPI() : PixelbayApi {
        return Retrofit
            .Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(PixelbayApi::class.java)
    }
}