import java.time.ZonedDateTime;

/**
 * @Classname Test
 * @Description TODO
 * @Date 2020/12/22
 * @Created by yxm
 */
public class Test {
    public static void main(String[] args) {
        //Java8获取默认时区
        ZonedDateTime time = ZonedDateTime.now();
        System.out.println(time);//2020-12-22T20:48:15.333+08:00[Asia/Shanghai]
    }
}
