package com.example.mybank.data.local.expense

class ExpenseRepository(private val expenseDao: ExpenseDao) {

    suspend fun getExpenses(accountId: Int): List<Expense> {
        return expenseDao.getAllByAccountId(accountId)
    }

    suspend fun addExpense(expense: Expense){
        return expenseDao.upsertOne(expense)
    }
}