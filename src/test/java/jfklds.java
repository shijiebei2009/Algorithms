import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>
 * Created with IntelliJ IDEA. 2015/11/8 21:43
 * </p>
 * <p>
 * ClassName:jfklds
 * </p>
 * <p>
 * Description:TODO
 * </P>
 *
 * @author Wang Xu
 * @version V1.0.0
 * @since V1.0.0
 */

class MyPerson implements Cloneable, Serializable {
    public String name;
    public int age;
    public MyPerson son;

    public MyPerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public MyPerson(String name, int age, MyPerson son) {
        this(name, age);
        this.son = son;
    }

    public Object deepClone() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ObjectOutputStream oo = new ObjectOutputStream(bo);
        oo.writeObject(this);
        ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
        ObjectInputStream oi = new ObjectInputStream(bi);
        return oi.readObject();
    }

    Hashtable hashtable = new Hashtable();

    @Override
    protected Object clone() throws CloneNotSupportedException {
        MyPerson myPerson = null;
        try {
            myPerson = (MyPerson) super.clone();
            myPerson.son = (MyPerson) son.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return myPerson;
    }
}

public class jfklds implements Cloneable {
    @Before
    public void setUp() {

    }

    @Test
    public void testClone() throws IOException, ClassNotFoundException {
        MyPerson son1 = new MyPerson("son1", 11);
        MyPerson myPerson = new MyPerson(son1.name, son1.age, son1);
        MyPerson myPerson1 = (MyPerson) myPerson.deepClone();
        myPerson1.son.name = "test";
        myPerson.son.name = "我又改了";
        System.out.println(myPerson.son.name);
        System.out.println(myPerson1.son.name);

    }

    @Test
    public void test() throws UnsupportedEncodingException {
        Assert.assertEquals(10, 10);
        Assert.assertEquals(10, 10);
        int nums[] = new int[]{1, -2, 3, 10, -4, 7, 2, -5};
        int max = Integer.MIN_VALUE;
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        System.out.println(max);
    }

    @Test
    public void test2() {
        int n = 12;
        for (int i = 0; i <= 12; i++) {
            if (i >= 10 && i / 10 == 1) {
                System.out.println(i);
            } else {
                if (i == 1) {
                    System.out.println(i);
                }
            }
        }
    }

    @Test
    public void test3() {
        List<Integer>
                list = new ArrayList<>();
        list.add(1);
        while (list.size() < 1500) {
            int min = Integer.MAX_VALUE;
            int lastNum = list.get(list.size() - 1);
            Iterator<Integer> iterator = list.iterator();
            while (iterator.hasNext()) {
                Integer next = iterator.next();
                if (next * 2 < min && next * 2 > lastNum) {
                    min = next * 2;
                }
                if (next * 3 < min && next * 3 > lastNum) {
                    min = next * 3;
                }
                if (next * 5 < min && next * 5 > lastNum) {
                    min = next * 5;
                }
            }
            list.add(min);
        }

        System.out.println(list.size());
        System.out.println(list);
    }

    @Test
    public void testPinyin() {
        String str = "你好世界";
        PinyinHelper.convertToPinyinString(str, ",", PinyinFormat.WITH_TONE_MARK); // nǐ,hǎo,shì,jiè
        PinyinHelper.convertToPinyinString(str, ",", PinyinFormat.WITH_TONE_NUMBER); // ni3,hao3,shi4,jie4
        PinyinHelper.convertToPinyinString(str, ",", PinyinFormat.WITHOUT_TONE); // ni,hao,shi,jie
        PinyinHelper.getShortPinyin(str); // nhsj
    }

}
