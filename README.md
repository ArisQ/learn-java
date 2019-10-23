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
  * 对线程
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
