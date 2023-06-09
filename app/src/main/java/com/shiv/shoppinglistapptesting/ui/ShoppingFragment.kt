package com.shiv.shoppinglistapptesting.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.shiv.shoppinglistapptesting.R

class ShoppingFragment : Fragment(R.layout.fragment_shopping) {
    
    lateinit var shoppingViewModel : ShoppingViewModel
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        shoppingViewModel = ViewModelProvider(requireActivity()).get(ShoppingViewModel::class.java)
    }
}