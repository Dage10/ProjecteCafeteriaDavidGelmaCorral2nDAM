package database
import androidx.lifecycle.LiveData
import androidx.room.*
import entity.ProducteEntity

@Dao
interface ProducteDAO {
    @Query("SELECT * FROM productes WHERE categoria = :categoria")
    fun getProductesCategoria(categoria: String): LiveData<List<ProducteEntity>>

    @Insert
    suspend fun insertarProducte(producte: ProducteEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(items: List<ProducteEntity>)

    @Delete
    suspend fun eliminarProduct(producte: ProducteEntity)

    @Query("SELECT COUNT(*) FROM productes")
    suspend fun comptaProductes(): Int
}