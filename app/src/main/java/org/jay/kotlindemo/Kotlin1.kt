package org.jay.kotlindemo

/**
 * Created by jay on 2017/9/8.
 */
open class Kotlin1 {
    /**
     *Hello Kotlin
     */
    fun main(args: Array<String>){
        print("Hello World"+Math.abs(12))
    }

    /**
     * 定义一个函数接受两个 int 型参数，返回值为 int
     */
    fun sum(a:Int,b:Int):Int{
        return a+b
    }
    /**
     * 将表达式作为函数体、返回值类型自动推断的函数：
     */
    fun sum1(a:Int,b:Int)=a+b
    /**
     * 函数返回无意义的值：
     * Unit 返回类型可以省略：
     */
    fun sum2(a:Int,b:Int):Unit{
        print("sum of $a and $b is $(a+b) ")
    }


    /**
     * 变量:
     */

    fun main1(args: Array<String>) {
        val a: Int = 1  // 立即赋值
        val b = 2   // 自动推断出 `Int`
        val c: Int  // 如果没有初始值类型不能省略
        c = 3       // 明确赋值
        println("a = $a, b = $b, c = $c")

        var x = 5 // 自动推断出 `Int` 类型
        x += 1
        println("x = $x")
    }

    /**
     * 使用字符串模板:
     *
     */
    fun main2(args: Array<String>) {
        var a = 1
        // 模板中的简单名称：
        val s1 = "a is $a"

        a = 2
        // 模板中的任意表达式：
        val s2 = "${s1.replace("is", "was")}, but now is $a"
        println(s2)
    }
    /**
     * 使用条件表达式:
     */

    fun maxOf(a: Int, b: Int): Int {
        if (a > b) {
            return a
        } else {
            return b
        }
    }
    fun maxOf2(a: Int, b: Int) = if (a > b) a else b

    /**
     * 使用返回可空值的函数:
     */
    fun parseInt(str: String): Int? {
        return str.toIntOrNull()
    }

    fun printProduct(arg1: String, arg2: String) {
        val x = parseInt(arg1)
        val y = parseInt(arg2)

        // 直接使用 `x * y` 可能会报错，因为他们可能为 null
        if (x != null && y != null) {
            // 在空检测后，x 和 y 会自动转换为非空值（non-nullable）
            println(x * y)
        }
        else {
            println("either '$arg1' or '$arg2' is not a number")
        }
    }


    fun printProduct2(arg1: String, arg2: String) {
        val x = parseInt(arg1)
        val y = parseInt(arg2)

        // ……
        if (x == null) {
            println("Wrong number format in arg1: '${arg1}'")
            return
        }
        if (y == null) {
            println("Wrong number format in arg2: '${arg2}'")
            return
        }

        // 在空检测后，x 和 y 会自动转换为非空值
        println(x * y)
    }

    /**
     * is 运算符检测一个表达式是否某类型的一个实例。
     * 如果一个不可变的局部变量或属性已经判断出为某类型，
     * 那么检测后的分支中可以直接当作该类型使用，无需显式转换：
     */
    fun getStringLength(obj: Any): Int? {
        if (obj is String) {
            // `obj` 在该条件分支内自动转换成 `String`
            return obj.length
        }

        // 在离开类型检测分支后，`obj` 仍然是 `Any` 类型
        return null
    }
    fun getStringLength2(obj: Any): Int? {
        if (obj !is String) return null

        // `obj` 在这一分支自动转换为 `String`
        return obj.length
    }
    fun getStringLength3(obj: Any): Int? {
        // `obj` 在 `&&` 右边自动转换成 `String` 类型
        if (obj is String && obj.length > 0) {
            return obj.length
        }

        return null
    }

    /**
     * 循环
     */
    fun main3(args: Array<String>) {
        val items = listOf("apple", "banana", "kiwi")
        for (item in items) {
            println(item)
        }

        for (index in items.indices) {
            println("item at $index is ${items[index]}")
        }

        var index = 0
        while (index < items.size) {
            println("item at $index is ${items[index]}")
            index++
        }
    }

    /**
     * when 表达式
     */
    fun describe(obj: Any): String =
            when (obj) {
                1          -> "One"
                "Hello"    -> "Greeting"
                is Long    -> "Long"
                !is String -> "Not a string"
                else       -> "Unknown"
            }

    /**
     * 使用区间（range）使用 in 运算符来检测某个数字是否在指定区间内：
     */
    fun main4(args: Array<String>) {
        val x = 10
        val y = 9
        if (x in 1..y+1) {
            println("fits in range")
        }
        //
        val list = listOf("a", "b", "c")

        if (-1 !in 0..list.lastIndex) {
            println("-1 is out of range")
        }
        if (list.size !in list.indices) {
            println("list size is out of valid list indices range too")
        }

        //
        for (x in 1..5) {
            print(x)
        }
        //
        for (x in 1..10 step 2) {  //1-10 mei ge liang ge
            print(x)
        }
        for (x in 9 downTo 0 step 3) { // 9-0 mei ge san ge
            print(x)
        }
    }

    /**
     * 集合
     */
    fun main5(args: Array<String>) {
        val items = listOf("apple", "banana", "kiwi")
        //对集合进行迭代:
        for (item in items) {
            println(item)
        }
        //使用 in 运算符来判断集合内是否包含某实例：
        when {
            "orange" in items -> println("juicy")
            "apple" in items -> println("apple is fine too")
        }
        //使用 lambda 表达式来过滤（filter）和映射（map）集合：
        items
                .filter { it.startsWith("a") }
                .sortedBy { it }
                .map { it.toUpperCase() }
                .forEach { println(it) }
    }
}