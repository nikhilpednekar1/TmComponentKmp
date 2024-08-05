package com.intellihealth.truemeds.tmcomponentkmp.utils

fun getDecimalAndFraction(number: Double): Pair<Int, Double> {
    val integerPart = number.toInt()
    val fractionalPart = number - integerPart
    return Pair(integerPart, fractionalPart)
}

fun getDecimalAndFraction(number:String) : Pair<String, String> {
    val parts = number.split(".")

    if (parts.size == 2) {
        val a = parts[0].toInt()
        val b = parts[1].toInt()

        return Pair(a.toString(),b.toString())

    } else {
        return Pair(number,"0")
    }
}