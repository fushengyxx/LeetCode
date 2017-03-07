package esay;

/**
 * Created by yixinxin on 17/3/7.
 *
 * 14. Longest Common Prefix
 * Write a function to find the longest common prefix string amongst an array of strings.
 */
public class LongestCommonPrefix {
    // 18ms
    public String longestCommonPrefix(String[] strs) {
        String prefix = "";

        if(strs == null || strs.length <= 0)
            return "";

        int minLength = Integer.MAX_VALUE;
        for(int i = 0; i < strs.length; i++){
            minLength = minLength < strs[i].length() ? minLength : strs[i].length();
        }
        System.out.println("min length " + minLength); // with this line, you need extra 10ms

        char character = 0;
        int j = 0;
        for(int i = 0; i< minLength; i++){
            character = strs[0].charAt(i);
            for(j = 0; j < strs.length; j++){
                if(character != strs[j].charAt(i))
                    return prefix;
            }
            prefix += character;
        }

        return prefix;
    }

    // use StringBuilder insteadof +
    // 11ms
    public String longestCommonPrefix2(String[] strs) {
        StringBuilder prefix = new StringBuilder();

        if(strs == null || strs.length <= 0)
            return "";

        int minLength = Integer.MAX_VALUE;
        for(int i = 0; i < strs.length; i++){
            minLength = minLength < strs[i].length() ? minLength : strs[i].length();
        }

        char character = 0;
        int j = 0;
        for(int i = 0; i< minLength; i++){
            character = strs[0].charAt(i);
            for(j = 0; j < strs.length; j++){
                if(character != strs[j].charAt(i))
                    return prefix.toString();
            }
            prefix.append(character);
        }

        return prefix.toString();
    }

    public static void main(String[] args){
        String[] strings = {"abcd","adbcd"};

        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();

        System.out.print(longestCommonPrefix.longestCommonPrefix(strings));
    }

}
