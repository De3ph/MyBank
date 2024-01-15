package com.example.mybank.data.local.expense

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.mybank.constant.AvailableCurrencies
import com.example.mybank.data.local.account.Account
import io.mcarle.konvert.api.KonvertTo
import io.mcarle.konvert.api.Mapping
import java.util.Date

@Entity(
    tableName = "expenses",
    foreignKeys = [
        ForeignKey(
            entity = Account::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("accountId"),
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
    ]
)
@KonvertTo(
    ExpenseDto::class,
    mappings = [
        Mapping(target = "id", source = "id", ignore = true)
    ]
)
class Expense(
    var title: String,
    var amount: Double,
    var currencyType: AvailableCurrencies,
    @ColumnInfo(index = true)
    var accountId: Int,
    var date: Date
) {
    @PrimaryKey(
        autoGenerate = true
    )
    var id: Int = 0
}