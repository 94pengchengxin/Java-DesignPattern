package singleton;


/*
 * @description 6种方法实现单例模式
 * @author Shawn
 * @time 2024/11/9 15:44
 */

// 一般情况下，不建议使用第 1 种和第 2 种懒汉方式，建议使用第 3 种饿汉方式。
// 只有在要明确实现 lazy loading 效果时，才会使用第 5 种登记方式。
// 如果涉及到反序列化创建对象时，可以尝试使用第 6 种枚举方式。
// 如果有其他特殊的需求，可以考虑使用第 4 种双检锁方式。

// 1.懒汉式，线程不安全
// public class SingleObject {
//    private static SingleObject instance = new SingleObject();
//    private SingleObject(){}
//    public static SingleObject getInstance(){
//       return instance;
//    }
// }

// 2.懒汉式，线程安全（+ synchronized）
// public class Singleton {
//    private static Singleton instance;
//    private Singleton (){}
//    public static synchronized Singleton getInstance() {
//        if (instance == null) {
//            instance = new Singleton();
//        }
//        return instance;
//    }
// }

// 3.饿汉式（天生线程安全，它基于 classloader 机制避免了多线程的同步问题）
 public class Singleton {
    private static Singleton instance = new Singleton();
    private Singleton (){}
    public static Singleton getInstance() {
       return instance;
    }
 }

// 4.双检锁/双重校验锁（DCL，即 double-checked locking）
// public class Singleton {
//    private volatile static Singleton singleton;
//    private Singleton (){}
//    public static Singleton getSingleton() {
//       if (singleton == null) {
//           synchronized (Singleton.class) {
//               if (singleton == null) {
//                   singleton = new Singleton();
//               }
//           }
//       }
//       return singleton;
//    }
// }

// 5.登记式/静态内部类
// public class Singleton {
//    private static class SingletonHolder {
//    private static final Singleton INSTANCE = new Singleton();
//    }
//    private Singleton (){}
//    public static final Singleton getInstance() {
//        return SingletonHolder.INSTANCE;
//    }
// }

// 6.枚举（实现单例模式的最佳方法）
// 它更简洁，自动支持序列化机制，绝对防止多次实例化。
//这种方式是 Effective Java 作者 Josh Bloch 提倡的方式，
// 它不仅能避免多线程同步问题，而且还自动支持序列化机制，防止反序列化重新创建新的对象，绝对防止多次实例化。
// 不过，由于 JDK1.5 之后才加入 enum 特性，用这种方式写不免让人感觉生疏，在实际工作中，也很少用。
// public enum Singleton {
//     INSTANCE;
//     public void whateverMethod() {
//     }
// }