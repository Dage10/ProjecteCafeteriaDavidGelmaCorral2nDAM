package entity

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class ComandaAProductes(
    @Embedded val comanda: ComandaEntity,

    @Relation(
        parentColumn = "id",
        entityColumn = "id",
        associateBy = Junction(
            value = ComandaProducteRelacioForeign::class,
            parentColumn = "comandaId",
            entityColumn = "producteId"
        )
    )
    val productes: List<ProducteEntity>
)