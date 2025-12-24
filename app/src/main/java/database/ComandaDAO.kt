package database

import androidx.lifecycle.LiveData
import androidx.room.*
import entity.ComandaEntity

@Dao
interface ComandaDAO {
    @Query("SELECT * FROM comandas WHERE usuari = :usuari")
    fun obtenirOrdresUsuari(usuari: String): LiveData<List<ComandaEntity>>

    @Insert
    suspend fun insertarComanda(comanda: ComandaEntity)

    @Update
    suspend fun updateOrder(comanda: ComandaEntity)

    @Delete
    suspend fun deleteOrder(comanda: ComandaEntity)
}