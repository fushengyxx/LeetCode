package esay;

/**
 * Created by yixinxin on 17/3/13.
 *
 * 66. Plus One
 Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.

 You may assume the integer do not contain any leading zero, except the number 0 itself.

 The digits are stored such that the most significant digit is at the head of the list.
 *
 */
public class PlusOne {
    // bugs
    // use algorithms
    public int[] plusOne(int[] digits) {
        String intStr = "";
        int n = digits.length;
        for(int i = 0; i < n; i++){
            intStr += digits[i];
        }

        int result = Integer.valueOf(intStr) + 1;
        String resultStr = String.valueOf(result);
        int[] resultArray = new int[resultStr.length()];

        for(int i = 0; i < resultStr.length(); i++){
            // charAt是ASCII码
            resultArray[i] = Integer.valueOf(resultStr.charAt(i)+"");
            System.out.println(resultArray[i]);
        }
        return resultArray;
    }

    // method 1
    public int[] plusOne1(int[] digits){
        int n = digits.length;
        for(int i = n - 1; i >= 0; i--){
            if(digits[i] < 9){
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] newNumber = new int[n + 1];
        newNumber[0] = 1;
        return newNumber;
    }

    public static void main(String[] args){
        PlusOne plusOne = new PlusOne();
        int[] digits = {9,9,9};
        System.out.println(plusOne.plusOne1(digits));
    }
}
