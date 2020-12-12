package com.localnative.helloNative;

/**
 * 如果运行在Linux下,必须把当前目录添加到库路径中,实现的方式可以是通过设置 LD_LIBRARY_PATH
 * export LD_LIBRARY_PATH=.:$LD_LIBRARY_PATH
 * 或者设置java.library.path系统属性
 * java -Djava.library.path = .HelloNativeTest
 */
class HelloNativeTest
{  
   public static void main(String[] args)
   {  
      HelloNative.greeting();
   }

   static
   {
      System.loadLibrary("HelloNative");
   }
}
