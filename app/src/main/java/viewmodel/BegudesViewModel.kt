package viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import database.AppDatabase
import entity.ProducteEntity
import kotlinx.coroutines.launch
import repository.Repository

class BegudesViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: Repository

    val begudaProductes: LiveData<List<ProducteEntity>>

    init {
        val db = AppDatabase.getDatabase(application)
        repository = Repository(db.comandaDao(), db.producteDao())
        begudaProductes = repository.getProductesPerCategoria("beguda")
    }

    fun afegirProducte(producte: ProducteEntity) {
        viewModelScope.launch {
            repository.insertProducte(producte)
        }
    }
}
