package viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import database.AppDatabase
import entity.ComandaEntity
import kotlinx.coroutines.launch
import repository.Repository

class PagamentViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: Repository

    init {
        val db = AppDatabase.getDatabase(application)
        repository = Repository(db.comandaDao(), db.producteDao(),db.comandaProducteDao())
    }

    fun pagar(usuari: String, total: Double, productes: List<entity.ProducteEntity>) {
        viewModelScope.launch {
            repository.insertComandaAmbProductes(ComandaEntity(usuari = usuari, total = total), productes)
        }
    }
}