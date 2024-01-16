package com.example.mybank.data.local.account

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface AccountDao {

    @Query("SELECT * FROM accounts ORDER BY name ASC")
    suspend fun getAccounts(): List<Account>

    @Upsert
    suspend fun insertOne(account: Account)

    @Upsert
    suspend fun insertMany(vararg account: Account)

    @Delete
    suspend fun deleteOne(account: Account)

    @Query("SELECT * FROM accounts WHERE name = :name")
    suspend fun isExist(name: String): Account

}