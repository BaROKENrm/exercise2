package day131;
//415. 字符串相加
public class day131exercise_1 {
    public String addStrings(String num1, String num2) {
        StringBuffer sb = new StringBuffer();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int dig = 0;
        while(i >= 0 || j >= 0 || dig != 0){
            int x = (i < 0 ? 0 : num1.charAt(i) - '0');
            int y = (j < 0 ? 0 : num2.charAt(j) - '0');
            int sum = x + y + dig;
            sb.append(sum % 10);
            dig = sum / 10;
            i --;
            j --;
        }
        sb.reverse();
        return sb.toString();
    }
}
