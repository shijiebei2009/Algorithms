import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

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
public class jfklds implements Cloneable {
    @Before
    public void setUp() {

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
