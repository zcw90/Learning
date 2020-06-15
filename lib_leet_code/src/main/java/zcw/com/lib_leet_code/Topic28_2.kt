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

    haystack = "mississippi"
    needle = "issip"
    println(strStr(haystack, needle))
}

private fun strStr(haystack: String, needle: String): Int {
    var j = 0

    if(needle.isEmpty()) {
        return 0
    }

    val failureArray = getFailureArray(needle)

    for(i in haystack.indices) {
        while(j > 0 && haystack[i] != needle[j]) {
            j = failureArray[j - 1]
        }

        if(haystack[i] == needle[j]) {
            j++
        }

        if(j == needle.length) {
            return i - j + 1
        }
    }

    return -1
}

private fun getFailureArray(str: String): IntArray {
    val failureArray = IntArray(str.length)
    failureArray[0] = 0

    var t = 0
    var s:Int
    for(s in 1 until  str.length) {
        while(t > 0 && str[t] != str[s]) {
            t = failureArray[t - 1]
        }

        if(str[t] == str[s]) {
            t++
            failureArray[s] = t
        }
        else {
            failureArray[s] = 0
        }
    }

    return failureArray
}

