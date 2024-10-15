package com.example.lab2.ui.newfragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NewViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is new Fragment"
    }
    val text: LiveData<String> = _text
}