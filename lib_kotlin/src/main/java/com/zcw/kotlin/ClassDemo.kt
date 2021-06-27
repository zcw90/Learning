package com.zcw.kotlin

import javafx.scene.Parent

/**
 * Created by 朱城委 on 2020-6-21.<br><br>
 */
class InitOrderDemo(name: String) {
    val firstProperty = "Fist property: $name".also(::println)

    init {
        println("First initializer block that prints $name")
    }

    val secondProperty = "Second property: ${name.length}".also(::println)

    init {
        println("Second initializer block that prints ${name.length}")
    }
}

class Person(val name: String) {
    val children: MutableList<Person> = mutableListOf()

    constructor(name: String, parent: Person) : this(name) {
        parent.children.add(this)
    }
}

open class ShapeA {
    open fun draw() {

    }

    fun fill() {

    }
}

class Circle : ShapeA() {
    override fun draw() {
        super.draw()
    }
}

open class RectangleA {
    open fun draw() {
        println("Drawing a rectangle")
    }

    val borderColor: String get() = "black"
}

interface Polygon {
    fun draw()
}

class FilledRectangle : RectangleA(), Polygon {
    override fun draw() {
        super.draw()
        println("Filling the rectangle")
    }

    val fillColor: String get() = super.borderColor

    inner class Filler {
        fun fill() {

        }

        fun drawAndFill() {
            super@FilledRectangle.draw()
        }
    }
}

class MyString(str: String) {

    init {
        println(str)
    }
}

fun main() {
    InitOrderDemo("Hello")
}