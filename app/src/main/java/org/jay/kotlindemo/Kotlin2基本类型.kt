package org.jay.kotlindemo

/**
 * Created by jay on 2017/9/12.
 */


class Kotlin2基本类型 {
    //基本类型


    fun main(args: Array<String>) {
        /**
         * 数字
         * Kotlin 处理数字在某种程度上接近 Java，但是并不完全相同。
         * 例如，对于数字没有隐式拓宽转换（如 Java 中 int 可以隐式转换为long——译者注)，
         * 另外有些情况的字面值略有不同。
         * Kotlin 提供了如下的内置类型来表示数字（与 Java 很相近）：
         * Type	Bit width
         * Double	64
         * Float	32
         * Long	64
         * Int	    32
         * Short	16
         * Byte	8
         * 注意在 Kotlin 中字符不是数字
         * 注意: 不支持八进制
         */

        //你可以使用下划线使数字常量更易读：
        val oneMillion = 1_000_000
        val creditCardNumber = 1234_5678_9012_3456L
        val socialSecurityNumber = 999_99_9999L
        val hexBytes = 0xFF_EC_DE_5E
        val bytes = 0b11010010_01101001_10010100_10010010


        //注意数字装箱不必保留同一性:
        val a: Int = 10000
        print(a === a) // 输出“true”
        val boxedA: Int? = a
        val anotherBoxedA: Int? = a
        print(boxedA === anotherBoxedA) // ！！！输出“false”！！！


        //另一方面，它保留了相等性:
        val a1: Int = 10000
        print(a == a) // 输出“true”
        val boxedA1: Int? = a
        val anotherBoxedA1: Int? = a
        print(boxedA1 == anotherBoxedA1) // 输出“true”


        //较小的类型不能隐式转换为较大的类型。
        //这意味着在不进行显式转换的情况下我们不能把 Byte 型值赋给一个 Int 变量。
        val b: Byte = 1 // OK, 字面值是静态检测的
        //val i: Int = b // 错误 Type mismatch.Required:IntFound:Byte
        //我们可以显式转换来拓宽数字
        val i2: Int = b.toInt() // OK: 显式拓宽


        //每个数字类型支持如下的转换:
        b.toByte()
        b.toShort()
        b.toInt()
        b.toLong()
        b.toFloat()
        b.toDouble()
        b.toChar()
        //缺乏隐式类型转换并不显著，因为类型会从上下文推断出来，而算术运算会有重载做适当转换，例如：
        val l = 1L + 3 // Long + Int => Long


        //对于位运算，没有特殊字符来表示，而只可用中缀方式调用命名函数，例如:
        val x = (1 shl (2)) and 0x000FF000
        //这是完整的位运算列表（只用于 Int 和 Long）：
        1 shl (2)//shl(bits) – 有符号左移 (Java 的 <<)
        1 shr (2)//shr(bits) – 有符号右移 (Java 的 >>)
        1 ushr (2)//ushr(bits) – 无符号右移 (Java 的 >>>)
        1 and 1//and(bits) – 位与
        1 or 1//or(bits) – 位或
        1 xor 1//xor(bits) – 位异或
        1.inv()  //() – 位非

        //浮点数比较
        //相等性检测：a == b 与 a != b
        //比较操作符：a < b、 a > b、 a <= b、 a >= b
        //区间实例以及区间检测：a..b、 x in a..b、 x !in a..b


        //Char
        //字符用 Char 类型表示。它们不能直接当作数字
        fun check(c: Char) {
            if (c.toInt() == 1) { // 错误：类型不兼容  Operator '==' cannot be applied to 'Char' and 'Int
                // ……
            }
        }
        //字符字面值用单引号括起来: '1'。 特殊字符可以用反斜杠转义。
        // 支持这几个转义序列：\t、 \b、\n、\r、\'、\"、\\ 和 \$。
        // 编码其他字符要用 Unicode 转义序列语法：'\uFF00'。
        //我们可以显式把字符转换为 Int 数字：
        fun decimalDigitValue(c: Char): Int {
            if (c !in '0'..'9')
                throw IllegalArgumentException("Out of range")
            return c.toInt() - '0'.toInt() // 显式转换为数字
        }

        //Boolean
        //布尔用 Boolean 类型表示，它有两个值：true 和 false。
        //若需要可空引用布尔会被装箱。
        //内置的布尔运算有：
        //|| – 短路逻辑或
        //&& – 短路逻辑与
        //! - 逻辑非

        //Array
        //我们可以使用库函数 arrayOf() 来创建一个数组并传递元素值给它， 这样 arrayOf(1, 2, 3) 创建了 array [1, 2, 3]。
        //或者，库函数 arrayOfNulls() 可以用于创建一个指定大小、元素都为空的数组。
        //另一个选项是用接受数组大小和一个函数参数的工厂函数，用作参数的函数能够返回 给定索引的每个元素初始值：
        val array = arrayOf(1, 2, 3)
        val array2 = arrayOfNulls<String>(3)
        val asc = Array(5, { i -> (i * i).toString() }) // 创建一个 Array<String> 初始化为 ["0", "1", "4", "9", "16"]
        //Kotlin 也有无装箱开销的专门的类来表示原生类型数组: ByteArray、 ShortArray、IntArray 等等。
        //这些类和 Array 并没有继承关系，但是它们有同样的方法属性集。它们也都有相应的工厂方法:
        val x1: IntArray = intArrayOf(1, 2, 3)
        val x2: IntArray = kotlin.IntArray(3)
        val x3: DoubleArray = kotlin.DoubleArray(4, { i -> (i * i).toDouble() })
        x1[0] = x1[1] + x1[2]


        //字符串
        //字符串用 String 类型表示。字符串是不可变的。 字符串的元素——字符可以使用索引运算符访问: s[i]。 可以用 for 循环迭代字符串:
        println("Hello"[1])
        for (c in "Hello World") {
            println(c)
        }
        //字符串字面值
        //Kotlin 有两种类型的字符串字面值: 转义字符串可以有转义字符，以及原生字符串可以包含换行和任意文本。转义字符串很像 Java 字符串:
        val s = "Hello, world!\n"
        //原生字符串 使用三个引号（"""）分界符括起来，内部没有转义并且可以包含换行和任何其他字符:
        val text = """
                for (c in "foo")
                    print(c)
                """
        //你可以通过 trimMargin() 函数去除前导空格：
        val text2 = """
                |Tell me and I forget.
                |Teach me and I remember.
                |Involve me and I learn.
                |(Benjamin Franklin)
                """.trimMargin("|")
        //默认 | 用作边界前缀，但你可以选择其他字符并作为参数传入，比如 trimMargin(">")。
        //字符串模板
        //字符串可以包含模板表达式 ，即一些小段代码，会求值并把结果合并到字符串中。
        //模板表达式以美元符（$）开头，由一个简单的名字构成:
        val i3 = 10
        val s1 = "i3 = $i3" // 求值结果为 "i = 10"
        //或者用花括号括起来的任意表达式:
        val s2 = "abc"
        val str = "$s.length is ${s.length}" // 求值结果为 "abc.length is 3"
        //原生字符串和转义字符串内部都支持模板。
        //如果你需要在原生字符串中表示字面值 $ 字符（它不支持反斜杠转义），你可以用下列语法：
        val price = """
            ${'$'}9.99
            """
    }


}