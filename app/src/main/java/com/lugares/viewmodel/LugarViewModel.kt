package com.lugares.viewmodel

import androidx.lifecycle.MutableLiveData
import android.app.Application
import androidx.lifecycle.*
import com.lugares.data.LugarDatabase
import com.lugares.model.Lugar
import com.lugares.repository.LugarRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LugarViewModel(application: Application) : AndroidViewModel(application){
    //Lista que contiene objetis tipo lugar
    val getAllData : LiveData<List<Lugar>>
    private val repository: LugarRepository

    init{
        val lugarDao = LugarDatabase.getDatabase(application).lugarDao()
        //Inicializa repository
        repository = LugarRepository(lugarDao)
        getAllData = repository.getAllData
    }

    fun addLugar (lugar:Lugar){
        //Se crean las tareas de entrada y salida para cada funcion
        viewModelScope.launch (Dispatchers.IO){ repository.addLugar(lugar) }
    }

    fun updateLugar(lugar:Lugar){
        //Se crean las tareas de entrada y salida para cada funcion
        viewModelScope.launch (Dispatchers.IO){ repository.updateLugar(lugar) }
    }

    fun deleteLugar (lugar:Lugar){
        //Se crean las tareas de entrada y salida para cada funcion
        viewModelScope.launch (Dispatchers.IO){ repository.deleteLugar(lugar) }
    }

}