## Java学习笔记

参考书目《Java核心技术》第10版

### Java程序设计概述

* Java白皮书关键术语

  * 简单性
  * 面向对象
  * 分布式
  * 健壮性
  * 安全性
  * 体系结构中立
  * 可移植性
  * 解释性
  * 高性能
  * 多线程
  * 动态性

* Java语言发展状况

  * | 版本 | 年份 | 语言新特性                                                   | 类与接口数量 |
    | ---- | ---- | ------------------------------------------------------------ | ------------ |
    | 1.0  | 1996 | 语言本身                                                     | 211          |
    | 1.1  | 1997 | 内部类                                                       | 477          |
    | 1.2  | 1998 | strictfp修饰符                                               | 1524         |
    | 1.3  | 2000 | 无                                                           | 1840         |
    | 1.4  | 2002 | 断言                                                         | 2723         |
    | 5.0  | 2004 | 泛型类、“for each”循环、可变元参数、自动装箱、元数据、枚举、静态导入 | 3279         |
    | 6    | 2006 | 无                                                           | 3793         |
    | 7    | 2011 | 基于字符串的switch、钻石操作符、二进制字面量、异常处理改进   | 4024         |
    | 8    | 2014 | lambda表达式，包含默认方法的接口，流和日期/时间库            | 4240         |

### Java程序设计环境

* Java术语

  * | 术语名                   | 缩写 | 解释                                                         |
    | ------------------------ | ---- | ------------------------------------------------------------ |
    | Java Development Kit     | JDK  | 编写Java程序的程序员使用的软件                               |
    | Java Runtime Environment | JRE  | 运行Java程序的用户使用的软件                                 |
    | Server JRE               | -    | 在服务器上运行Java程序的软件                                 |
    | Standard Edition         | SE   | 用于桌面或简单服务器应用的Java平台                           |
    | Enterprise Edition       | EE   | 用于复杂服务器应用的Java平台                                 |
    | Macro Edition            | ME   | 用于手机和其他小型设备的Java平台                             |
    | Java FX                  | -    | 用于图形化用户界面的一个替代工具包，在Oracle的Java SE发布版本中提供 |
    | OpenJDK                  | -    | Java SE的一个免费开源实现，不包含浏览器集成或JavaFX          |
    | Java 2                   | J2   | 一个过时的术语，用于描述1998年~2006年之间的Java版本          |
    | Software Development Kit | SDK  | 一个过时的术语，用于描述1998年~2006年之间的JDK               |
    | Update                   | u    | Oracle的术语，表示bug修正版本                                |
    | NetBeans                 | -    | Oracle的集成开发环境                                         |

* 命令行工具

  * ``javac``
  * ``java``

* 集成开发环境IDE

  * Eclipse
  * NetBeans
  * IntelliJ IDEA

### Java的基本程序设计结构

* [Hello World](src/love/lipbcu/learnjava/p000_helloworld/HelloWorld.java)

  * ```java
    public class FirstSample {
        public static void main(String[] args) {
            System.out.println("Hello, World");
        }
    }
    ```

  * Java区分大小写

  * 关键字public，访问修饰符（access modifier）

  * 类名：Camel Case

* 注释

  * 行注释 ``//``
  * 块注释 ``/* */``
  * 文档注释 ``/** */``

