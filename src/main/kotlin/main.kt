package ru.netology

const val MasterCard = 1
const val Maestro = 2
const val Visa = 3
const val Mir = 4
const val VK_pay = 5
const val limitDayVK = 15_000
const val limitDayCard = 150_000
const val limitMonthCard = 600_000
const val limitMonthVK = 40_000

fun main() {
    val sumTransfer = 25_054
    val typeCard = 2
    val amount = 270_000
    val commission = transfer(typeCard, amount, sumTransfer)
    if (commission == "-1") println("Перевод не выполнен, превышены лимиты!")
    else {
        println("Коммисия за перевод составила $commission руб.")
    }
}

fun transfer(Card: Int = VK_pay, amountAll: Int = 0, sum: Int): String {
    var success = true
    var commission = 0.0
    when (Card) {
        VK_pay -> {
            if (!checkLimitVK(sum, amountAll)) success = false
        }

        MasterCard, Maestro -> {
            if (checkLimitCard(sum, amountAll)) {
                if ((sum + amountAll) > 75_000) commission = sum * 0.006 + 20
            } else success = false
        }

        Visa, Mir -> {
            if (checkLimitCard(sum, amountAll)) {
                commission = sum * 0.0075
                if (commission < 35) commission = 35.0
            } else success = false
        }

        else -> {
            if (!checkLimitVK(sum, amountAll)) success = false
        }
    }
    val strValue: String = if (!success) {
        "-1"
    } else {
        //commission.toString()
        String.format("%.2f", commission)
    }
    return strValue.replace(',', '.')
}

fun checkLimitCard(sum: Int, amount: Int): Boolean {
    return when {
        (sum <= limitDayCard) && (sum + amount <= limitMonthCard) -> true
        else -> false
    }
}

fun checkLimitVK(sum: Int, amount: Int): Boolean {
    return when {
        (sum <= limitDayVK) && (sum + amount <= limitMonthVK) -> true
        else -> false
    }
}