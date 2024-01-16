package com.example.mybank.data.local.expense

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface ExpenseDao {
    @Query("SELECT * FROM expenses WHERE accountId = :accountId ORDER BY date DESC LIMIT 30")
    suspend fun getAllByAccountId(accountId: Int): List<Expense>

    @Upsert
    suspend fun upsertOne(expense: Expense)

    @Delete
    suspend fun deleteOne(expense: Expense)

    @Query("SELECT * FROM expenses WHERE title = :title")
    suspend fun isExist(title: String): Expense
}