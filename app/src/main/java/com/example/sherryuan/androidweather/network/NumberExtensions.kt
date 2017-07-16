package com.example.sherryuan.androidweather.network

/**
 * Extension function for formatting the number of decimals in a Double
 *
 * @param digits   number of decimals you want to keep
 * @return the formatted Double
 */
fun Double.format(digits: Int) = java.lang.String.format("%.${digits}f", this)
