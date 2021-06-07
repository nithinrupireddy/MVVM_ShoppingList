package com.mvvm_shoppinglist.ui.shoppingList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.mvvm_shoppinglist.Databases.ShoppingDatabase
import com.mvvm_shoppinglist.R
import com.mvvm_shoppinglist.repositories.ShoppingRepository

class ShoppingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)

        val database = ShoppingDatabase(this)
        val repository = ShoppingRepository(database)
        val factory = ShoppingViewModelFactory(repository)

        val viewmodel = ViewModelProvider(this,factory).get(ShoppingViewModel::class.java)
    }
}