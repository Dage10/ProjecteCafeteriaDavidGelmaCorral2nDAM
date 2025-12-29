package database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import entity.ComandaProducteRelacioForeign
import entity.ComandaAProductes

@Dao
interface ComandaProducteDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(ref: ComandaProducteRelacioForeign)

    @Transaction
    @Query("SELECT * FROM comandas WHERE id = :comandaId")
    suspend fun getComandaAmbProductes(comandaId: Int): ComandaAProductes
}
