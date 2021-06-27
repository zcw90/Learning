package com.zcw.kotlin

import com.sun.javafx.geom.transform.BaseTransform
import java.io.File
import java.lang.ArithmeticException
import java.lang.IllegalArgumentException
import java.lang.IllegalStateException
import java.nio.file.Files
import java.nio.file.Paths

/**
 * Created by 朱城委 on 2020-6-21.<br><br>
 */
fun main() {
    foo()
    foo(12)
    foo(15, "AAAAA")

    val list = listOf(12, 3, -5, 4, -236)
    val positive = list.filter { it > 0 }
    for(value in positive) {
        println(value)
    }

    println("====================")
    val map = HashMap<String, Int>()
    map["aaa"] = 111
    map["bbb"] = 222
    map["ccc"] = 333
    map["ddd"] = 444
    for((key, value) in map) {
        println("key: $key, value: $value")
    }

    println("====================")
    for(i in 1 .. 10) {
        print("$i \t")
    }
    println()
    println("====================")
    for(i in 1 until 10) {
        print("$i \t")
    }
    println()

    println("====================")
    val p: String by lazy {
        println("Completed")
        "Hello"
    }
    println(p)
    println(p)

    println("====================")
    println("This is test statement".zcwAdd())

    println("====================")
    println(ZcwObject.name)

    println("====================")
    val files = File("Test").listFiles()
    println(files?.size)
    println(files?.size ?: "Empty")

    println("====================")
    val values = mapOf("aaa" to 20)
//    val email = values["email"] ?: throw IllegalStateException("Email is missing!")

    println("====================")
//    val emails = emptyList<String>()
    val emails = listOf("AAA")
    val mainEmail = emails.firstOrNull() ?: "Is null"
    println(mainEmail)

    println("====================")
    val nullTest = File("Test").listFiles()
    val notNull = "Not null"
    nullTest?.let {
        println(nullTest)
    }
    notNull?.let {
        println(notNull)
    }

    println("====================")
    fun transformValue(str: String?): String? {
        return str?.toUpperCase()
    }
    val value: String = "abcdefg"
    println(value?.let { transformValue(value) } ?: "Empty")
    println(value?.let { transformValue(null) } ?: "Empty")

    println("====================")
    println(transform("Red"))
    println(transform("Green"))
    println(transform("Blue"))

    println("====================")
    fun arrayOfMinusOnes(size: Int): IntArray {
        return IntArray(size).apply { fill(-1) }
    }
    val intArray = arrayOfMinusOnes(10)
    for(i in intArray) {
        print("$i \t")
    }
    println()

    println("====================")
    fun theAnswer() = 42
    println("The Answer is: ${theAnswer()}")

    println("====================")
    val myTurtle = Turtle()
    with(myTurtle) {
        penDown()
        for(i in 1 .. 4) {
            forward(100.0)
            turn(90.0)
        }
        penUp()
    }

    println("====================")
    val customerA = CustomerA().apply {
        test1 = 11
        test2 = 22
        test3 = 33
    }

    println("====================")
    val stream = Files.newInputStream(Paths.get("local.properties"))
    stream.buffered().reader().use {
        println(it.readText())
    }

    println("====================")
    var a = 1
    var b = 2
    println("a = $a, b = $b")
    a = b.also { b = a }
    println("a = $a, b = $b")
}

fun foo(a: Int = 0, b: String = "") {
    println("a is $a, b is $b")
}

fun String.zcwAdd(): String {
    return "$this zcw ADD"
}

/**
 * 创建单例
 */
object ZcwObject {
    val name = "ZcwObject"
}

fun transform(color: String): Int = when(color) {
        "Red" -> 0
        "Green" -> 1
        "Blue" -> 2
        else -> throw IllegalArgumentException("Invalid color param value")
    }

fun test() {
    val result = try {
        count()
    }
    catch (e: ArithmeticException) {

    }
}

fun count(): Int {
    throw ArithmeticException()
}

fun test2(param: Int) {
    val result = if(param == 1) {
        "one"
    }
    else if(param == 2) {
        "two"
    }
    else {
        "three"
    }
}

class Turtle {
    fun penDown() {

    }

    fun penUp() {

    }

    fun turn(degrees: Double) {

    }

    fun forward(pixels: Double) {

    }
}

class CustomerA {
    var test1: Int = 0
    var test2: Int = 0
    var test3: Int = 0
}