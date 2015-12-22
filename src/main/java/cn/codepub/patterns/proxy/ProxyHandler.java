package cn.codepub.patterns.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * <p>
 * Created with IntelliJ IDEA. 2015/10/21 20:11
 * </p>
 * <p>
 * ClassName:ProxyHanlder
 * </p>
 * <p>
 * Description:使用JDK实现的动态代理
 * 动态代理的主要作用有三
 * ① Proxy类的代码量可以得到控制，由静态代理可以看出，随着业务变得庞大，代理类也会变得庞大，而动态代理不会出现这种情况
 * ② 可以实现AOP编程，其实Spring中的AOP就是一个很好的应用实例
 * ③ 可以解耦合，通过参数传递的形式就可以判断真实类，而不需要事先实例化，从而更加灵活多变
 * </P>
 *
 * @author Wang Xu
 * @version V1.0.0
 * @since V1.0.0
 */
public class ProxyHandler implements InvocationHandler {
    private Object tar;

    public ProxyHandler() {

    }

    public ProxyHandler(Object tar) {
        this.tar = tar;
    }

    public Object bind(Object tar) {
        this.tar = tar;
        return Proxy.newProxyInstance(tar.getClass().getClassLoader(), tar.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result;
        System.out.println("before method invoke...");
        System.out.println("Method: " + method);
        result = method.invoke(tar, args);
        System.out.println("after method invoke...");
        return result;
    }

    public static void testDynamicProxy() {
        System.out.println("-----------使用JDK动态代理-----------");
        Count count = (Count) new ProxyHandler().bind(new CountImpl());
        count.queryCount();
        count.updateCount();
    }

    public static void main(String[] args) {
        testDynamicProxy();
    }

}
