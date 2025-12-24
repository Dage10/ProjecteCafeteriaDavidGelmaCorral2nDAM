package viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import database.AppDatabase
import entity.ProducteEntity
import kotlinx.coroutines.launch
import repository.Repository

class MenjarViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: Repository

    val menjarProductes: LiveData<List<ProducteEntity>>

    init {
        val db = AppDatabase.getDatabase(application)
        repository = Repository(db.comandaDao(), db.producteDao())
        menjarProductes = repository.getProductesPerCategoria("menjar")
    }

    fun afegirProducte(producte: ProducteEntity) {
        viewModelScope.launch {
            repository.insertProduct(producte)
        }
    }
}
