package com.mvvm_shoppinglist.ui.shoppingList

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.mvvm_shoppinglist.Entities.ShoppingItem
import com.mvvm_shoppinglist.R
import com.mvvm_shoppinglist.adapters.ShoppingRecyclerAdapter
import kotlinx.android.synthetic.main.activity_shopping.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class ShoppingActivity : AppCompatActivity(), KodeinAware {

    override val kodein by kodein()
    private val factory: ShoppingViewModelFactory by instance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)

        /* val database = ShoppingDatabase(this)
         val repository = ShoppingRepository(database)
         val factory = ShoppingViewModelFactory(repository)*/

        val viewmodel = ViewModelProvider(this, factory).get(ShoppingViewModel::class.java)

        val adapter = ShoppingRecyclerAdapter(listOf(), viewmodel)

        rvShoppingList.layoutManager = LinearLayoutManager(this)
        rvShoppingList.adapter = adapter

        viewmodel.getAllShoppingItems().observe(this, Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()
        })

        fab.setOnClickListener {
            ShoppingDialog(this, object : ShoppingDialogInterface {
                override fun onAddButtonClicked(item: ShoppingItem) {
                    viewmodel.upsert(item)
                }
            }).show()
        }


    }
}