package com.mvvm_shoppinglist.Daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.mvvm_shoppinglist.Entities.ShoppingItem

/*
* This class is called DAO
* Here we declare methods to access database
* Here in SQL we cannot call database in main thread , for that reason we have COROUTINES and THREADS
* declare SUSPEND front of methods so, that you don't get error
* Conflict_Strategy = Replace means whenever that record already there in database it will just update the record
* */

@Dao
interface ShoppingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: ShoppingItem)

    @Delete
    suspend fun delete(item:ShoppingItem)

    @Query("Select * from shopping_table")
    fun getAllShoppingItems() : LiveData<List<ShoppingItem>>
}