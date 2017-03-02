package esay;

/**
 * Created by yixinxin on 17/1/10.
 *
 * 8. String to Integer (atoi)
 * Implement atoi to convert a string to an integer.
 *
 * 2147483647  -2147483648
 *
 * 1. str = ""
 * 2. 正负号首先处理
 * 3. MAX，MIN，且不能用绝对值处理，应为abs(MIN) = abs(MAX) + 1
 * 4. char是字符，表示字符时是'1'，但在数学运算中用的是ASCII码，对应49
 * 5. 负数 / 正数 = 负数……负数，商和余数都是负数
 * 6. 考虑"+-5"的情况，输出0
 * 7. 考虑空格，"   +0 123" 输出0
 */
public class StringToInteger {
    public int myAtoi(String str){
        int result = 0;
        char n = 0; // char 是16位的，默认是0，也就是'\0'，表示结束
        String resultStr = "";
        boolean isNeg = false;
        int flag = 0;
        int numbers = 0;

        if (str != null && str != "" && str.length() > 0){
            for (int i = 0; i < str.length(); i++){
                n = str.charAt(i);

                if(n == 32) {// 空格
                    if(numbers == 0)
                        continue;
                    else
                        break;
                }
                else if(n == 43) {// 加号
                    if(resultStr =="" && flag < 1) {
                        isNeg = false;
                        flag++;
                        numbers++;
                    }
                    else
                        break; // 不直接return，防止有"-23+3"等情况发生
                }
                else if(n == 45) {// 减号
                    if(resultStr =="" && flag < 1) {
                        isNeg = true;
                        flag++;
                        numbers++;
                    }
                    else
                        break;
                }
                else {
                    if(n >= 48 && n <= 57) {// ASCII码中0 1 2 …… 9
                        if(isNeg == false){
                            if (result > Integer.MAX_VALUE / 10)      // 大于商
                                return Integer.MAX_VALUE;
                            else if (result == Integer.MAX_VALUE / 10) // 大于余数
                                if(Integer.valueOf(n + "") >= Integer.MAX_VALUE % 10)
                                    return Integer.MAX_VALUE;
                        } else {
                            if ((0 - result) < Integer.MIN_VALUE / 10)
                                return  Integer.MIN_VALUE;
                            else if((0 - result) == Integer.MIN_VALUE / 10)
                                if((0 - Integer.valueOf(n + "")) <= Integer.MIN_VALUE % 10)
                                    return Integer.MIN_VALUE;
                        }

                        resultStr += n;
//                        if(isNeg == true && resultStr.equals(String.valueOf(Integer.MIN_VALUE)))
//                            return Integer.MIN_VALUE;

                        result = Integer.valueOf(resultStr);
                        numbers++;

//                        System.out.println("111  " + Integer.valueOf(n));
//                        System.out.println("222  " + n);
//                        System.out.println("000  " + (0 - n));
                    }
                    else
                        break;
                }
            }

        }else {
            return 0;
        }

        return isNeg ? (0 - result) : result;
    }

    public static void main(String[] args){
        StringToInteger sti = new StringToInteger();
        System.out.println(sti.myAtoi("1234"));
        System.out.println(sti.myAtoi(" 123 4 "));
        System.out.println(sti.myAtoi("s12 34"));
        System.out.println(sti.myAtoi("1234s "));
        System.out.println(sti.myAtoi("ss123s4ss"));
        System.out.println(sti.myAtoi("a1s234dd  s23"));
        System.out.println(sti.myAtoi("as1 234 s 2w4"));
        System.out.println(sti.myAtoi(""));

        System.out.println(sti.myAtoi("-214748369"));
        System.out.println(sti.myAtoi("-2147483648"));
        System.out.println(sti.myAtoi("2147483648"));
        System.out.println(sti.myAtoi("2147483647"));

        System.out.println(sti.myAtoi("++"));
        System.out.println(sti.myAtoi("+-"));
        System.out.println(sti.myAtoi("++5"));
        System.out.println(sti.myAtoi("+56-3"));
        System.out.println(sti.myAtoi("+-5"));
        System.out.println(sti.myAtoi("   023"));
        System.out.println(sti.myAtoi("   +0 123"));

        System.out.println(Integer.MIN_VALUE % 10);
        System.out.println(Integer.MIN_VALUE / 10);
        System.out.println(Integer.valueOf("-2147483"));
    }
}
