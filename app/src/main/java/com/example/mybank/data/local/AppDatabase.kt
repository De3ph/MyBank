package com.example.mybank.data.local

import android.content.Context
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.mybank.data.local.account.Account
import com.example.mybank.data.local.account.AccountDao
import com.example.mybank.data.local.expense.Expense
import com.example.mybank.data.local.expense.ExpenseDao
import com.example.mybank.data.local.utils.DateConverter

@Database(
    entities = [Account::class, Expense::class],
    version = 2,
    autoMigrations = [
        AutoMigration(1,2)
                     ],
    exportSchema = true
)
@TypeConverters(
    DateConverter::class
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun accountDao(): AccountDao
    abstract fun expenseDao(): ExpenseDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): AppDatabase {
            val DATABASE_NAME = "app-db"
            val db = Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
                .allowMainThreadQueries()
                .addCallback(object : Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                    }
                })
                .build()

            return db
        }
    }
}