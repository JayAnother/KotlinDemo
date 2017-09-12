package org.jay.kotlindemo

/**
 * Created by jay on 2017/9/12.
 */
class Kotlin3 {
    //控制流：if、when、for、while
    fun main(args: Array<String>) {

        //If 表达式
        //在 Kotlin 中，if是一个表达式，即它会返回一个值。
        //因此就不需要三元运算符（条件 ? 然后 : 否则），因为普通的 if 就能胜任这个角色。
        // 传统用法
        var a:Int=1
        var b:Int=2
        var max = a
        if (a < b) max = b

        // With else
        var max2: Int
        if (a > b) {
            max = a
        } else {
            max = b
        }
        // 作为表达式
        val max3 = if (a > b) a else b

        //if的分支可以是代码块，最后的表达式作为该块的值：
        val max4 = if (a > b) {
            print("Choose a")
            a
        } else {
            print("Choose b")
            b
        }
        //如果你使用 if 作为表达式而不是语句（例如：返回它的值或者把它赋给变量），该表达式需要有 else 分支。


        //When 表达式
        /**
         * when 将它的参数和所有的分支条件顺序比较，直到某个分支满足条件。
         * when 既可以被当做表达式使用也可以被当做语句使用。
         * 如果它被当做表达式， 符合条件的分支的值就是整个表达式的值，
         * 如果当做语句使用， 则忽略个别分支的值。（像 if 一样，每一个分支可以是一个代码块，它的值是块中最后的表达式的值。）
         *
         * 如果其他分支都不满足条件将会求值 else 分支。
         * 如果 when 作为一个表达式使用，则必须有 else 分支， 除非编译器能够检测出所有的可能情况都已经覆盖了。
         */
        // when 取代了类 C 语言的 switch 操作符。其最简单的形式如下：
        var x:Int=3
        when (x) {
            1 -> print("x == 1")
            2 -> print("x == 2")
            else -> { // 注意这个块
                print("x is neither 1 nor 2")
            }
        }
        //如果很多分支需要用相同的方式处理，则可以把多个分支条件放在一起，用逗号分隔：
        when (x) {
            0, 1 -> print("x == 0 or x == 1")
            else -> print("otherwise")
        }
        //我们可以用任意表达式（而不只是常量）作为分支条件
        fun parseInt(s:String) :Int{
            return s.toInt()
        }
        when (x) {
            parseInt("1") -> print("s encodes x")
            else -> print("s does not encode x")
        }
        //我们也可以检测一个值在（in）或者不在（!in）一个区间或者集合中：
        when (x) {
            in 1..10 -> print("x is in the range")
            in arrayOf(1,2,3) -> print("x is valid")
            !in 10..20 -> print("x is outside the range")
            else -> print("none of the above")
        }
        //另一种可能性是检测一个值是（is）或者不是（!is）一个特定类型的值。
        //注意： 由于智能转换，你可以访问该类型的方法和属性而无需任何额外的检测。
        fun hasPrefix(x: Any) = when(x) {
            is String -> x.startsWith("prefix")
            else -> false
        }
        //when 也可以用来取代 if-else if链。
        // 如果不提供参数，所有的分支条件都是简单的布尔表达式，而当一个分支的条件为真时则执行该分支：
        when {
            x.equals(2) -> print("x is odd")
            x.equals(3) -> print("x is even")
            else -> print("x is funny")
        }



        //For 循环
        //for 循环可以对任何提供迭代器（iterator）的对象进行遍历，这相当于像 C# 这样的语言中的 foreach 循环。语法如下：
        var array:Array<Int> = arrayOf(1,2,3)
        for (item in arrayOf(1,2,3)){
            print(item)
        }
        //循环体可以是一个代码块。
        for (item: Int in array) {
            // ……
        }
        //如果你想要通过索引遍历一个数组或者一个 list，你可以这么做：
        for (i in array.indices) {
            print(array[i])
        }
        //或者你可以用库函数 withIndex：
        for ((index, value) in array.withIndex()) {
            println("the element at $index is $value")
        }


        //While 循环
        //while 和 do..while 照常使用
        while (x > 0) {
            x--
        }

        fun retrieveData(): Any {
            return 1
        }
        do {
            val y = retrieveData()
        } while (y != null) // y 在此处可见
    }


}