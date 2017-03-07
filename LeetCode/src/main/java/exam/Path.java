package exam;

import java.util.Scanner;

/**
 * Created by yixinxin on 17/3/5.
 *
 *
 西湖是杭州最有名的风景区，每年到西湖旅游的游客非常多，大家各自从不同地方出发到西湖，交通问题非常令人头疼。阿里小二小J准备通过高德地图实时数据和智能推荐帮大家解决这个问题。
 现有一组地理坐标，地理位置用5位以内的大写字母表示。高德地图会根据当时的车流情况预估实时路况：从地理位置1到地理位置2之间的用时，单位为分钟。地理位置之间和用时之间都用英文逗号（,）分隔。比如：WSX, BQB,20，表示从WSX位置到BQB位置，需要20分钟。注意，仅凭这一行数据不代表BQB到WSX也为20分钟，如果系统中未给出BQB,WSX,x这样的数据，表示WSX到BQB为单行线。西湖的地理位置用XH表示。
 系统保障：
 地理位置不重名
 至少存在一条从目的地理位置通往西湖的路径。
 实时路况数量不超过10000。
 地理位置数不超过100。
 实时路况的分钟数为1到21亿之间的正整数。
 请计算从给出目的地理位置（非XH的任意地理位置）到西湖的最少用时路径。

 编译器版本: Java 1.8.0_66
 请使用标准输入输出(System.in, System.out)；已禁用图形、文件、网络、系统相关的操作，如java.lang.Process , javax.swing.JFrame , Runtime.getRuntime；不要自定义包名称，否则会报错，即不要添加package answer之类的语句；您可以写很多个类，但是必须有一个类名为Main，并且为public属性，并且Main为唯一的public class，Main类的里面必须包含一个名字为'main'的静态方法（函数），这个方法是程序的入口
 时间限制: 1S (C/C++以外的语言为: 3 S)   内存限制: 64M (C/C++以外的语言为: 576 M)
 输入:
 输入数据包含1+N+1行， 第1行，整数N（实时路况的数量） 第2到N+1行，实时路况信息。 最后一行，出发地的大写字母代号。
 输出:
 输出目的地到西湖的路径。地理位置之间用->表示（前后不要留空格，行前和末尾不要换行）。示例：XX->YY->…..->XH
 输入范例:
 4
 AA,BB,20
 AA,CC,30
 BB,XH,50
 CC,XH,10
 AA
 输出范例:
 AA->CC->XH
 */
public class Path {

    static String Find(int n, int m) {
        return "";

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String res;

        int _n;
        _n = Integer.parseInt(in.nextLine().trim());

        int _m;
        _m = Integer.parseInt(in.nextLine().trim());

        res = Find(_n, _m);
        System.out.println(res);
    }

}