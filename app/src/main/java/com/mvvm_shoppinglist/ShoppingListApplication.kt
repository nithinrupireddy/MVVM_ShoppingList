package com.mvvm_shoppinglist

import android.app.Application
import com.mvvm_shoppinglist.Databases.ShoppingDatabase
import com.mvvm_shoppinglist.repositories.ShoppingRepository
import com.mvvm_shoppinglist.ui.shoppingList.ShoppingViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton


/*
* Implemented kodein dependecy injection
* This reduces the boilerplate code of creating instances
* It implements Application(),KodeinAware
* If you get error please update compiler options in build gradle
* compileOptions{
        sourceCompatibility = 1.8
        targetCompatibility=1.8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
* */

class ShoppingListApplication : Application(), KodeinAware {

    override val kodein: Kodein = Kodein.lazy {
        import(androidXModule(this@ShoppingListApplication))
        bind() from singleton { ShoppingDatabase(instance()) }
        bind() from singleton { ShoppingRepository(instance()) }
        bind() from provider {
            ShoppingViewModelFactory(instance())
        }
    }
}