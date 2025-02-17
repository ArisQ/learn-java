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

* 数组

  * 声明与初始化数组
    * ``int[] a = new int[100];``
    * 数组长度不要求是常量
  * 数组不能改变大小，需要扩展需要用**数组列表 array list**
  * ``for each``
    * ``for (variable : collection) statement``
    * collection必须是数组或者实现``Iterable``接口的对象，如ArrayList
  * 数组初始化
    * ``int[] smallPrimes={2,3,5,7,11,13}``
    * 匿名数组 ``new int[] {17,19,23,29,31,37}``
  * 数组拷贝
    * 直接赋值则两个变量指向同一个数组
    * ``Arrays.copyOf``
  * 命令行参数
    * args中不包含程序名
  * 数组排序
    * ``Arrays.sort()``
    * 其他API ``copyOfRange binarySearch fill equals``
  * 多维数组
    * ``double[][] balances``
    * ``balances = new double[NYEARS][NRATES]``
    * ``for each``不能自动处理二维数组，需要嵌套循环
  * 不规则数组


### 对象与类

* 面向对象程序设计概述

  * OOP
  * ``算法+数据结构=程序`` ``Algorithms + Data Structures = Programs`` Niklaus Wirth
  * 类 class
    * 构造 construct
    * 实例 instance
    * 封装 encapsulation
    * 实例域 instance field
    * 方法 method
    * 状态 state
    * 继承 inheritance
    * Object类
  * 对象
    * 对象的三个特性
      * 对象的行为 behavior
      * 对象的状态 state
      * 对象标识 identity
  * 识别类
  * 类之间的关系
    * 依赖 dependence： uses-a
    * 聚合 aggregation：has-a
    * 继承 inheritance：is-a
    * UML

* 预定义类

  * Math
  * Date
  * LocalDate
    * epoch 纪元 UTC 1970年1月1日 00:00:00
    * UTC Coordinated Universal Time
    * ``LocalDate.now()``
    * ``plusDays getYear getMonthValue getDayOfMonth``
  * 构造器 constructor

* 自定义类

  * ```java
    class ClassName {
        field1;
        field2;
        ...
        constructor1;
        constructor2;
        ...
        method1;
        method2;
    }
    ```

  * ​

  * 隐式参数与显式参数
    * this

  * 类的访问权限

  * 私有方法 private

  * final 实例域

* 静态域与静态方法 ``static``

  * 静态域
  * 静态常量
  * 静态方法
  * 工厂方法
  * main方法

* 方法参数

  * 按值调用 call by value
  * 按引用调用 call by reference

