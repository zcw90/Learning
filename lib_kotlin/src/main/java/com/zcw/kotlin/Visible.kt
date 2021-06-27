package com.zcw.kotlin

/**
 * Created by 朱城委 on 2020-6-21.<br><br>
 */
open class Outer {
    private val a = 1
    protected open val b = 2
    internal val c = 3
    val d = 4

    protected class Nested {
        public val e: Int = 5
    }
}

class Subclass : Outer() {

}

class C private constructor(a: Int) {

}