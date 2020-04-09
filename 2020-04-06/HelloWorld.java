
/*
注意:
	1.一个java文件中，只能有一个public的类
	2.类名需要和文件名相同
	3.类名一定采用大驼峰的形式命名每一个类都会生成一个字节码文件
	5.加中文不能编译，因为此文档是ASCII编译的，字节码格式不匹配导致的
		Windows创建创建一个文本文件的时候，默认是utf-8,所以编译的时候需要
		javac HelloWorld.java -encoding UTF-8
*/

class A{
	
}

//如果一个类是public的，那么这个类的类名一定要和文件名相同，一个java文件中只能有一个public类
public class HelloWorld{
	public static void main(String[] args){
		
		//如果一个局部变量不能够初始化，那么将无法运行
		int a;
		System.out.println(a);
		//System.out.println("HelloWorld");
	}
}


//如何运行Java程序？
//		磁盘上的HelloWorld.java 通过编译
//会生成A.class 和 HelloWorld.class两个文件？	答：因为方便使用。如果需要HelloWorld这个类，那么就加载对应的字节码文件
//Java中用到哪个类，就加载哪个类

//JDK包含JRE，JRE包含JVM，JVM是一台虚拟的运行机器，实现了一次编译，到处运行


//面试问题：
//1.main方法为什么是静态的？	
//		答：正因为main方法是静态的，JVM调用这个方法就不需要创建任何包含这个main方法的实例。
//			因为C和C++同样有类似的main方法作为程序执行的入口。
//			如果main方法不声明为静态的，JVM就必须创建main类的实例，因为构造器可以被重载，JVM就没法确定调用哪个main方法。
//			静态方法和静态数据加载到内存就可以直接调用而不需要像实例方法一样创建实例后才能调用，如果main方法是静态的，那么它就会被加载到JVM上下文中成为可执行的方法。

//2.String[] args作用？			答：
//3.讲一下双亲委派模型			答：
//4.讲一下类加载器				答: