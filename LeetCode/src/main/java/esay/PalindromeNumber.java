package esay;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yixinxin on 17/1/11.
 * 9. Palindrome Number
 * Determine whether an integer is a palindrome. Do this without extra space.
 * <p>
 * 设n是一任意自然数。若将n的各位数字反向排列所得自然数n1与n相等，则称n为一回文数。例如，若n=1234321，则称n为一回文数；但若n=1234567，则n不是回文数。[1]
 * 1.偶数个的数字也有回文数124421
 * 2.小数没有回文数
 * 3.在自然数中，最小的回文数是0
 *
 * 处理负数！！！
 * 不要用过多的空间！！！
 *
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        List<Integer> list = new ArrayList<Integer>();
        int quotient = x; // 商
        int remainder = 0; // 余数

        if (x == 0)
            return true;
        else if(x < 0)
            return false;
        else{
            while (quotient != 0) {
                quotient = x / 10;
                remainder = x % 10;
                x = quotient;

                if (quotient != 0) {
                    list.add(remainder);
                } else {
                    if (remainder != 0) {
                        list.add(remainder);
                    }
                }
            }

            int length = list.size();
            for (int i = 0; i < length / 2; i++) {
                if (list.get(i) != list.get(length - 1 - i)) { // 注意-i
                    return false;
                }
            }
            return true;
        }
    }

    // smarter way
    public boolean isPalindromeNew(int x) {
        //negative numbers are not palindrome
        if (x < 0)
            return false;

        // initialize how many zeros, 12321 -> div = 10000
        int div = 1;
        while (x / div >= 10) {
            div *= 10;
        }

        while (x != 0) {
            int left = x / div;
            int right = x % 10;

            if (left != right)
                return false;

            // remove the head and tail number
            x = (x % div) / 10; // 取余去掉头，除10去掉尾
            div /= 100;
        }

        return true;
    }

    public static void main(String[] args) {
        PalindromeNumber palindromeNumber = new PalindromeNumber();
        System.out.println("1 " + palindromeNumber.isPalindrome(123321));
        System.out.println("2 " + palindromeNumber.isPalindrome(12321));
        System.out.println("3 " + palindromeNumber.isPalindrome(1234));
        System.out.println("4 " + palindromeNumber.isPalindrome(0));
        System.out.println("5 " + palindromeNumber.isPalindrome(3));
        System.out.println("6 " + palindromeNumber.isPalindrome(-23));
        System.out.println("7 " + palindromeNumber.isPalindrome(-3));

        System.out.println("1 " + palindromeNumber.isPalindromeNew(123321));
        System.out.println("2 " + palindromeNumber.isPalindromeNew(12321));

    }
}
