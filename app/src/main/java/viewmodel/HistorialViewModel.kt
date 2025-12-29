package viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import database.AppDatabase
import entity.ComandaEntity
import kotlinx.coroutines.launch
import repository.Repository

class HistorialViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: Repository

    init {
        val db = AppDatabase.getDatabase(application)
        repository = Repository(db.comandaDao(), db.producteDao(),db.comandaProducteDao())
    }

    fun getOrdresUsuari(usuari: String): LiveData<List<ComandaEntity>> = repository.getOrdresUsuari(usuari)

    fun deleteComanda(comanda: ComandaEntity) {
        viewModelScope.launch { repository.deleteComanda(comanda) }
    }

    fun updateComanda(comanda: ComandaEntity) {
        viewModelScope.launch { repository.updateComanda(comanda) }
    }
}