1.开发环境：
1）操作系统：Windows 7
2）IDE：IntelliJ IDEA Community Edition 2020.1.2 x64
3）语言：Java (jdk 1.8.0_131)
4）项目管理工具：Maven 4.0.0

2.Source Code
所有源代码均位于/src/main/java/org.airwallex目录下：
1）App.java
    该计算器的启动类，运行App类的main()函数即可运行，以“空行”作为程序退出标志。
    运行期间用户可以从console输入命令，如果输入为空行（即什么都不输入，直接回车），则程序运行结束。

2）MyStack.java
    MyStack类用于记录数据，包含三个栈，一个就是需要展示给用户的，还有两个用于回溯（回溯采用增量备份方式）。

3）Operator.java
    Operator类为一个抽象类。该文件里的Plus,Minus,Multiply,Undo等等运算操作都继承了Operator。
    每个Operator都有一个operation()方法，该方法将具体执行对应的运算操作，并返回一个运行状态码：
    （1）"S001"代表运行成功；
    （2）"E001"代表insufficient parameter；
    （3）"E002"代表待开根数小于0；
    （4）"E003"代表除数为0；
    由于目前仅要求Warning:operator <operator> (position: <pos>): insufficient parameters，
    所以“E002"和"E003"的报错内容暂时和"E001"一样，之后随时可以根据需求变化来调整。

    注：Operator里定义了一个Waiting类：
        由于要求中没有说当接收到合法字符以外的时候怎么处理，所以就暂时定义了一个Waiting类，用于处理不合法输入。
        目前Waiting类的operation()是什么都不做，但可以后期讨论一下相应对策，然后根据需求改写Waiting类的操作。

4）OneLineProcessor.java
    OneLineProcessor类用于处理用户输入的一行指令，可以实现简单的报错机制（比如Step 1仅要求的insufficient parameter）。

5）OneWordProcessor.java
    OneWordProcessor类用于处理每一个指令，并根据指令内容调度合适的Operator对象。

3. Unit Tests (JUnit)
所有测试代码和用例均位于/src/test/java/org.airwallex目录下：
1)AppTest.java 用于测试计算器程序能否正常按要求进行运算
2)OneLineProcessorTest.java 用于测试OneLineProcessor类能否正常处理一行指令，以及能否正确及时地给出Warning且终止对该行后续命令的执行
3)OneWordProcessorTest.java 用于测试OneWordProcessor类能否依据接收到的指令调度正确的运算操作类Operator
4)MyStackTest.java 用于测试MyStack类的读入数据、显示数据功能
5)PlusTest/MinusTest/MultiplyTest/DivideTest/SqrtTest.java 都是用于测试对应运算类功能
6)ClearTest.java 用于测试Clear类能否正常执行
7)UndoTest.java 用于测试是否能够恢复上一步操作（Undo自己不算）前的内容（哪怕是Clear）