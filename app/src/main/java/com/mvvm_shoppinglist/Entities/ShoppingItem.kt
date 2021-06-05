package com.mvvm_shoppinglist.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


/*
* This is called Entity class
* It is nothing but table for Shopping Database
* We need to annotate with @entity
* Here we need to declare id (primary key) because we want every record to be unique
* Declare id outside the constructor because Kotlin will automatically generate id for us
* */


@Entity(tableName = "shopping_table")
data class ShoppingItem(
    @ColumnInfo(name="item_name")
    var name:String,
    @ColumnInfo(name="item_amount")
    var amount:String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? =null
}