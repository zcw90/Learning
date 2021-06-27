package com.zcw.kotlin

/**
 * Created by 朱城委 on 2020-6-21.<br><br>
 */

fun main() {
    val rectangle = Rectangle(5.0, 2.0)
    val triangle = Triangle(3.0, 4.0, 5.0)
    println("Area of rectangle is ${rectangle.calculateArea()}, its perimeter is ${rectangle.perimeter}")
    println("Area of triangle is ${triangle.calculateArea()}, its perimeter is ${triangle.perimeter}")
}

abstract class Shape(val sides: List<Double>) {
    val perimeter: Double get() = sides.sum()
    abstract fun calculateArea(): Double
}

interface RectangleProperties {
    val isSquare: Boolean
}

private class Rectangle(var height: Double, var length: Double): Shape(listOf(height, length, height, length)), RectangleProperties {
    override fun calculateArea(): Double = height * length

    override val isSquare: Boolean
        get() = height == length
}

class Triangle(var sideA: Double, var sideB: Double, var sideC: Double): Shape(listOf(sideA, sideB, sideC)) {
    override fun calculateArea(): Double {
        val s = perimeter / 2
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC))
    }
}