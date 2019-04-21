package exercise.reflect_0421.ClassLoader;

/*
1.AppClassLoader -> ExtClassLoader ->null(Bootstrap)
2.自定义ClassLoader(高级特性)
  AppClassLoader(应用程序类加载器)(classpath)
  ExtClassLoader(扩展类加载器)(jre\lib\ext)
  Bootstrap(启动类加载器)(jre\lib\rt.jar)
3.类加载器的双亲委派模型
 3.1处了顶层类加载器没有弗雷加载器，其他的类都有父类加载器
 3.2类加载的流程：加载一个类都要经过顶层的类加载器，顶层类加载器如果在它加载的范围内找不到该类，就会反馈给子类加载器
4. 同一个类加载器加载同一个类只有一个对应的Class对象
   不同的类加载器加载同一个类，对应的Class对象不同
*/
public class TestClassLoder {
    public static void main(String[] args) {
        Class calssz = TestClassLoder.class;
        //抽象，不能直接new,也不能用反射取，只能用getClassLoader()
        ClassLoader classLoader = calssz.getClassLoader();


    }
}
