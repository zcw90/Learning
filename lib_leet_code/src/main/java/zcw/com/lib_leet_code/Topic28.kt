package zcw.com.lib_leet_code

/**
 * Created by 朱城委 on 2020/6/5.<br><br>
 */
fun main() {
    var haystack = "hello"
    var needle = "ll"
    println(strStr(haystack, needle))

    haystack = "aaaaa"
    needle = "bba"
    println(strStr(haystack, needle))
}

private fun strStr(haystack: String, needle: String): Int {
    var i = 0
    var j = 0
    var count = 0

    if(needle.isEmpty()) {
        return 0
    }

    while(i < haystack.length && j < needle.length) {
        if(haystack[i] == needle[j]) {
            i++
            j++
            count++
        }
        else {
            i = i - count + 1
            j = 0
            count = 0
        }

        if(count == needle.length) {
            return i - count
        }
    }
    return -1
}

