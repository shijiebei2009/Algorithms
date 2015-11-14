package cn.codepub.patterns.core;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 * Created with IntelliJ IDEA. 2015/10/22 13:55
 * </p>
 * <p>
 * ClassName:Singleton
 * </p>
 * <p>
 * Description:饿汉模式天生线程安全，而且实现简单，在此不予提供，本类为懒汉模式，使用双跳检测的多线程安全的单例模式
 * </P>
 *
 * @author Wang Xu
 * @version V1.0.0
 * @since V1.0.0
 */
public class Singleton {
    private Singleton() {

    }

    private static volatile Singleton singleton;

    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    public static void main(String[] args) {
        Set<Singleton> set = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            Singleton singleton = Singleton.getInstance();
            boolean add = set.add(singleton);
            //可以看到除了第一次，之后每次获取的实例和第一次都是同一实例
            System.out.println(add);
        }

    }

}
