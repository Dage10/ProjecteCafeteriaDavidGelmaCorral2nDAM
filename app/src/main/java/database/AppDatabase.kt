package database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import entity.ComandaEntity
import entity.ProducteEntity
import kotlinx.coroutines.runBlocking
import java.util.concurrent.Executors

@Database(entities = [ComandaEntity::class, ProducteEntity::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun comandaDao(): ComandaDAO
    abstract fun producteDao(): ProducteDAO

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "cafeteria_db"
                ).fallbackToDestructiveMigration()
                .addCallback(object : Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        Executors.newSingleThreadExecutor().execute {
                            INSTANCE?.let { database ->
                                runBlocking {
                                    database.producteDao().insertAll(SeedProductes.llista())
                                }
                            }
                        }
                    }
                })
                .build()

                INSTANCE = instance

                instance
            }
        }
    }
}