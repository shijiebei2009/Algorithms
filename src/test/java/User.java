import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>
 * Created with IntelliJ IDEA. 2015/8/23 11:07
 * </p>
 * <p>
 * ClassName:User
 * </p>
 * <p>
 * Description:TODO
 * </P>
 *
 * @author Wang Xu
 * @version V1.0.0
 * @since V1.0.0
 */
public class User implements Runnable {
    private Integer id;//用户ID
    private double buy;//每个人的购买金额

    private static double min = 1000;//最小起购购买
    private static double total = 2000000;//产品最大售卖金额
    private static double max = 20000;//最大购买
    private static int userNum = (int) (total / min);//最多会有这么多人购买
    private static Map<Integer, User> users = new ConcurrentHashMap<Integer, User>();

    public User() {
    }

    public User(Integer id, double buy) {
        this.id = id;
        this.buy = buy;
    }


    public void run() {
        System.out.println("模拟下单操作及其它各种操作");
    }

    public static void main(String[] args) {
        int count = (int) (Math.random() * userNum + 1000);//模拟有多少人进行购买操作

        for (int i = 0; i < count; i++) {
            int id = (int) (Math.random() * userNum + 1);
            double buyNum = (int) (Math.random() * (max - min) + min);
            User u;
            if (users.keySet().contains(id)) {
                //已存在该用户
                u = users.get(id);
                if (total - buyNum > 0) {
                    //可以购买
                    total = total - buyNum;
                    u.buy = u.buy + buyNum;
                } else {
                    //产品已售罄
                    System.out.println("产品售罄，购买失败！");
                }

            } else {
                //不存在该用户
                u = new User(id, buyNum);
                users.put(id, u);
            }
            Thread t = new Thread(u);
            t.start();
        }

        Iterator<Integer> iterator = users.keySet().iterator();
        while (iterator.hasNext()) {
            int id = iterator.next();
            User user = users.get(id);
            System.out.println("第" + user.id + "号用户购买了" + user.buy + "元！");
        }

        System.out.println("最后剩余金额：" + total);
        System.out.println("共有" + users.size() + "人购买了");
    }


}


