package esay;

/**
 * Created by yixinxin on 17/3/9.
 *
 * 38. Count and Say
 *
 The count-and-say sequence is the sequence of integers beginning as follows:
 1, 11, 21, 1211, 111221, ...

 1 is read off as "one 1" or 11.
 11 is read off as "two 1s" or 21.
 21 is read off as "one 2, then one 1" or 1211.
 Given an integer n, generate the nth sequence.

 Note: The sequence of integers will be represented as a string.

 ******************************************************************************
 analysis：the nth is count and say (n-1)th
 1.     1
 2.     11
 3.     21
 4.     1211
 5.     111221
 6.     312211
 7.     13112221
 8.     1113213211
 9.     31131211131221
 10.   13211311123113112211

 *
 */
public class CountAndSay {
    // not count and say any integer, but the nth integer
    public String countAndSay(int n) {
        int digit = 0;
        String digitsStr = "";
        while (n > 0){
            digit = n % 10;
            n = n / 10;
            digitsStr += digit;
        }

        int count = 0;
        char pre = 0;
        String resultStr = "";
        if(digitsStr.length() == 1)
            return 1 + digitsStr;
        for(int i = digitsStr.length() -1; i > 0; i--){
            if(i == 1){
                if(digitsStr.charAt(i) == digitsStr.charAt(i - 1)){
                    count += 2;
                    pre = digitsStr.charAt(i);
                    resultStr = resultStr + count + pre;
                }else {
                    resultStr = resultStr + count + pre + 1 + digitsStr.charAt(i - 1);
                }
            }

            if(digitsStr.charAt(i) == digitsStr.charAt(i - 1)){
                count++;
                pre = digitsStr.charAt(i);
            }else{
                resultStr = resultStr + count + pre;
                count = 1;
            }
        }

        return resultStr;
    }

    // another way
    public String countAndSay2(int n) {
        if( n <= 0) return "-1";
        if(n == 1)
            return "1";

        String result = "1";

        for(int i = 1; i < n; i++){
            result = build(result);
        }
        return result;
    }

    private String build(String result){
        StringBuilder builder = new StringBuilder();
        int p = 0;
        while(p < result.length()){
            char val = result.charAt(p);
            int count = 0;

            while (p < result.length() && result.charAt(p) == val){
                p++;
                count++;
            }
            builder.append(String.valueOf(count));
            builder.append(val);
        }
        return builder.toString();
    }

    public static void main(String[] args){
        CountAndSay countAndSay = new CountAndSay();
        System.out.println(countAndSay.countAndSay2(3));
    }
}
