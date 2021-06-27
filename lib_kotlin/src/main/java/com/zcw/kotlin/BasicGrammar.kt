package com.zcw.kotlin

/**
 * Created by 朱城委 on 2020-6-21.<br><br>
 */

val PI = 3.14
var x = 0

fun main() {
    println("Hel|lo world")

    print("sum of 3 and 5 is ")
    println(sum(3, 5))

    println("sum of 19 and 23 is ${sum2(19, 23)}")

    printSum(-1, 8)

    printSum2(11, 22)

    val a: Int = 1
    val b = 2
    val c: Int
    c = 3
    println("a=$a, b=$b, c=$c")

    var x = 5
    x += 1
    println("x=$x")

    println("x=$x, PI=$PI")
    incrementX()
    println("incrementX()")
    println("x=$x, PI=$PI")

    var a1 = 1
    val s1 = "a1 is $a1"
    a1 = 2
    val s2 = "${s1.replace("is", "was")}, but now is $a1"
    println(s2)

    println("max of 0 and 42 is ${maxOf(0, 42)}")
    println("max of 0 and -10 is ${maxOf2(0, -10)}")

    printProduct("6", "7")
    printProduct("a", "7")
    printProduct("a", "b")

    printProduct2("6", "7")
    printProduct2("a", "7")
    printProduct2("99", "b")

    fun printLength(obj: Any) {
        println("'$obj' string length is ${getStringLength(obj) ?: "... err, not a string"}")
    }
    printLength("Incomprehensibilities")
    printLength(100)
    printLength(listOf(Any()))

    fun printLength2(obj: Any) {
        println("'$obj' string length is ${getStringLength2(obj) ?: "... err, not a string"}")
    }
    printLength2("Incomprehensibilities")
    printLength2(100)
    printLength2(listOf(Any()))

    fun printLength3(obj: Any) {
        println("'$obj' string length is ${getStringLength3(obj) ?: "... err, not a string"}")
    }
    printLength3("Incomprehensibilities")
    printLength3(100)
    printLength3(listOf(Any()))

    println("====================")
    val items = listOf("apple", "banana", "kiwifruit")
    for(item in items) {
        println(item)
    }
    for(index in items.indices) {
        println("item at $index is ${items[index]}")
    }
    var index = 0
    while (index < items.size) {
        println("item at $index is ${items[index]}")
        index++
    }
    when {
        "orange" in items -> println("juicy")
        "apple" in items -> println("apple is fine too")
    }

    println("====================")
    println(describe(1))
    println(describe("Hello"))
    println(describe(1000L))
    println(describe(2))
    println(describe("other"))

    println("====================")
    val x2 = 10
    val y2 = 9
    if(x2 in 1 .. y2 + 1) {
        println("fits in range")
    }

    println("====================")
    val list = listOf("a", "b", "c")
    if(-1 !in 0 .. list.lastIndex) {
        println("-1 is out of range")
    }
    if(list.size !in list.indices) {
        println("list size is out of valid list indices range, too")
    }

    println("====================")
    for(x in 1 .. 5) {
        print(x)
    }
    println()

    println("====================")
    for(x in 1 .. 10 step 2) {
        print(x)
    }
    println()
    for(x in 9 downTo 0 step 3) {
        print(x)
    }
    println()

    println("====================")
    val fruits = listOf("banana", "avocado", "apple", "kiwifruit")
    fruits.filter { it.startsWith("a") }
            .sortedBy { it }
            .map { it.toUpperCase() }
            .forEach { println(it) }
}

fun sum(a: Int, b: Int): Int {
    return a + b
}

fun sum2(a: Int, b: Int) = a + b

fun printSum(a: Int, b: Int): Unit {
    println("sum of $a and $b is ${a + b}")
}

fun printSum2(a: Int, b: Int) {
    println("sum of $a and $b is ${a + b}")
}

fun incrementX() {
    x += 1
}

fun maxOf(a: Int, b: Int): Int {
    if(a > b) {
        return a
    }
    else {
        return b
    }
}

fun maxOf2(a: Int, b: Int) = if(a > b) a else b

fun parseInt(str: String): Int? {
    return str.toIntOrNull()
}

fun printProduct(arg1: String, arg2: String) {
    val x = parseInt(arg1)
    val y = parseInt(arg2)

    if(x != null && y != null) {
        println(x * y)
    }
    else {
        println("'$arg1' or '$arg2' is not a number")
    }
}

fun printProduct2(arg1: String, arg2: String) {
    val x = parseInt(arg1)
    val y = parseInt(arg2)

    if(x == null) {
        println("Wrong number format in arg1: '$arg1'")
        return
    }

    if(y == null) {
        println("Wrong number format in arg2: '$arg2'")
        return
    }

    println(x * y)
}

fun getStringLength(obj: Any): Int? {
    if(obj is String) {
        return obj.length
    }

    return null
}

fun getStringLength2(obj: Any): Int? {
    if(obj !is String) {
        return null
    }

    return obj.length
}

fun getStringLength3(obj: Any): Int? {
    if(obj is String && obj.length > 0) {
        return obj.length
    }

    return null
}

fun describe(obj: Any): String =
        when (obj) {
            1 -> "one"
            "Hello" -> "Greeting"
            is Long -> "Long"
            !is String -> "Not a string"
            else -> "Unknown"
        }
