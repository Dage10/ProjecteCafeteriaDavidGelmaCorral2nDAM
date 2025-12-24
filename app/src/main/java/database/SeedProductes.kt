package database

import entity.ProducteEntity

object SeedProductes {
    fun llista() = listOf(
        ProducteEntity(nom = "Sandwitx", preu = 1.5, categoria = "menjar"),
        ProducteEntity(nom = "Croissant", preu = 3.0, categoria = "menjar"),
        ProducteEntity(nom = "Aigua", preu = 1.0, categoria = "beguda"),
        ProducteEntity(nom = "Cafe", preu = 1.2, categoria = "beguda"),
        ProducteEntity(nom = "Pastis", preu = 2.5, categoria = "postres")
    )
}