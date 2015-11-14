/**
 * <p>
 * Created with IntelliJ IDEA. 2015/8/23 10:49
 * </p>
 * <p>
 * ClassName:Test
 * </p>
 * <p>
 * Description:TODO
 * </P>
 *
 * @author Wang Xu
 * @version V1.0.0
 * @since V1.0.0
 */
public class Test {
    public static void main(String[] args) {
        int a[] = new int[]{88, 459, 5262, 88, -17, 667, 88, 667, -17, 459, 5262};
        int temp = 0;
        for (int i : a) {
            temp = temp ^ i;
        }
        System.out.println(temp);
    }
}
