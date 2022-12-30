package com.example.newcryptocurrencyapp

fun main(args: Array<String>) {
    val str1 = "abcd 125 e77fg ABCD"
    val result = str1.filter { it.isDigit() }
    println("Filtered String  : " + result)
    chariterator()
}


fun chariterator(){
    var name = "helloWorld"
    for (ch in name.iterator())
    {
        println("loop String  : " + ch)

    }
}