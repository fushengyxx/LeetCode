package esay;

/**
 * Created by yixinxin on 17/1/2.
 */
public class ReverseInteger {

    public int reverse_m(int x){
        int result = 0;
        String xStr = "", resultStr = "" ;

        int xSbs = Math.abs(x);


        xStr = String.valueOf(xSbs);
        for(int i = xStr.length() - 1; i >= 0; i--){
            resultStr += xStr.charAt(i);
        }
        result = Integer.valueOf(resultStr);

        if (x < 0)
            result *= -1;

        return result;
    }

    public int reverse(int x) {
        //flag marks if x is negative
        boolean flag = false;
        if (x < 0) {
            flag = true;
        }

        int res = 0;
        int num = Math.abs(x);

        while (num > 0) {
            if (res > (Integer.MAX_VALUE - num%10)/10)
                return 0;

            int mod = num % 10;
            res = res * 10 + mod;

            num = num / 10;
        }

        if (flag) {
            res = 0 - res;
        }

        return res;
    }

    public static void main(String[] args){
        ReverseInteger reverseInteger = new ReverseInteger();

        System.out.print(reverseInteger.reverse(1534236469));
    }
}
