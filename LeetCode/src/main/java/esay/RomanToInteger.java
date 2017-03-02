package esay;

/**
 * Created by yixinxin on 17/1/13.
 * 13. Roman to Integer
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 *
 *  I   1
 *  V   5
 *  X   10
 *  L   50
 *  C   100
 *  D   500
 *  M   1000
 *
 *  规则：
 *  相同的数字连写、所表示的数等于这些数字相加得到的数、如：Ⅲ=3；
 *  小的数字在大的数字的右边、所表示的数等于这些数字相加得到的数、 如：Ⅷ=8、Ⅻ=12；
 *  小的数字、（限于 Ⅰ、X 和 C）在大的数字的左边、所表示的数等于大数减小数得到的数、如：Ⅳ=4、Ⅸ=9；
 *  正常使用时、连写的数字重复不得超过三次；
 *  在一个数的上面画一条横线、表示这个数扩大 1000 倍。
 *
 *  注意事项：
 *  基本数字 Ⅰ、X 、C 中的任何一个、自身连用构成数目、或者放在大数的右边连用构成数目、都不能超过三个；放在大数的左边只能用一个；
 *  不能把基本数字 V 、L 、D 中的任何一个作为小数放在大数的左边采用相减的方法构成数目；放在大数的右边采用相加的方式构成数目、只能使用一个；
 *  I只能用在V和X左边；
 *  X只能用在L和C左边；
 *  C只能用在D和M左边。
 *
 */
public class RomanToInteger {

    public int convert(char c){
        int digit = 0;
        // byte、short、char、int、enum（Java 5）、String(Java 7)
        switch (c){
            case 'I':
                digit = 1;
                break;
            case 'V':
                digit = 5;
                break;
            case 'X':
                digit = 10;
                break;
            case 'L':
                digit = 50;
                break;
            case 'C':
                digit = 100;
                break;
            case 'D':
                digit = 500;
                break;
            case 'M':
                digit = 1000;
                break;
            default:
                break;
        }

        return digit;
    }

    public int romanToInt(String s){
        int result = 0;
        int digit = 0, digitNext = 0;
        char digitStr = 0, digitStrNext = 0;

        // handle length == 1
        if(s.length() <= 0)
            return 0;
        else if (s.length() == 1){
            digitStr = s.charAt(0);
            digit = this.convert(digitStr);
            return digit;
        }

        for(int i = 0; i < s.length() - 1; i++){
            digitStr = s.charAt(i);
            digit = this.convert(digitStr);
            digitStrNext = s.charAt(i + 1);
            digitNext = this.convert(digitStrNext);

            if(digit < digitNext)
                result -= digit;
            else
                result += digit;

            if(i == s.length() - 2)
                result += digitNext;

        }

        return result;
    }

    public static void main(String[] args){
        RomanToInteger romanToInteger = new RomanToInteger();
        System.out.println(romanToInteger.romanToInt("D"));
        System.out.println(romanToInteger.romanToInt("C"));
        System.out.println(romanToInteger.romanToInt("M"));
        System.out.println(romanToInteger.romanToInt("I"));
        System.out.println(romanToInteger.romanToInt("III"));
        System.out.println(romanToInteger.romanToInt("IV"));
        System.out.println(romanToInteger.romanToInt("MCMLXXX"));

    }
}
