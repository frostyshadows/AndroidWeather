package com.example.sherryuan.androidweather

import java.lang.String

/**
 * Extension function for formatting the number of decimals in a Double
 *
 * @param digits   number of decimals you want to keep
 * @return the formatted Double
 */
fun Double.format(digits: Int) = String.format("%.${digits}f", this)
