//输入一个十进制数N，将它转换成R进制数输出

//转换方法：十进制转换为R进制的方法是：对整数部分，用2去除，取其余数为转换后的二进制  
//整数数字，知道商为0的结束，注意得到的余数为所求结果的的地位；  
public class 进制转换 {
    public void reverse(int num, int toNum) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            int temp = num % toNum;
            switch (temp) {
                case 10:
                    sb.append("A");
                    break;
                case 11:
                    sb.append("B");
                    break;
                case 12:
                    sb.append("C");
                    break;
                case 13:
                    sb.append("D");
                    break;
                case 14:
                    sb.append("E");
                    break;
                case 15:
                    sb.append("F");
                    break;
                default:
                    sb.append(temp);
            }
            num = num / toNum;
        }
        System.out.println(sb.reverse());
    }

    @org.junit.Test
    public void test() {
        reverse(1024, 8);
    }
}
