package esay;

/**
 * Created by yixinxin on 17/1/2.
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR"
 * 1. 边界条件：n < 2时
 *
 */
public class ZigZag {
    /*
                               2nRows-1               4nRows-3
    1        nRows+nRows-2     2nRows     4nRows-2*2
    2        ...               2nRows+1   ...
    ...      nRows+1           ..         3nRows-1    ...
    nRows                      3nRows-2               5nRows-2*2

     */

    public String convert(String s, int numRows) {
        String result = "";
        int length = s.length();
        if(s.equals("") || s == null || numRows < 2)
            return s;

        for (int i = 0; i < numRows; ++i){
            for(int j = i; j < length; j += 2 * (numRows -1)){
                result += s.charAt(j);
                if (i > 0 && i < numRows -1) {
                    if(j + 2 * (numRows -i -1) < s.length())
                        result += s.charAt(j + 2 * (numRows -i -1));
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        ZigZag zigZag = new ZigZag();
        String s = "PAHNAPLSIIGYIR";
        System.out.print(zigZag.convert(s, 3));
    }
}