* 数据类型

  * 整型

    * | 类型  | 存储需求 | 取值范围                                               |
      | ----- | -------- | ------------------------------------------------------ |
      | int   | 4字节    | -2 147 483 648 ~ 2 147 483 647（正好超过20亿）         |
      | short | 2字节    | -32 768 ~ 32 767                                       |
      | long  | 8字节    | -9 223 372 036 854 775 808 ~ 9 223 372 036 854 775 807 |
      | byte  | 1字节    | -128 ~ 127                                             |

    * 字面量

      * 长整型后缀 ``l``或``L``
      * 十六进制前缀``0x``或``0X``
      * 八进制前缀``0``
      * 二进制前缀`0b``或``0B``
      * 字面量加下划线``1_000_000``

    * 没有无符号类型（unsigned）

  * 浮点类型

    * | 类型   | 存储类型 | 取值范围                                                  |
      | ------ | -------- | --------------------------------------------------------- |
      | float  | 4字节    | 大约$\pm 3.402 823 47E+38F$（有效位数为6~7位）            |
      | double | 8字节    | 大约$\pm 1.797 693 134 862 315 70E+308$（有效位数为15位） |

    * 字面量

      * float后缀``f``或``F``
      * double后缀``d``或``D``，可以忽略
      * 十六进制表示浮点，使用p表示指数，尾数采用十六进制，指数采用十进制，指数的基数是2，如$0.125=2^{-3}$ 可以表示为 ``0x1.0p-3``

    * 特殊浮点值

      * 正无穷大：``Double.POSITIVE_INFINITY``
      * 负无穷大：``Double.NEGATIVE_INFINITY``
      * NaN（不是一个数字）：``Double.NaN``
        * ``x==Double.NaN``永远为false
        * 判断是否为NaN的方法：``Double.isNaN(x)``

  * char类型

    * 单引号表示char类型，``'A'``

    * char类型可以表示为十六进制，范围为``\u0000``到``\uffff``

    * 转义序列``\u``，如``\u03C0``表示$\pi$，可以出现在字面量或字符串之外（谨慎）

      * | 转义序列 | 名称   | Unicode值 |
        | -------- | ------ | --------- |
        | ``\b``   | 退格   | \u0008    |
        | ``\t``   | 制表   | \u0009    |
        | ``\n``   | 换行   | \u000a    |
        | ``\r``   | 回车   | \u000d    |
        | ``\"``   | 双引号 | \u0022    |
        | ``\'``   | 单引号 | \u0027    |
        | ``\\``   | 反斜杠 | \u005c    |

    * Unicode

      * 码点
      * 17个代码级别（code plane)
        * 第一代码级别：基本的多语言级别（basic multilingual plane）U+0000到U+FFFF
        * 其余16个级别：U+10000到U+10FFFF，包括辅助字符
      * UTF-16
        * 每个字符用16位表示，代码单元（code unit）
        * 替代区域

    * *强烈建议不要使用char类型*

  * boolean类型

    * ``false`` ``true``
    * *整型值与布尔值不能相互转换*

* 变量

  * 变量类型（type）
  * 变量名
    * 字母开头，字母数字构成的序列，包括``A-Z a-z _ $ $``和其他语言字母Unicode字符，如$\pi$
      * $只用在Java编译器或其他工具生成的名字
    * 大小写敏感
    * 判断字符是否属于Java“字母"
      * ``Character``类的``isJavaIdentifierStart``和``isJavaIdentifierPart``
  * 变量初始化：必须显式初始化
  * 常量
    * ``final``关键字指示常量
    * 习惯上常量名全大写
    * 类常量：``static final``
    * ``const``保留关键字，未使用，常量必须使用``final``

* 运算符

  * 加减乘除``+ - * /``
    * 整数除0异常，浮点除0无穷大或NaN

  * 取模``%``

  * 数学函数与常量
    * ``Math``类
      * ``sqrt pow sin cos tan atan atan2 exp log log10``
      * ``PI E``

  * 数值类型转换
    * ```mermaid
      graph LR
      char --> int
      byte --> short
      short --> int
      int --> long
      int -.-> float
      int --> double
      float --> double
      long -.-> float
      long -.-> double
      ```

  * 强制类型转换cast

  * 结合赋值和运算符 ``+=`` ``%=`` ``*=``

  * 自增自减运算符 ``++`` ``--``

    * 前缀``++i`` 后缀``i++``

  * 关系和boolean运算符

    * ``==`` ``!=`` ``<`` ``<=`` ``>=``
    * 逻辑运算符 ``&&`` ``||`` ``!``，*短路*方式
    * 三元运算符``condition?expression1:expression2``

  * 位运算符

    * and ``&``
    * or ``|``
    * xor ``^``
    * not ``~``
    * 左移 ``<<``
    * 右移 ``>>`` 符号位填充高位
    * ``>>>``0填充高位

  * 运算符优先级

    * | 运算符                                                       | 结合性   |
      | ------------------------------------------------------------ | -------- |
      | ``[]`` ``.`` ``()方法调用``                                  | 从左向右 |
      | ``!`` ``~`` ``++`` ``--`` ``+一元运算`` ``-一元运算`` ``()强制类型转换`` ``new`` | 从左向右 |
      | ``*`` ``/`` ``%``                                            | 从左向右 |
      | ``+`` ``-``                                                  | 从左向右 |
      | ``<<`` ``>>`` ``>>>``                                        | 从左向右 |
      | ``<`` ``<=`` ``>`` ``>=`` ``instanceof``                     | 从左向右 |
      | ``==`` ``!=``                                                | 从左向右 |
      | ``&``                                                        | 从左向右 |
      | ``^``                                                        | 从左向右 |
      | ``|``                                                        | 从左向右 |
      | ``&&``                                                       | 从左向右 |
      | ``||``                                                       | 从左向右 |
      | ``?:``                                                       | 从右向左 |
      | ``=`` ``+=`` ``-=`` ``*=`` ``/=`` ``%=`` ``&=`` ``|=`` ``^=`` ``<<=`` ``>>=`` ``>>>=`` | 从右向左 |

  * 枚举类型

    * ```java
      enum Size {SMALL, MEDIUM, LARGE, EXTRA_LAGE};
      Size s = Size.MEDIUM;
      ```

    * 枚举类型可以存储null

* 字符串

  * Java没有内置字符串类型，由标准库提供String类
    * 编译器如何知道字符串值面值是String类？（编译器不知道，String类知道如何从字面量初始化，猜想，未确认。字符串字面值在编译器中如何表示，CharSequence?）
  * 子串 ``substring``
  * 拼接``+``
    * **任何Java对象都能转换成字符串**
  * 不可变字符串
  * 判断相等 ``equals``
  * 空串 Null串
  * 码点和代码单元
    * char是一个代码单元，大多数Unicode使用一个代码单元表示，辅助字符需要两个代码单元（一对）
    * ``length``返回代码单元数量
    * ``codePointCount``返回码点数量
    * **不要使用char类型**
  * String API
    * ``charAt codePointAt offsetByCodePoints compareTo equals indexOf lastIndexOf length codePointCount replace substring toLowerCase toUpperCase trim join``
  * 联机API文档
    * [Java 8 API](https://docs.oracle.com/javase/8/docs/api/)
  * 构建字符串 StringBuilder/StringBuffer
    * ``append``
    * ``toString``
    * StringBuffer允许多线程，但效率稍低
    * 其他API ``length appendCodePoint setCharAt insert delete``

* 输入输出

  * 输入

    * ``Scanner(System.in)`` ``java.util``包
    * ``scanner.nextLine()`` ``nextInt() nextDouble() hasNext() hasNextInt() hasNextDouble()``
    * 读取密码
      * ``Console console=System.console()``
      * ``console.readLine()``
      * ``console.readPassword()``

  * 格式化输出

    * ``System.out.print()``

    * ``System.out.printf()``

      * 以``%``开始的格式说明符用参数替换

      * | 转换符 | 类型                  | 举例                                             |
        | ------ | --------------------- | ------------------------------------------------ |
        | d      | 十进制整数            | 159                                              |
        | x      | 十六进制整数          | 9f                                               |
        | o      | 八进制整数            | 237                                              |
        | f      | 定点浮点数            | 15.9                                             |
        | e      | 指数浮点数            | 1.59e+01                                         |
        | g      | 通用浮点数            |                                                  |
        | a      | 十六进制浮点数        | 0.1.fccdp3                                       |
        | s      | 字符串                | Hello                                            |
        | c      | 字符                  | H                                                |
        | b      | 布尔                  | True                                             |
        | h      | 散列码                | 42628b2                                          |
        | tx或Tx | 日期时间（T强制大写） | 已经过时，应当改为使用java.time类；x见时间转换符 |
        | %      | 百分号                | %                                                |
        | n      | 与平台有关的行分隔符  |                                                  |

      * | 标志               | 目的                                        |
        | ------------------ | ------------------------------------------- |
        | +                  | 打印正数和负数的符号                        |
        | 空格               | 在正数前添加空格                            |
        | 0                  | 数字前面补0                                 |
        | -                  | 左对齐                                      |
        | (                  | 将负数括在括号内                            |
        | ,                  | 添加分组分隔符                              |
        | \#（对于f格式）    | 包含小数点                                  |
        | \#（对于x或0格式） | 添加前缀0x或0                               |
        | $                  | 给定被格式化的参数的索引，参数索引值从1开始 |
        | <                  | 格式化前面说明的数值                        |

      * ``String.format``

      * 时间格式化，应当使用java.time包中的方法

        * ``c F D T r R Y y C B ...``

  * 文件输入输出

    * ``Scanner(Paths.get("myfile.txt"), "UTF-8")``
    * ``PrintWriter("myfile.txt", "UTF-8")``
    * 启动路径：命令解释器的当前路径；IDE中由IDE控制
      * ``System.getProperty("user.dir")``
    * ``throws IOException``

* 控制流程

  * 块作用域  块（block）即复合语句
  * 条件语句
    *  ``if (condition) statement``
    * ``if (condition) staement1 else statement2``
    * ``if/else if``
  * 循环
    * ``while (condition) statement``
    * ``do statement while (condition)``
  * 确定循环
    * ``for(int i=0;i<10;i++) { System.out.println(i); }``
  * 多重选择
    * ``switch``
    * case标签可以是
      * char byte short int 常量表达式
      * 枚举常量
      * 字符串字面量（Java SE 7开始）
  * 中断控制流程
    * ``goto``保留字，但未使用
    * ``break``
    * ``continue``
    * 带标签``break``

* 大数值

  * ``java.math``
    * ``BigInteger`` 任意精度整数
    * ``BigDecimal`` 任意精度浮点
    * ``valueOf``
    * ``add multiply divide subtract mod ``


