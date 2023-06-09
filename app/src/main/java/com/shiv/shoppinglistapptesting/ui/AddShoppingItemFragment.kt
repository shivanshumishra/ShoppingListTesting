package com.shiv.shoppinglistapptesting.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.shiv.shoppinglistapptesting.R

class AddShoppingItemFragment : Fragment(R.layout.fragment_add_shopping_item) {
    lateinit var shoppingViewModel : ShoppingViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        shoppingViewModel = ViewModelProvider(requireActivity()).get(ShoppingViewModel::class.java)
    }
}