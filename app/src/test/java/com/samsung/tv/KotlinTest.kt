package com.samsung.tv

import org.junit.Assert
import org.junit.Test
import java.io.File
import java.time.LocalDate

fun max(a: Int, b: Int) = if (a > b) a else b

class KotlinTest {
    @Test
    fun testMax() {
        Assert.assertTrue(max(1, 2) == 2)
    }

    @Test
    fun testFindHiddenDirWithSequence() {
        fun File.isInsideHiddenDirectory() =
            generateSequence(this) {
                 it.parentFile
            }.any {
                println(it.toString() + " : " + it.isHidden)
                it.isHidden
            }

        val file = File("C:\\Users\\yhyun\\Downloads\\love-affair.gp4")
        println(file.isInsideHiddenDirectory())
    }

    @Test
    fun testLocalDateWithClosedRangeAndIterator() {
        operator fun ClosedRange<LocalDate>.iterator(): Iterator<LocalDate> =
                object: Iterator<LocalDate> {
                    var current = start
                    override fun hasNext() =
                            current <= endInclusive
                    override fun next() = current.apply {
                        current = plusDays(1)
                    }
                }

        val newYear = LocalDate.ofYearDay(2018, 1)
        val daysOff = newYear.minusDays(1)..newYear
        for (dayOff in daysOff) println(dayOff)
    }
}
