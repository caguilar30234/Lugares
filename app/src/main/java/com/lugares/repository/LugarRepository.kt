package com.lugares.repository

import androidx.lifecycle.LiveData
import com.lugares.data.LugarDao
import com.lugares.model.Lugar

class LugarRepository(private val lugarDao: LugarDao){
    val getAllData: LiveData<List<Lugar>> = lugarDao.getAllData()
    //Metodos de LugarDao en capoa superior
    suspend fun addLugar(lugar: Lugar){
        lugarDao.addLugar(lugar)
    }
//llamada asincronica a las clases de LugarDao
    suspend fun updateLugar(lugar: Lugar){
        lugarDao.updateLugar(lugar)
    }

    suspend fun deleteLugar(lugar: Lugar){
        lugarDao.deleteLugar(lugar)
    }
}