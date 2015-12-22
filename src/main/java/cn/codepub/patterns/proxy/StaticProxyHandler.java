package cn.codepub.patterns.proxy;

/**
 * <p>
 * Created with IntelliJ IDEA. 2015/10/21 19:33
 * </p>
 * <p>
 * ClassName:CountProxy
 * </p>
 * <p>
 * Description:静态代理的实现
 * </P>
 *
 * @author Wang Xu
 * @version V1.0.0
 * @since V1.0.0
 */
public class StaticProxyHandler implements Count {
    private Count count;

    //默认构造器
    public StaticProxyHandler() {

    }

    //接收被代理类实例的构造器
    public StaticProxyHandler(Count count) {
        this.count = count;
    }

    @Override
    public void queryCount() {
        System.out.println("before method invoke...");
        //调用委托类的方法
        count.queryCount();
        System.out.println("after method invoke...");
    }

    @Override
    public void updateCount() {
        System.out.println("before method invoke...");
        //调用委托类的方法
        count.updateCount();
        System.out.println("after method invoke...");
    }

    public static void main(String[] args) {
        testStaticProxy();
    }

    public static void testStaticProxy() {
        System.out.println("-----------使用静态代理-----------");
        CountImpl countImpl = new CountImpl();
        StaticProxyHandler staticProxyHandler = new StaticProxyHandler(countImpl);
        staticProxyHandler.queryCount();
        staticProxyHandler.updateCount();
    }
}

