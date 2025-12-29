package database

import androidx.lifecycle.LiveData
import androidx.room.*
import entity.ComandaEntity

@Dao
interface ComandaDAO {
    @Query("SELECT * FROM comandas WHERE usuari = :usuari")
    fun obtenirOrdresUsuari(usuari: String): LiveData<List<ComandaEntity>>

    @Insert
    suspend fun insertarComanda(comanda: ComandaEntity): Long

    @Update
    suspend fun updateComanda(comanda: ComandaEntity)

    @Delete
    suspend fun deleteComanda(comanda: ComandaEntity)
}