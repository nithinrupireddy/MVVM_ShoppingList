package com.mvvm_shoppinglist.ui.shoppingList

import com.mvvm_shoppinglist.Entities.ShoppingItem

interface ShoppingDialogInterface {

    fun onAddButtonClicked(item: ShoppingItem)
}