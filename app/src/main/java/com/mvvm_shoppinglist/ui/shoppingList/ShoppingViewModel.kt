package com.mvvm_shoppinglist.ui.shoppingList

import androidx.lifecycle.ViewModel
import com.mvvm_shoppinglist.Entities.ShoppingItem
import com.mvvm_shoppinglist.repositories.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


/*
* here no need of adding suspend keyword because we are defining methods
* in CoroutineScope - > Dispatchers.Main is used for shor performming task
* Dispatchers.Default for long running tasks
* */


class ShoppingViewModel(
    private var repository: ShoppingRepository
) : ViewModel() {

    fun upsert(item:ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.upsert(item)
    }

    fun delete(item:ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }

    fun getAllShoppingItems() = repository.getAllShoppingItems()

}