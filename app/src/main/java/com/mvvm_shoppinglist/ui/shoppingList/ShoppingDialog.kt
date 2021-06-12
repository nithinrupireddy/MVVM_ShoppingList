package com.mvvm_shoppinglist.ui.shoppingList

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.mvvm_shoppinglist.Entities.ShoppingItem
import com.mvvm_shoppinglist.R
import kotlinx.android.synthetic.main.shopping_dialogitem.*

/*
* As this is Dialog class when we click add ,we cannot pass the item directly to activity
* So for that reason we need to create a interface and pass the item to interface
* */

class ShoppingDialog(context: Context, var addOnClick: ShoppingDialogInterface) :
    AppCompatDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.shopping_dialogitem)

        tvAdd.setOnClickListener {
            val name = etName.text.toString()
            val amount = etAmount.text.toString()

            if (name.isEmpty() || amount.isEmpty()) {
                Toast.makeText(context, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }

            val item = ShoppingItem(name, amount.toInt())
            addOnClick.onAddButtonClicked(item)
            dismiss()

        }

        tvCancel.setOnClickListener {
            cancel()
        }
    }


}