* 对象构造

  * 重载 overloading

    * 重载解析 overloading resolution

  * 方法的签名 signature

  * 默认域初始化 `` 0 false null`

  * 无参数构造器

  * 显式域初始化

  * 参数名

    * ``this.name=name``

  * 调用另一个构造器

    * ``this()``

  * 初始化块

    * 对象初始化块

    * 静态初始化块

    * ```java
      class Employee {
          private static int nextId;
          // static initialization block
          static {
              nextId=new Random().nextInt(1000);
          }
          // object initialization block
          {
              id=nextId;
              nextId++;
          }
      }
      ```

  * 对象析构与finalize

    * Java自动垃圾回收，不支持析构器
    * finalize方法在垃圾回收器清楚对象之前调用

* 包 package

  * 包名建议域名逆序
  * 类导入
    * ``java.time.LocalDate``
    * ``import java.util.*;``
  * 静态导入
    * ``import static java.lang.System.*;``导入静态方法和静态域
  * 类放入包中
    * ``package com.horstmann.corejava;``
  * 包的作用域

* 类路径

  * JAR  Java归档，zip格式
  * 类路径 class path
  * 设置类路径
    * ``java -classpath /home/user/classdir:.:/home/user/archives/archive.jar MyProg``
    * ``export CLASSPATH=/home/user/classdir:.``

* 文档注释

  * ```java
    /**
     *
     */
    ```

  * javadoc实用程序（utility）抽取信息

    * 包
    * 公有类和接口
    * 公有的和受保护的构造器和方法
    * 公有的和受保护的域

  * 文字注释在标记后紧跟自由格式文本（free-form text）

    * 标记角以@开头，如@author或@param
    * 自由格式文本，可以使用HTML修饰符，如``<strong></strong> <em></em> <img> {@code }``，不能使用``<h1> <hr>``

  * 类注释

    * import之后，类之前

  * 方法注释

    * @param
    * @return
    * @throws

  * 域注释

    * 公有域（通常指静态常量）

  * 通用注释

    * @author
    * @version
    * @since
    * @deprecated
    * @see
      * ``@see <a href="https://exmaple.com">link name</a>``
    * ``{@link package.class#feature label}``

  * 包和概述注释

    * 包注释需在包目录添加单独文件
      * ``package.html``，会抽取``<body>...</body>``之间的文本
      * ``package-info.java``文件，必须包含``/**  */``界定的注释
    * 概述性注释
      * ``overview.html``

  * 注释抽取

    * ``javadoc -d docDirectory nameOfPackage``

* 类设计技巧

  * 一定要保证数据私有
  * 一定要对数据初始化
  * 不要在类中使用过多的基本类型
  * 不是所有的域都需要独立的域访问器或域更改器
  * 将职责过多的类进行分解
  * 类名和方法名要能够体现他们的职责
  * 优先使用不可变类


### 继承

* 类、超类和子类

  * ``extends``
  * Java所有继承都是公有继承
  * **超类superclass**、基类base class、父类parent class
  * **子类subclass**、派生类derived class、孩子类child class
  * 覆盖方法 override
  * ``super.getSalary()`` ``super(name,salary)``
  * 多态polymorphism、动态绑定dynamic binding
  * Java中不需要声明为virtual，默认是动态绑定，标记为final使方法不具有virtual特征
  * 继承层次 inheritance hierarchy
  * 继承链 inheritance chain
  * **Java不支持多继承**
  * 强制类型转换
    * ``instanceof``
  * 抽象类 ``abstract``
  * 受保护访问 ``protected``
    * 仅本类可见 private
    * 所有类可见 public
    * 本包和子类可见 protected
    * 本包可见，不需要修饰符，默认

* Object 所有类的超类

  * 不明确指出超类，则超类是Object类
  * 只有基本类型不是超类，如数值，字符，布尔
  * ``equals``
    * 自反性：任何非空``x``，``x.equals(x)==true``
    * 对称性：``y.equals(x)==true`` <==> ``x.equals(y)==true``
    * 传递性：``x.equals(y)==true  y.equals(x)==true`` 则 ``x.equals(z)==true``
    * 一致性：``x y``无变化，则 ``x.equals(y)`` 返回同样的结果
    * 对于任意非空引用``x``，``x.equals(null)``返回``false``
  * ``hashCode`` 散列码
  * ``toString``
  * ``getClass``
    * ``getName``
    * ``getSuperclass()``

* 泛型数组列表

  * ``ArrayList<E>``
  * ``add size ensureCapacity trimToSize``
  * ``void set(index, E obj)``
  * ``E get(index)``
  * ``void add(int index, E obj)``
  * ``E remove(int index)``

* 对象包装器与自动装箱

  * 包装器 wrapper

    * ``Integer Long Float Double Short Byte`` 派生于``Number``
    * `` Character Void Boolean``
    * 包装器是不可变类，构造以后不允许修改

  * 自动装箱 ``autoboxing`` ``autowrapper``

  * 装箱和拆箱是编译器实现的

  * ```java
    Integer n=3;
    n++; // 拆箱 自增 装箱
    ```

  * ``Integer.partInt(s)``

* 参数数量可变的方法

  * ``public PrintStream printf(String fmt, Object... args) { return format(fmt,args) }``

* 枚举类

  * 比较枚举类永远不要使用``equals``，应直接使用``==``
  * 枚举类可以添加构造器，方法和域
  * ``valueOf ordinal compareTo toString``

* 反射 reflective

  * 反射库 reflection library

  * Class 类

    * 获取Class对象的方法
      * ``object.getClass()``
      * ``Class.forName("java.util.Random")``
      * ``T.class`` 如 ``Random.class int.class int[].class``
    * ``newInstance``

  * 捕获异常

    * 异常类型

      * 未检查异常
      * 已检查异常

    * ```java
      try {
          // statements that might throw exceptions
      } catch (Execption e) {
          // handler exception
          e.printStackTrace();
      }
      ```

    * ``Throwable`` ``Execption``

  * 利用反射分析类

    * ``java.lang.relect``包
      * ``Field``
      * ``Method``
        * ``Object invoke(Object obj, Object.. args)``
      * ``Constrcutor``

  * 运行时使用反射分析对象

  * 使用反射编写泛型数组代码

  * 调用任意方法

* 继承的设计技巧

  * 将公共操作和域放在超类
  * 不要使用受保护（protected）的域
  * 使用继承实现”is-a“关系
  * 除非所有继承的方法都有意义，否则不要使用继承
  * 在覆盖方法时，不要改变预期的行为
  * 使用多态，而非类型信息
  * 不要过多地使用反射


### 接口、Lambda表达式与内部类

* 接口 interface

  * 实现implement接口

  * ```java
    public interface Comparable {
        int compareTo(Object other);
    }
    public interface Comparable<T>{
        int compareTo(T other);
    }
    class Employee implements Comparable;
    ```

  * ``default`` 为接口提供默认实现

    * 默认方法冲突
      * 超类优先
      * 接口冲突，必须覆盖方法来解决

  * 接口示例

    * 接口与回调 callback

      * ```java
        public interface ActionListener {
            void actionPerformed(ActionEvent event);
        }
        class TimerPrinter implements ActionListener {
            public void actionPerformed(ActionEvent event){
                //...
            }
        }
        new Timer(1000,listener).start();
        ```

    * Comparator接口

      * ```java
        public interface Comparator<T> {
            int compare(T first, T second);
        }
        ```

    * 对象克隆 Cloneable

* Lambda表达式

  * lambda表达式是可传递的代码块

  * ```java
    (String first, String second) -> first.length()-second.length()；
    (String first, String second) -> { return first.length()-second.length() }
    ```

  * 函数式接口 functional interface

    * 只有一个抽象方法的接口，需要这种接口对象时，可以提供一个lambda表达式

  * 方法引用

    * ```java
      Timer t=new Timer(1000, System.out.println);
      ```

    * ``object::instanceMethod``

    * ``Class::staticMethod``

    * ``Class::instanceMethod``

    * ``this::equals  super::instanceMethod``

  * 构造器引用

    * ```java
      Person::new
      int[]::new
      Person[] people = stream.toArray(Person[]::new);
      ```

  * 变量作用域

    * lambda表达式中只能引用值不会改变的变量

  * 常用的函数式接口

    * | 函数式接口        | 参数类型 | 返回类型 | 抽象方法 | 描述                         | 其他方法                   |
      | ----------------- | -------- | -------- | -------- | ---------------------------- | -------------------------- |
      | Runnable          | 无       | void     | run      | 作为无参数或返回值的动作运行 |                            |
      | Supplier<T>       | 无       | T        | get      | 提供一个T类型的值            |                            |
      | Consumer<T>       | T        | void     | accept   | 处理一个T类型的值            | andThen                    |
      | BiConsumer<T,U>   | T, U     | void     | accept   | 处理T和U类型的指             | andThen                    |
      | Function<T,R>     | T        | R        | apply    | 有一个T类型参数的函数        | compose, andThen, identity |
      | BiFunction<T,U,R> | T,U      | R        | apply    | 有T和U类型参数的函数         | andThen                    |
      | UnaryOperator<T>  | T        | T        | apply    | 类型T上的一元函数            | compose, andThen, identity |
      | BinaryOperator<T> | T, T     | T        | apply    | 类型T上的二元函数            | andThen, maxBy, minBy      |
      | Predicate<T>      | T        | boolean  | test     | 布尔值函数                   | and, or, negate, isEqual   |
      | BiPredicate<T>    | T, U     | boolean  | test     | 有两个参数的布尔值函数       | and, or, negate            |

  * 基本类型的函数式接口

    * | 函数式接口         | 参数类型 | 返回类型 | 抽象方法名   |
      | ------------------ | -------- | -------- | ------------ |
      | BooleanSupplier    | none     | boolean  | getAsBoolean |
      | PSupplier          | none     | p        | getAsP       |
      | PComsumer          | p        | void     | accept       |
      | ObjPComsumer<T>    | T, p     | void     | accept       |
      | PFunction<T>       | p        | T        | apply        |
      | PToQFunction       | p        | q        | applyAsQ     |
      | ToPFunction<T>     | T        | p        | applyAsP     |
      | ToPBiFunction<T,U> | T, U     | p        | applyAsP     |
      | PUnaryOperator     | p        | p        | applyAsP     |
      | PBinaryOperator    | p, p     | p        | applyAsP     |
      | PPredicate         | p        | boolean  | test         |

    * p, q为int, long, double; P, Q为Int, Long, Double

  * ``@FunctionalInterface``注解，标记只有一个抽象方法的接口

  * Comparator

    * Comparator接口包含很多方便的静态方法来创建比较器

    * 静态comparing方法，键提取器函数

      * ```java
        Arrays.sort(people, Comparator.comparing(Person::getName));
        ```

    * ``nullsFirst naturalOrder reverseOrder``

* 内部类 inner class

  * 内部类的主要原因

    * 内部类的方法可以访问类定义所在作用域的数据，包括私有数据
    * 内部类可以对同一个包的其他类隐藏
    * 使用匿名内部类可以便捷的定义回调函数

  * ```java
    public class Outer {
        private int value;
        public class Inner {
            public void action() {
                System.out.println(value);
            }
        }
    }
    ```

  * 内部类的特殊语法

    * ``OuterClass.this`` 引用外部类的引用
    * ``outerObject.new InnerClass(Construction parameters)`` 编写内部类的构造器
    * ``OuterClass.InnerClass`` 引用内部类
    * **内部类的所有静态域必须是final**
    * **内部类不能有static方法**

  * ``javap -private ClassName``

    * ``java -private innerClass.TalkingClock\$TimerPrinter``

  * **内部类访问私有域数据，会导致外部类添加静态方法** 如``access$0``

  * 局部内部类

    * ```java
      public void start() {
          class TimerPrinter implements ActionListenr {
              public void actionPerformed(ActionEvent event) {
              }
          }
      }
      ```

    * 局部类不能用public或private说明符

  * 局部类可以访问局部变量，局部变量必须是事实上final

  * 匿名内部类 anonymous inner class

    * 如果只创建这个类的一个对象，可以不命名，称为匿名内部类

    * ```java
      new SuperType(construction parameters) {
          // inner class methods and data
      }
      ```

    * **匿名类不能有构造器**

    * 双括号初始化 double brace initialization

      * ```java
        invite(new ArrayList<String>() {{ add("Harry"),add("Tony") }} )
        ```

        * 外层括号建立匿名子类，内层括号为对象构造块

  * 静态内部类

    * 将内部类声明为static，可以消除引用

    * ```java
      class ArrrayAlg {
          public static class Pair {
              private double first;
              private double second;
              public Pair(double f,doubl s) { first = f; second = s; }
              // getters
          }
          public static Pair minmax(double[] values) { /* ... */ }
      }
      // ArrayAlg.Pair
      ```

    * 声明在接口中的内部类，自动称为static和public类

    * 静态内部类可以有静态域或方法

    * 静态类也可称为嵌套类nested class

* 代理 proxy


### 异常、断言和日志

* 处理错误

  * 异常处理 exception handler

  * 错误类型

    * 用户输入错误
    * 设备错误
    * 物理限制
    * 代码错误

  * 异常分类

    * Throwable
      * Error 内部错误和资源耗尽错误
      * Exception
        * RuntimeException，程序错误导致的；如果出现RuntimeException，一定是程序的问题
          * 错误的类型转换
          * 数组访问越界
          * 访问null指针
        * 其他，程序本身没问题，由于I/O错误之类的异常导致的
          * 试图在文件尾部后面读取数据
          * 试图打开一个不存在的文件
          * 试图根据给定字符串查找Class对象，而字符串表示的类不存在
    * 派生于Error类或RuntimeException类的所有异常为非受查异常unchecked
    * 其他为受查异常unchecked

  * 方法需要声明可能发生的异常

    * ```java
      public FileInputStream(String name) throws FileNotFoundException
      ```

    * 抛出异常的四种情况

      * 调用一个抛出受查异常的方法
      * 程序运行时发现错误，并且利用throw抛出一个受查异常
      * 程序出现错误
      * Java虚拟机和运行库出现的内部错误

    * 异常规范 exception specification

    * 覆盖超类方法时，子类方法声明的受查异常不能比超类方法声明的异常更通用

  * 抛出异常

    * ``throw new EOFException();``

  * 创建异常类

    * ```java
      class FileFormatException extends IOException {
          public FileFormatException() {}
      }
      ```

* 捕获异常

  * ```java
    try {
        // code
    } catch (Exception e) {
        // handler
    }
    ```

  * ```java
    try {
        // code
    } catch (FileNotFoundException e) {
        // handler
    } catch (IOException e) {
        // handler
    }
    ```

  * 再次抛出和异常链

    * ```java
      try {
          // access the database
      } catch (SQLException e) {
          Throwable se = new ServeletExcetption("database error");
          se.initCause(e);
          throw se;
      }

      ```

  * ``finally``

  * 带资源的try

    * ```java
      try (Resource res = ... ) {
          // work with res
      }
      ```

    * 资源需要实现AutoCloseable接口

  * 分析堆栈轨迹（stack trace）元素

    * ``exception.printStackTrace()``
    * ``getStackTrace()``
    * ``Thread.getAllStackTrace()``

* 使用异常机制的技巧

  * 异常处理不能代替简单的测试
  * 不要过分细化异常
  * 利用异常层次结构
  * 不要压制异常
  * 在检测到错误时，苛刻比放任更好（早抛出）
  * 不要羞于传递异常（晚捕获）

* 断言

  * ``assert condition;``
  * ``assert condition: statement;``
  * 启用与禁用断言
    * ``java -enableassertions MyApp`` ``-ea`` 默认禁用
    * 启用和禁用断言时类加载器的功能，不必重新编译
  * 断言是致命的、不可恢复的错误
  * 断言检查只用于开发和测试阶段

* 记录日志

  * 基本日志

    * 全局日志记录器global logger  ``Logger.getGlobal().info("File->Open menu item selected");``
    * ``Logger.getGlobal().setLevel(Level.OFF);``

  * 高级日志

    * ``private static final Logger logger=Logger.getLogger("com.mycompany.myapp");``

    * 7个日志记录级别

      * ``SEVERE WARNING INFO CONFIG FINE FINER FINEST``

    * 修改日志管理器配置

      * 默认配置文件 ``jre/lib/logging.properties``

      * 另外指定 ``java -Djava.util.logging.config.file=configFile MainClass``

      * ```properties
        .level=INFO
        com.mycompany.myapp.level=FINE
        ```

      * 处理器级别 ``java.util.logging.ConsoleHandler.level=FINE``

  * 本地化

    * 资源包 resource bundle

      * ``com/mycompany/logmessages_en.properties``
      * ``com/mycompany/logmessages_de.properties``
      * 消息占位符 ``{0} {1} ...``

    * ```java
      Logger logger=Logger.getLogger(loggerName,"com.mycompany.logmessages");
      logger.info("readFile");

      ```

  * 处理器

    * ConsoleHandler FileHandler SocketHandler
    * 文件处理器配置参数
      * ``java.util.logging.FileHandler`` ``level append limit pattern count filter encoding formatter``
      * 日志记录文件模式变量 ``%h %f %u %g %%``
      * 文件循环功能

  * 过滤器

  * 格式化器

* 调试技巧

  * ``System.out.println``或``Logger``打印变量
  * 单独的main进行单元测试
  * JUnit
  * 日志代理``logging proxy``
  * ``Throwable.printStackTrace``
  * ``System.err System.out``错误流 输出流
  * ``Thread.setDefaultUncaughtExceptionHandler``
  * 使用``-verbose``标志启动虚拟机
  * ``-Xlint``
  * Java虚拟机监控管理Java应用程序


### 泛型程序设计

* 泛型程序设计 Generic programming

  * 类型参数 type parameters：更好的可读性和安全性
  * 通配符类型 wildcard type
  * 泛型程序设计的3个能力级别
    * 基本级别，仅仅使用泛型类
    * 学习Java泛型来系统地解决问题
    * 实现自己的泛型类和泛型方法

* 定义简单的泛型类

  * 泛型类 generic class：具有一个或多个类型变量的类

  * ```java
    public class Pari<T> {}
    public class Pari<T,U> {}
    ```

  * 类型变量大写，且较短

    * E表示集合的元素类型
    * K/V表示关键字和值类型
    * T/U/S表示任意类型

* 泛型方法

  * ```java
    class ArrayAlg {
        public static <T> T getMiddle(T... a) {}
    }

    ```

* 类型变量的限定

  * 限定（bound）

  * ```java
    public static <T extends Comparable> T min(T[] a) { }
    T extends Comparable & Serializable
    ```

  * T是绑定类型的子类型（subtype）

* 泛型代码和虚拟机

  * 类型擦除

    * 定义泛型时，自动提供一个相应的原始类型（raw type）
    * 原始类型的名字是删去类型参数后的泛型类型名
    * 擦除erased类型变量，替换为限定类型（无限定则用Object）

  * 翻译类型表达式

    * 擦除返回类型，编译器插入强制类型转换，如``Employee buddy=buddies.getFirst()``翻译为两条虚拟机指令
      * 对原始方法调用
      * 将返回的Object转换为Employee类型

  * 翻译泛型方法

    * 类型擦除与多态会发生冲突，编译器通过桥方法 bridge method解决冲突
    * 虚拟机中用参数类型和返回类型确定一个方法
    * Java泛型转换的事实
      * 虚拟机没有泛型，只有普通类和方法
      * 所有类型参数都用限定类型替换
      * 桥方法被合成来保持多态
      * 为保持类型安全性，必要时插入强制类型转换

  * 调用遗留代码

    * 注解（annotation）消除警告

      * ```java
        @SuppressWarning("unchecked")
        Dictionary<Integer, Components> labelTable=slider.getTableTab();

        @SuppressWarning("unchecked")
        public void configureSlider() {}
        ```

* 约束和局限性 **TODO: 用到时需要仔细研究**

  * *大多数限制是类型擦除引起的*

  * 不能用基本类型实例化类型参数

  * 运行时类型查询只适用于原始类型

  * 不能创建参数化类型的数组 ``Pair<String>[10] // Error``

  * Varargs警告

    * ```java
      public static <T> void addAll(Collection<T> coll, T... ts) {}
      ```

    * 可变参数会导致参数化类型的数组，但是会产生警告而不是错误

    * 两种方法抑制警告

      * ``@SupressWarning("unchecked")``
      * ``@SafeVarargs``

  * 不能实例化类型变量

    * 不能调用``new T()``，因为类型擦除后为``new Object()``

    * 可以让调用者提供构造器表达式来解决，如``Pair.makPair(String::new)``

      * ```java
        public static <T> Pair<T> makePair(Supplier<T> constr) {
            return new Pair<>(constr.get(),constr.get())
        }
        ```

    * 传统的方法是通过反射调用``Class.newInstance``

      * ```java
        public static <T> Pair<T> makePair(Class<T> cl) {
            try { return new Pair<>(cl.newInstance(),cl.newInstance()); }
            catch (Exception ex) { return null; }
        }

        Pair.makePair(String.class);
        ```

  * 不能构造型数组

  * 泛型类的静态上下文中类型变量无效

    * ```java
      public class Singleton<T> {
          private static T singleInstance; //Error
          public static T getSingleInstance() {} // Error
      }
      ```

  * 不能抛出或捕获泛型类的实例

    * ```java
      public class Problem<T> extends Exception { } // Error
      ```

  * 可以消除对受查异常的检查

  * 注意擦除后的冲突

* 泛型类型的继承规则

  * 无论S和T什么关系，``Pair<S>``和``Pair<T>``通常没什么关系，如Manager继承Employee，但``Pair<Manger>``和``Pair<Employee>``不是子类关系
  * 可以将参数化类型转换为一个原始类型，如``Pair<Employee>``是原始类型``Pair``的一个子类型
  * 泛型可以扩展或实现其他泛型类，如``ArrayList<T>``实现``List<T>``接口

* 通配符类型

  * 通配符类型中，允许类型参数变化，如通配符类型``Pair<? extends Employee>``表示任何泛型Pair类型，类型参数是Employee的子类
  * 通配符超类型限定 supertype bound，如``? super Manager``限制为Manager的所有超类型
  * 无限定通配符 ``Pair<T>``
  * 通配符捕获

* 反射与泛型

  * ``Class``类是泛型，``Class<T>``，``String.class``是``Class<String>``类的对象

### 集合

* Java集合框架

  * Java集合类库将接口（interface）与实现（implementation）分离

  * 队列接口 queue

  * 集合类的基本接口 Collection接口

    * 两个基本方法：``add`` ``iterator``

  * 迭代器 Iterator接口

    * 包含四个方法：``next`` ``hasNext`` ``remove`` ``forEachRemaining``
    * 任何实现了Iterable接口的对象都可以使用``for each``循环
    * Java迭代器应该认为是两个元素之间的位置
    * **remove会删除上次调用next返回的元素，调用remove之前必须调用next**

  * 泛型实用方法

    * ``size contains isEmpty containsAll equals addAll remove removeAll clear retainAll toArray``
    * ``AbstractCollection``

  * 集合框架中的接口

    * ```
      Iterable -- Collection -- Set -- SortedSet -- NavigableSet
      Collection -- List
      Collection -- Queue -- Deque
      Map -- SortedMap -- NavigableMap
      Iterator -- ListIterator
      RandomAccess
      ```

* 具体的集合

  * ``ArrayList LinkedList ArrayQueue HashSet TreeSet EnumSet LinkedHashSet PriorityQueue HashMap TreeMap EnumMap LinkedHashMap WeakHashMap IdentityHashMap``
  * 链表 linked list
    * Java中所有链表都是双向链表 doubly list
    * ``LinkedList<>`` ``add() iterator() iter.next() iter.remove()``
    * ``set``方法取代调用``next``或``previous``方法后返回的元素
    * 迭代器发现集合被另一个迭代器或自身方法修改，则会抛出``ConcurrentModificationException`` 异常
  * 数组列表 ArrayList
    * Vector所有方法都是同步的，线程安全；ArrayList不是同步的
  * 散列集
    * 散列表 hash table 散列码 hash code
    * 如果``a.equals(b)``则两者的必须具有相同的散列码
    * 再散列 rehashed  装填因子load factor
  * 树集TreeSet
    * 有序集合 sorted collection
    * 当前实现是红黑树red-black tree
    * 树集的元素必须实现Comparable接口
    * 添加元素到树比散列表慢，查找元素需要$log_{2}{n}$ 次比较
  * 队列与双端队列Deque
  * 优先级队列 priority queue
    * 优先级使用堆heap数据结构，堆是自我调整的二叉树

* 映射map

  * Java类库为映射提供两个通用的实现HashMap和TreeMap，都实现类Map接口

  * 散列或比较函数只能作用于键

  * 键必须唯一

  * 更新映射项

    * ``getOrDefault putIfAbsent merge``

  * 映射视图

    * 三种视图View：键集、值集合、键值对集

      * ```java
        Set<K> keySet()
        Collection<V> values()
        Set<Map.Entry<K, V>> entrySet()
        ```

  * 弱散列映射 WeakHashMap

    * WeakHashMap使用弱引用（weak reference）保存键

  * 链接散列集与映射

    * LinkedHashSet LinkedHashMap会记住元素项的顺序
    * 链接散列映射用访问顺序而不是插入顺序，对映射条目进行迭代

  * 枚举集与映射 EnumSet EnumMap

  * 标识散列映射 IdentityHashMap

    * 键的散列值用``System.identityHashCode``计算，而不是``hashCode``函数进行计算
    * IdentityHashMap使用``==``而不是``equals``进行对象比较

* 视图与包装器

  * 视图是实现了接口（如keySet返回实现类Set接口）的类对象，类的方法对原映射进行操作

  * 轻量级集合包装器  Arrays类的静态方法``asList``返回一个包装类普通Java数组的List包装器

  * 子范围subrange ``subList``

  * 不可修改的视图unmodifiable views

    * 8中方法获得不可修改视图

    * ```java
      Collections.unmodifiableCollection
      Collections.unmodifiableList
      Collections.unmodifiableSet
      Collections.unmodifiableSortedSet
      Collections.unmodifiableNavigableSet
      Collections.unmodifiableMap
      Collections.unmodifiableSortedMap
      Collections.unmodifiableNavigableMap
      ```

  * 同步视图

    * 使用视图机制确保常规集合的线程安全
    * ``Collections.synchronizedMap``

  * 受查视图 ``Collections.checkedList``

  * 可选操作

    * ``UnsupportedOperationException``

* 算法

  * 排序与混排
    * ``Collections.sort``
    * 归并排序的优点：稳定
    * ``Collections.shuffle``
  * 二分查找
    * ``Collections.binarySearch``
  * 简单算法
    * ``replaceALL removeIf min max``
  * 批操作
    * ``removeAll retainAll``
  * 集合与数组的转换
    * ``asList toArray``
  * 编写自己的算法

* 遗留的集合

  * Hashtable类，Hashtable是同步的，应使用HashMap和ConcurrentHashMap代替
  * 枚举 Enumeration接口，两个方法``hasMoreElements nextElement``，``Collections.enumeration``

  * 属性映射 property map，类称为Properties，属性映射通常用于程序的特殊配置选型
    * 键值都是字符串
    * 可以保存到文件中
    * 使用一个默认的辅助表
  * 栈 Stack
    * 包含push pop方法，Stack扩展Vector类
  * 位集 BitSet类


### 图形程序设计

略

### 事件处理

略

### Swing用户界面组件

略

### 部署Java应用程序

* JAR文件

  * JAR文件使用ZIP压缩格式

  * 创建JAR文件 ``jav cvf JARFileName File1 File2 ...``

    * jar选项 ``c C e f i m M t u v x 0``

  * JDK运行时库 ``rt.jar``

  * 清单文件manifest

    * 清单文件被命名为``MANIFEST.MF``位于META-INF子目录

    * 最小内容 ``Manifest-Version: 1.0``

    * 复杂的清单文件包含条目，条目被分成多节，第一节称为主节 main section，主节作用于整个JAR文件，随后的条目指明已命名条目（可以是文件、包、URL，必须起始于名为Name的条目）的属性， 节与节之间用空行分开

      * ```
        Manifest-Version: 1.0
        描述这个归档文件的行

        Name: Woozle.class
        描述这个文件的行
        Name: com/mycompany/mypkg/
        描述这个包的行

        ```

    * ```shell
      jar cfm JARFileName ManifestFile Name ... # 编辑清单文件，加入到清单文件
      jar ufm MyArchive.jar manifest-additions.mf # 更新JAR文件的清单

      ```

  * 可执行JAR文件

    * ``e``选项指定程序入口点
      * ``jar cfve MyProgram.jar com.mycompany.mypkg.MainAppClass files_to_add``
    * 运行 ``java -jar MyProgram.jar``

  * 资源resource

    * 文件自动装载
    * 国际化

  * 密封seal

    * 在清单文件主节中加入``Sealed: true``

* 应用首选项的存储

  * 属性映射 property map

    * ``Properties settings=new Properties()``

    * 获取主目录 ``System.getProperties("user.home")``

    * 两种默认值机制

      * ``settings.getProperties("title", "Default title");``

      * ```java
        Properties defaultProperties=new Properties();
        defaultProperties.setProperty("title", "Default title");
        // other setProperty ...
        Properties settings=new Properties(defaultProperties);
        ```

  * 首选项API

    * ``Preferences``类 与平台有关，在Windows上使用注册表，在Linux上使用文件系统
    * ``Preferences`` 采用树状结构
    * ``Preferences.userRoot() Preferences.systemRoot()``
    * ``root.node("com/mycompany/myapp")``
    * 如果节点路径名等于类包名，则可以使用便捷方法 ``Preferences.userNodeForPackage(obj.getClass())`` 或 ``Preferences.userNodeForPackage(obj.getClass())``
    * ``get getInt getLong getFloat getDouble getBoolean getByteArray`` 需要指定默认值
    * ``exportSubtree exportNode``

* 服务加载器 ``ServiceLoader``

  * ``META-INF/services``

* applet

  * applet是包含在HTML页面中的Java程序
  * 略

* Java Web Start

  * Java Web Start是在Internet上发布应用程序的技术
  * Java Network Launch Protocol (JNLP)
  * 创建JNLP格式的描述文件并放置到Web服务器上
  * JNLP的MIME需要为``application/x-java-jnlp-file``

### 并发

* 线程 thread、多线程multithread

* ```java
  public interface Runnable {
      void run();
  }
  Runnable r=()->{ /* task */ }
  Thread t=new Thread(r);
  t.start();
  ```

* ``interrupt`` 方法

  * ``Thread.currentThread().isInterrupted``获取当前线程中断状态是否置位

* 线程状态

  * 6种状态

    * New 新创建
    * Runnable 可运行
    * Blocked 被阻塞
    * Waiting 等待
    * Timed  waiting 计时等待
    * Terminated 被终止

  * ```mermaid
    graph LR
    新创建 --开始--> 可运行
    可运行 --请求锁--> 被阻塞
    被阻塞 --得到锁--> 可运行
    可运行 --等待通知--> 等待
    等待 --出现通知--> 可运行
    可运行 --等待超时或通知--> 计时等待
    计时等待 --出现超时或通知--> 可运行
    可运行 --运行方法exits--> 被终止
    ```

* 线程属性

  * 线程优先级
    * 线程默认继承父线程优先级
    * ``setPrioritye``提高或降低线程优先级
    * ``MIN_PRIORITY MAX_PRIORITY`` 在Thread类中定义分别为1和10
  * 守护线程 daemon thread
    * ``t.setDaemon(true);``
  * 线程组
    * ``ThreadGroup``
  * 处理未捕获异常的处理器
    * ``Thread.UncaughtExceptionHandler`` 接口
      * ``void uncaughtException(Thread t, Throwable e)``

* 同步

  * 竞争条件 race condition

  * 锁对象

    * ``ReetrantLock``类
    * 锁是可重入的
    * 锁保持一个持有计数hold count来跟踪lock方法的嵌套调用

  * 条件对象

    * 条件变量 condition variable
    * ``await signalAll``
    * 死锁dead lock

  * ``synchronized`` 关键字

    * ``wait notifyAll``

  * 同步阻塞

    * ```java
      synchronized(lock) {
          // do work
      }
      ```

  * 监视器monitor

  * Volatitle域

  * final变量

  * 原子性

    * ``AtomicInteger AtmoicIntegerArray``

  * 死锁deadlock

  * 线程局部变量

    * ``ThreadLocal``

  * 锁测试与超时

    * ``tryLock``

  * 读写锁

    * ``ReentrantReadWriteLock``

  * ``stop suspend resume``已弃用

* 阻塞队列 blocking queue

  * | 操作\特殊情况动作 | 抛出异常                        | 阻塞 | 返回null | 返回false |
    | ----------------- | ------------------------------- | ---- | -------- | --------- |
    | 添加元素          | add(IllegalStateException)      | put  |          | offer     |
    | 移出并返回头元素  | remove(NoSuchElementException)  | take | poll     |           |
    | 返回头元素        | element(NoSuchElementException) |      | peek     |           |

  * ``java.util.concurrent``

    * ``LinkedBlockingQueue LinkedBlockingDeque ArrayBlockingQueue PriorityBlockingQueue Delayed TransferQueue LinkedTransferQueue ``

* 线程安全的集合

  * ``java.util.concurrent``
    * 映射、有序集和队列 ``ConcurrentHashMap、ConcurrentSkipListMap ConcurrentSkipListSet ConcurrentLinkedQueue``
    * size通常需要遍历，不在常量时间内完成
    * 集合返回弱一致性（weakly consistent）迭代器：不一定能反映所有的修改，不会将同一个值返回两次，不会抛出``ConcurrentModificationException``异常
    * 并发散列映射列表可支持16个写线程同时执行，超出则其他线程被阻塞。可以指定更大数目，但一般没必要
    * Java SE 8中，散列映射将桶组织为树而不是列表，保证性能为``O(log(n))``
  * 映射条目的原子更新
    * ``compute computeIfPresent computeIfAbsent``
    * ``merge``
  * 并发散列映射的批操作
    * 3种不同的操作
      * 搜索 search
      * 归约 reduce
      * forEach
    * 每个操作有4个版本 ``operationKeys operationValues operation operationEntries``
    * 参数化阈值 parallelism threshold
  * 并发集视图 ``newKeySet keySet``
  * 写拷贝数组 ``CopyOnWriteArrayList CopyOnWriteArraySet``
  * 并行数组算法 ``Arrays.parallelSort  parrallelSetAll parallelPrefix``
  * 较早的线程安全集合 ``Vector Hashtable ``
    * 任何集合类都可以通过使用同步包装器``synchronization wrapper``变成线程安全

* Callable和Future

  * FutureTask包装器，可将Callable转换为Future和Runnable

* 执行器

  * 线程池thread pool
    * ``submit``
  * 执行器 Executor类有许多静态工作来构建线程池
    * ``newCachedThreadPool newFixedThreadPool newSingleThreadExecutor newScheduledThreadPool newSingleThreadScheduledExecutor``
  * 预定执行
    * ``ScheduledExecutorService``
  * 控制任务组 ``shutdownNow invokeAny``
  * Fork-Join框架
    * ``RecursiveTask<T> RecursiveAction``
    * 工作密取 work stealing
  * 可完成Future ``CompletableFuture``
    * 增加动作
      * ``thenApply thenCompose handle thenAccept whenComplete thenRun``
        * ``handle``处理异常
    * 组合对象
      * ``thenCombine thenAcceptBoth runAfterBoth applyToEither acceptEither runAfterEither``
      * ``static allOf``
      * ``static anyOf``

* 同步器

  * 共用集结点模式 common rendezvous patterns
  * CyclicBarrier 障栅
  * Phaser 
  * CountDownLatch 倒计时门栓
  * Exchanger 同步队列
  * Semaphore 信号量
  * SynchronousQueue 同步队列

* 线程与Swing

  * 略

