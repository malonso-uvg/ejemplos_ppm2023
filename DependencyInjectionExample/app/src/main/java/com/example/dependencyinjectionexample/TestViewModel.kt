package com.example.dependencyinjectionexample

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class TestViewModel @Inject constructor(@Named("test3") testString3: String): ViewModel(){
    init {
        Log.d("ViewModel", "Test string: $testString3")
    }
}