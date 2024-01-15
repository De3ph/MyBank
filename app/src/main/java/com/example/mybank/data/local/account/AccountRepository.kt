package com.example.mybank.data.local.account

class AccountRepository(private val accountDao: AccountDao) {

    suspend fun getAll(): List<Account> {
        return accountDao.getAccounts()
    }

    suspend fun upsertOne(account: Account){
        return accountDao.insertOne(account)
    }

    suspend fun deleteOne(accountName: String){
        val isExist = accountDao.isExist(accountName)

        isExist.let {
            accountDao.deleteOne(it)
        }
    }

}