package esay;

/**
 * Created by yixinxin on 17/3/9.
 *
 * 28. Implement strStr()
 *
 Implement strStr().

 Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

 "" "" -> 0
 "a" "" -> 0

 *
 */
public class ImplementStrStr {

    // bugs
    public int myStrStr(String haystack, String needle) {
        if(haystack == null || haystack.length() == 0){
            if(haystack.equals(needle))
                return 0;
            else
                return -1;
        }

        if(needle == "" || needle.length() == 0)
            return 0;

        int index = -1, j = 0;

        for(int i = 0; i < haystack.length(); i++){
            if(j < needle.length() && haystack.charAt(i) == needle.charAt(j)){
                if(j == needle.length() - 1)
                    return haystack.length() - needle.length() - 1;
                j++;
            }else {
                j = 0;
                index = -1;
            }
        }

        return index;
    }

    // another way 16ms
    public int strStr2(String haystack, String needle){
        for(int i = 0; ; i++){
            for(int j = 0; ; j++){
                if(j == needle.length())
                    return i;
                if(i + j == haystack.length()) // i + j : haystack[i + j], the start is i, the j th character
                    return -1;
                if(needle.charAt(j) != haystack.charAt(i + j))
                    break;
            }
        }
    }
    // another way  7ms
    public int strStr3(String haystack, String needle) {
        int hl = haystack.length();
        int nl = needle.length();

        if(hl < nl)
            return -1;
        else if(nl == 0)
            return 0;

        int threshold = hl -nl;
        // need = , when i = threshold, then like "aaab" "aab", i = 1
        for(int i = 0; i <= threshold; i++){
            if(haystack.substring(i, i + nl).equals(needle))
                return i;
        }

        return -1;
    }

    // KMP
    // http://www.ruanyifeng.com/blog/2013/05/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm.html

    public static void main(String[] args){
        ImplementStrStr implementStrStr = new ImplementStrStr();

        System.out.println(implementStrStr.strStr2("aaab", "aab"));
    }

}


