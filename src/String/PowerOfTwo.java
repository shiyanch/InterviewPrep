package String;

/**
 * Created by shiyanch on 12/28/16.
 */
public class PowerOfTwo {
    public int power(String a) {
        if (a == null || a.length() == 0 || (a.charAt(a.length()-1) - '0')%2 != 0) {
            return 0;
        }
        if (a.length() == 1 && a.equals("2")) {
            return 1;
        }

        StringBuilder sb = new StringBuilder();
        int index = 0;
        int temp = 0;
        System.out.println(a);
        while (index < a.length() || temp != 0) {
            int cur = index < a.length() ? a.charAt(index)-'0':0;
            temp = 10*temp + cur;
            if (temp >= 2) {
                sb.append(temp/2);
                temp %= 2;
            }
            else if (index != 0){
                sb.append(0);
            }

            index++;
        }

        System.out.println(sb.toString());
        return power(sb.toString());
    }

    public static void main(String[] args) {
        System.out.println(new PowerOfTwo().power("147573952589676412928"));
    }
}
