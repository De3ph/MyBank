package com.example.mybank.data.local.account

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.mybank.constant.AvailableCurrencies
import io.mcarle.konvert.api.KonvertTo
import io.mcarle.konvert.api.Mapping

@Entity(
    tableName = "accounts",
    indices = [
        Index(value = ["name"], unique = true)
    ]
)
@KonvertTo(
    AccountDto::class, mappings = [
        Mapping(source = "name", target = "name"),
        Mapping(
            source = "iban", target = "iban"
        ),
        Mapping(
            source = "balance", target = "balance"
        ),
        Mapping(source = "currencyType", target = "currencyType"),
        Mapping(source = "id", target = "id")
    ]
)
class Account(
    var name: String,
    var iban: String,
    var balance: Double,
    var currencyType: AvailableCurrencies
) {
    @PrimaryKey(
        autoGenerate = true
    )
    var id: Int = 0
}