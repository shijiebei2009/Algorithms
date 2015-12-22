package cn.codepub.patterns.proxy;

/**
 * 静态代理、JDK动态代理、CGLib代理的辅助类
 */
interface Count {
    //定义查询账户方法
    void queryCount();

    //定义更新账户方法
    void updateCount();
}

public class CountImpl implements Count {
    @Override
    public void queryCount() {
        System.out.println("the method of query count...");
    }

    @Override
    public void updateCount() {
        System.out.println("the method of update count...");
    }
}