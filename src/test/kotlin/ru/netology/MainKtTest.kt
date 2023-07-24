package ru.netology

import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun transferMir() {
        val sumTransfer = 25_000
        val typeCard = 4                // type card MIR, Visa
        val amount = 270_000

        val result = transfer(
            Card = typeCard,
            amountAll = amount,
            sum = sumTransfer
        )
        assertEquals("187.50", result)
    }

    @Test
    fun transferMirMinCom() {
        val sumTransfer = 2_000
        val typeCard = 4                // type card MIR, Visa
        val amount = 270_000

        val result = transfer(
            Card = typeCard,
            amountAll = amount,
            sum = sumTransfer
        )
        assertEquals("35.00", result)
    }

    @Test
    fun transferMirOutLimit() {
        val sumTransfer = 225_000
        val typeCard = 4                // type card MIR, Visa
        val amount = 270_000

        val result = transfer(
            Card = typeCard,
            amountAll = amount,
            sum = sumTransfer
        )
        assertEquals("-1", result)
    }

    @Test
    fun transferMaster() {
        val sumTransfer = 85_000
        val typeCard = 1                // type card Master, Maestro
        val amount = 270_000

        val result = transfer(
            Card = typeCard,
            amountAll = amount,
            sum = sumTransfer
        )
        assertEquals("530.00", result)
    }

    @Test
    fun transferMasterZeroCom() {
        val sumTransfer = 50_000
        val typeCard = 1                // type card Master, Maestro
        val amount = 10_000

        val result = transfer(
            Card = typeCard,
            amountAll = amount,
            sum = sumTransfer
        )
        assertEquals("0.00", result)
    }

    @Test
    fun transferMasterOutLimit() {
        val sumTransfer = 85_000
        val typeCard = 1                // type card Master, Maestro
        val amount = 550_000

        val result = transfer(
            Card = typeCard,
            amountAll = amount,
            sum = sumTransfer
        )
        assertEquals("-1", result)
    }

    @Test
    fun transferVK() {
        val sumTransfer = 15_000
        val typeCard = 5                // type card VK
        val amount = 25_000

        val result = transfer(
            Card = typeCard,
            amountAll = amount,
            sum = sumTransfer
        )
        assertEquals("0.00", result)
    }

    @Test
    fun transferVKOutLimit() {
        val sumTransfer = 25_000
        val typeCard = 5                // type card VK
        val amount = 25_000

        val result = transfer(
            Card = typeCard,
            amountAll = amount,
            sum = sumTransfer
        )
        assertEquals("-1", result)
    }

    @Test
    fun transferDefaultOutLimit() {
        val sumTransfer = 5_000
        val typeCard = 6                // type card Default VK
        val amount = 40_000

        val result = transfer(
            Card = typeCard,
            amountAll = amount,
            sum = sumTransfer
        )
        assertEquals("-1", result)
    }

    @Test
    fun transferDefault() {
        val sumTransfer = 15_000
        val typeCard = 6                // type card Default VK
        val amount = 25_000

        val result = transfer(
            Card = typeCard,
            amountAll = amount,
            sum = sumTransfer
        )
        assertEquals("0.00", result)
    }

    @Test
    fun transferDefaultOutLimit2() {
        val sumTransfer = 25_000
        val amount = 55_000

        val result = transfer(
            amountAll = amount,
            sum = sumTransfer
        )
        assertEquals("-1", result)
    }
}