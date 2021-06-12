package com.mvvm_shoppinglist.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mvvm_shoppinglist.Entities.ShoppingItem
import com.mvvm_shoppinglist.R
import com.mvvm_shoppinglist.ui.shoppingList.ShoppingViewModel
import kotlinx.android.synthetic.main.shopping_item.view.*

class ShoppingRecyclerAdapter(
    var items: List<ShoppingItem>,
    var viewmodel: ShoppingViewModel
) : RecyclerView.Adapter<ShoppingRecyclerAdapter.ShoppingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        var view =
            LayoutInflater.from(parent.context).inflate(R.layout.shopping_item, parent, false)
        return ShoppingViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val currentShoppingItem = items[position]

        holder.itemView.titleTV.text = currentShoppingItem.name
        holder.itemView.amountTV.text = "${currentShoppingItem.amount}"

        holder.itemView.ivDelete.setOnClickListener {
            viewmodel.delete(currentShoppingItem)
        }

        holder.itemView.ivAdd.setOnClickListener {
            currentShoppingItem.amount++
            viewmodel.upsert(currentShoppingItem)
        }

        holder.itemView.ivRemove.setOnClickListener {
            currentShoppingItem.amount--
            viewmodel.upsert(currentShoppingItem)
        }

    }

    inner class ShoppingViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview)

}
