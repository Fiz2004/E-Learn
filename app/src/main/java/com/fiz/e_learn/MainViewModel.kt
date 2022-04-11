package com.fiz.e_learn

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel:ViewModel() {
    var mainItems by mutableStateOf<MainItems>(MainItems(0))
        private set

    var todoItems = mutableStateListOf<MainItems>()
        private set

    fun addItem(mainItems:MainItems){
        this.mainItems =MainItems(this.mainItems.page+1)
    }

    fun removeItem(mainItems:MainItems){
        this.mainItems =MainItems(this.mainItems.page-1)
    }
}