package entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "comandas")
data class ComandaEntity (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val usuari: String,
    val total: Double,
    val timestamp: Long = System.currentTimeMillis()
)

