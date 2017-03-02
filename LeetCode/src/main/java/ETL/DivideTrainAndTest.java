package ETL;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by yixinxin on 17/1/9.
 * 将全部星期一的数据分开，一部分做训练集，一部分做测试集
 */
public class DivideTrainAndTest {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        try {
            BufferedReader reader = new BufferedReader(new FileReader
                    ("/Users/yixinxin/Desktop/trainsets/35_trainsets_Thursday.csv"));//换成你的文件名
            String header = reader.readLine();//第一行信息，为标题信息，不用,如果需要，注释掉
            String line = null;

            File train = new File("/Users/yixinxin/Desktop/trainsets/35_trainsets_Thursday_train.csv");
            File test = new File("/Users/yixinxin/Desktop/trainsets/35_trainsets_Thursday_test.csv");

            BufferedWriter bufferedWriterTrain = new BufferedWriter(new FileWriter(train,true));// 附加
            BufferedWriter bufferedWriterTest = new BufferedWriter(new FileWriter(test,true));

            bufferedWriterTrain.write(header);
            bufferedWriterTrain.newLine(); //写入一个行分隔符

            bufferedWriterTest.write(header);
            bufferedWriterTest.newLine(); //写入一个行分隔符
            int day = 0;  // 数据是几号的
            int days = 0; // 共有几天的数据

            while((line=reader.readLine())!=null){
                String item[] = line.split(",");//CSV格式文件为逗号分隔符文件，这里根据逗号切分

                String timestamp = item[0];//这就是你要的数据了
                Date date = sdf.parse(timestamp);

                System.out.println(date);

                calendar.setTime(date);

                if(day != calendar.get(Calendar.DAY_OF_MONTH))
                    days++;

                // 获得日期
                day = calendar.get(Calendar.DAY_OF_MONTH);

                if(days < 5){
                    bufferedWriterTrain.write(line);
                    bufferedWriterTrain.newLine(); //写入一个行分隔符
                }else{
                    bufferedWriterTest.write(line);
                    bufferedWriterTest.newLine(); //写入一个行分隔符
                }
            }
        bufferedWriterTrain.close();
        bufferedWriterTest.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
