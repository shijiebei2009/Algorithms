package cn.codepub.algorithms;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * <p>
 * Created with IntelliJ IDEA. 2015/10/21 22:16
 * </p>
 * <p>
 * ClassName:CGLibProxyHandler
 * </p>
 * <p>
 * Description:使用CGLib实现动态代理
 * 为什么要有CGLib动态代理呢？因为JDK的动态代理机制只能代理实现了接口的类，而不能实现接口的类就不能实现JDK的动态代理，CGLib是针对类来实现代理的
 * 它的原理是对指定的目标类生成一个子类，并覆盖其中方法实现增强，但因为采用的是继承，所以不能对final修饰的类进行代理
 * </P>
 *
 * @author Wang Xu
 * @version V1.0.0
 * @since V1.0.0
 */
public class CGLibProxyHandler implements MethodInterceptor {

    private Object tar;//被代理对象

    /**
     * @param tar 使用被代理对象
     * @return 需要将返回结果强转成被代理对象
     */
    public Object getInstance(Object tar) {
        this.tar = tar;
        Enhancer enhancer = new Enhancer();
        //设置被代理对象为代理类的超类
        enhancer.setSuperclass(this.tar.getClass());
        //设置回调方法
        enhancer.setCallback(this);
        //创建代理对象
        return enhancer.create();
    }

    /**
     * 回调方法
     *
     * @param o
     * @param method
     * @param objects
     * @param methodProxy
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before method invoke...");
        System.out.println(method);
        Object res = methodProxy.invokeSuper(o, objects);
        System.out.println("after method invoke...");
        return res;
    }

    @org.junit.Test
    public void testCGLibProxy() {
        System.out.println("-----------使用CGLib动态代理-----------");
        CGLibProxyHandler cgLibProxyHandler = new CGLibProxyHandler();
        Count count = (Count) cgLibProxyHandler.getInstance(new CountImpl());
        count.queryCount();
        count.updateCount();
    }
}
