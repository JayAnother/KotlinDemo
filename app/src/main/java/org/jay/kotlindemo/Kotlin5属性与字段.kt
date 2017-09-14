package org.jay.kotlindemo

import android.util.Log
import javax.inject.Inject

/**
 * Created by jay on 2017/9/13.
 */
class Kotlin5属性与字段 {
    //声明属性
    //Kotlin的类可以有属性。 属性可以用关键字var 声明为可变的，否则使用只读关键字val声明不可变的。

    class Address {
        var name: String =""
        var state: String?=""
        val zip: String =""
    }

    //要使用一个属性，只要用名称引用它即可，就像 Java 中的字段：
    fun copyAddress(address: Address): Address {
        val result = Address() // Kotlin 中没有“new”关键字
        result.name = address.name // 将调用访问器
        result.zip
        // ……
        return result
    }

    //Getters 与 Setters
    //声明一个属性的完整语法是
    /**
    var <propertyName>[: <PropertyType>] [= <property_initializer>]
    [<getter>]
    [<setter>]
    **/

    //其初始器（initializer）、getter 和 setter 都是可选的。属性类型如果可以从初始器 （或者从其 getter 返回值，如下文所示）中推断出来，也可以省略。
    //var allByDefault: Int? // 错误：需要显式初始化器，隐含默认 getter 和 setter
    var initialized = 1 // 类型 Int、默认 getter 和 setter
    //一个只读属性的语法和一个可变的属性的语法有两方面的不同：1、只读属性的用 val开始代替var 2、只读属性不允许 setter
    val simple: Int?=1 // 类型 Int、默认 getter、必须在构造函数中初始化
    val inferredType = 1 // 类型 Int 、默认 getter

    //我们可以编写自定义的访问器，非常像普通函数，刚好在属性声明内部。这里有一个自定义 getter 的例子:
    val isEmpty: Boolean get() = arrayListOf<Int>(1,2).size == 0
    //一个自定义的 setter 的例子:
    var stringRepresentation: String
        get() = this.toString()
        set(value) {
            Log.d("jay",value)
        }
    //自 Kotlin 1.1 起，如果可以从 getter 推断出属性类型，则可以省略它：
    val isEmpty2 get() = arrayListOf<Int>(1, 2).size == 0  // 具有类型 Boolean

    //如果你需要改变一个访问器的可见性或者对其注解，但是不需要改变默认的实现， 你可以定义访问器而不定义其实现:
    var setterVisibility: String = "abc"
        private set // 此 setter 是私有的并且有默认实现
    var setterWithAnnotation: Any? = null
        @Inject set // 用 Inject 注解此 setter

    //幕后字段
    //Kotlin 中类不能有字段。然而，当使用自定义访问器时，有时有一个幕后字段（backing field）有时是必要的。为此 Kotlin 提供一个自动幕后字段，它可通过使用 field 标识符访问。
    var counter = 0 // 此初始器值直接写入到幕后字段
        set(value) {
            if (value >= 0)
                field = value
        }
}