package repository

import androidx.lifecycle.LiveData
import database.ComandaDAO
import database.ProducteDAO
import entity.ComandaEntity
import entity.ProducteEntity

class Repository(private val comandaDao: ComandaDAO,
                 private val producteDao: ProducteDAO) {

    fun getOrdresUsuari(usuari: String): LiveData<List<ComandaEntity>> =
        comandaDao.obtenirOrdresUsuari(usuari)

    suspend fun insertComanda(comanda: ComandaEntity) = comandaDao.insertarComanda(comanda)
    suspend fun updateComanda(comanda: ComandaEntity) = comandaDao.updateComanda(comanda)
    suspend fun deleteComanda(comanda: ComandaEntity) = comandaDao.deleteComanda(comanda)

    fun getProductesPerCategoria(categoria: String): LiveData<List<ProducteEntity>> =
        producteDao.getProductesCategoria(categoria)

    suspend fun insertProducte(producte: ProducteEntity) = producteDao.insertarProducte(producte)
    suspend fun deleteProducte(producte: ProducteEntity) = producteDao.eliminarProduct(producte)
}
