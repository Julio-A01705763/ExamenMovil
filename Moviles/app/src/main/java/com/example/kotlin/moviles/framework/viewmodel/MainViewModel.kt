package com.example.kotlin.moviles.framework.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin.moviles.data.network.NetworkModuleDI
import com.example.kotlin.moviles.data.network.model.NinjaObject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val _records = MutableLiveData<List<NinjaObject>>()
    val records: LiveData<List<NinjaObject>> = _records

    fun getDnsLookup(domain: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = NetworkModuleDI.ninjaApiService.getDnsLookup(domain)
                if (response.isSuccessful && response.body() != null) {
                    Log.d("MainViewModel", "API Success: ${response.body()}")
                    _records.postValue(response.body()!!)
                } else {
                    Log.d("MainViewModel", "API Call Failed: ${response.errorBody()?.string()}")
                    // Emitir una lista vacía o manejar el error de otra manera
                    _records.postValue(emptyList())
                }
            } catch (e: Exception) {
                Log.e("MainViewModel", "API Error: ${e.localizedMessage}", e)
                // Emitir una lista vacía o manejar el error de otra manera
                _records.postValue(emptyList())
            }
        }
    }
}
