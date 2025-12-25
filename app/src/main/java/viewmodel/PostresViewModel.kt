package viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import database.AppDatabase
import entity.ProducteEntity
import kotlinx.coroutines.launch
import repository.Repository

class PostresViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: Repository

    val postresProductes: LiveData<List<ProducteEntity>>

    init {
        val db = AppDatabase.getDatabase(application)
        repository = Repository(db.comandaDao(), db.producteDao())
        postresProductes = repository.getProductesPerCategoria("postres")
    }

    fun afegirProducte(producte: ProducteEntity) {
        viewModelScope.launch {
            repository.insertProducte(producte)
        }
    }
}
