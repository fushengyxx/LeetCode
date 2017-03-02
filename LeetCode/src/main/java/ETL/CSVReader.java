package ETL;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by yixinxin on 17/1/6.
 * 将数据按星期几区分，所有星期一的放在一个文件
 */
public class CSVReader {

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("/Users/yixinxin/Desktop/trainsets/35_trainsets_20161201_20161231.csv"));//换成你的文件名
            String header = reader.readLine();//第一行信息，为标题信息，不用,如果需要，注释掉
            String line = null;

            File mon = new File("/Users/yixinxin/Desktop/trainsets/35_trainsets_Monday.csv");
            File tue = new File("/Users/yixinxin/Desktop/trainsets/35_trainsets_Tuesday.csv");
            File wed = new File("/Users/yixinxin/Desktop/trainsets/35_trainsets_Wednesday.csv");
            File thr = new File("/Users/yixinxin/Desktop/trainsets/35_trainsets_Thursday.csv");
            File fri = new File("/Users/yixinxin/Desktop/trainsets/35_trainsets_Friday.csv");
            File sat = new File("/Users/yixinxin/Desktop/trainsets/35_trainsets_Saturday.csv");
            File sun = new File("/Users/yixinxin/Desktop/trainsets/35_trainsets_Sunday.csv");

            BufferedWriter bufferedWritermon = new BufferedWriter(new FileWriter(mon,true));// 附加
            BufferedWriter bufferedWritertue = new BufferedWriter(new FileWriter(tue,true));
            BufferedWriter bufferedWriterwed = new BufferedWriter(new FileWriter(wed,true));
            BufferedWriter bufferedWriterthr = new BufferedWriter(new FileWriter(thr,true));
            BufferedWriter bufferedWriterfri = new BufferedWriter(new FileWriter(fri,true));
            BufferedWriter bufferedWritersat = new BufferedWriter(new FileWriter(sat,true));
            BufferedWriter bufferedWritersun = new BufferedWriter(new FileWriter(sun,true));

            bufferedWritermon.write(header);
            bufferedWritermon.newLine(); //写入一个行分隔符

            bufferedWritertue.write(header);
            bufferedWritertue.newLine(); //写入一个行分隔符

            bufferedWriterwed.write(header);
            bufferedWriterwed.newLine(); //写入一个行分隔符

            bufferedWriterthr.write(header);
            bufferedWriterthr.newLine(); //写入一个行分隔符

            bufferedWriterfri.write(header);
            bufferedWriterfri.newLine(); //写入一个行分隔符

            bufferedWritersat.write(header);
            bufferedWritersat.newLine(); //写入一个行分隔符

            bufferedWritersun.write(header);
            bufferedWritersun.newLine(); //写入一个行分隔符

            while((line=reader.readLine())!=null){
                String item[] = line.split(",");//CSV格式文件为逗号分隔符文件，这里根据逗号切分

                String timestamp = item[0];//这就是你要的数据了
                Date date = sdf.parse(timestamp);

                System.out.println(date);

                calendar.setTime(date);
                // 1是星期日、2是星期一、3是星期二、4是星期三、5是星期四、6是星期五、7是星期六
                int weekday = calendar.get(Calendar.DAY_OF_WEEK);

                switch (weekday){
                    case 2:
                        bufferedWritermon.write(line);
                        bufferedWritermon.newLine(); //写入一个行分隔符
                        break;
                    case 3:
                        bufferedWritertue.write(line);
                        bufferedWritertue.newLine(); //写入一个行分隔符
                        break;
                    case 4:
                        bufferedWriterwed.write(line);
                        bufferedWriterwed.newLine(); //写入一个行分隔符
                        break;
                    case 5:
                        bufferedWriterthr.write(line);
                        bufferedWriterthr.newLine(); //写入一个行分隔符
                        break;
                    case 6:
                        bufferedWriterfri.write(line);
                        bufferedWriterfri.newLine(); //写入一个行分隔符
                        break;
                    case 7:
                        bufferedWritersat.write(line);
                        bufferedWritersat.newLine(); //写入一个行分隔符
                        break;
                    case 1:
                        bufferedWritersun.write(line);
                        bufferedWritersun.newLine(); //写入一个行分隔符
                        break;
                    default:
                        break;

                }
            }
            bufferedWritermon.close();
            bufferedWritertue.close();
            bufferedWriterwed.close();
            bufferedWriterthr.close();
            bufferedWriterfri.close();
            bufferedWritersat.close();
            bufferedWritersun.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

