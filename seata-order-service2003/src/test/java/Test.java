import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * @Classname Test
 * @Description TODO
 * @Date 2020/12/30
 * @Created by yxm
 */
public class Test {
    public static void main(String[] args) {
        //uuid生成唯一无序，比较长
//        System.out.println(UUID.randomUUID().toString());//efbc90e1-8102-4643-bc01-a0fb007263f6

        //snowflake
        System.out.println("11111111111111111111111111111111111111111".length());
//        11111111111111111111111111111111111111111转成10进制2199023255551
        long time = 2199023255551L;
        Date date = new Date();
        date.setTime(2199023255551L);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(date));//可用到2039-09-07
        System.out.println(2039 - 1970);//69年
    }
}
