package com.mvvm_shoppinglist.Databases

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mvvm_shoppinglist.Daos.ShoppingDao
import com.mvvm_shoppinglist.Entities.ShoppingItem


/*
* Here first in Database annotation we declare all entities
* Next we extend RoomDatabase
* Next we get access to ShoppingDAO class
* Companion object is nothing but static in JAVA
* @volatile is used when we want to use same instance in different threads simultaneously instead of creating multiply
* When instance is null we are called syncronized block
* Synchronized block blocks all threads to access instance
* In synchronized block we check again whether instance is null ,if not null we call create database
*/

@Database(
    entities = [ShoppingItem::class],
    version = 1
)

abstract class ShoppingDatabase : RoomDatabase() {


    abstract fun getShoppingDAO() : ShoppingDao

    companion object {

        @Volatile
        private var instance : ShoppingDatabase? = null

        private var LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: createDatabase(context).also { instance=it }
        }

        private fun createDatabase(context: Context)=
            Room.databaseBuilder(context.applicationContext,
                ShoppingDatabase::class.java,"ShoppingDB.db").build()

    }

}