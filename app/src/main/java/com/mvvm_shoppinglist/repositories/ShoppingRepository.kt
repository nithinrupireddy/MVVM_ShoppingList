package com.mvvm_shoppinglist.repositories

import com.mvvm_shoppinglist.Databases.ShoppingDatabase
import com.mvvm_shoppinglist.Entities.ShoppingItem


/*
* Here in ShoppingRepository we implement methods of DAO class
* */


class ShoppingRepository(
    private var db : ShoppingDatabase
) {

    suspend fun upsert(item : ShoppingItem) = db.getShoppingDAO().upsert(item)

    suspend fun delete(item:ShoppingItem) = db.getShoppingDAO().delete(item)

    fun getAllShoppingItems() = db.getShoppingDAO().getAllShoppingItems()

}