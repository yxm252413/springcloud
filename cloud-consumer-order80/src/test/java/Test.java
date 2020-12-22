import org.assertj.core.util.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Test
 * @Description TODO
 * @Date 2020/12/20
 * @Created by yxm
 */
public class Test {
    static List<Integer> result = Lists.newArrayList(0, 0, 0);

    public static void main(String[] args) {
        //2147483647是Integer最大值
        System.out.println(Integer.MAX_VALUE);
//        test();
    }

    public static void test() {
        int count = 0;
        for (int x = 1; x < 9; x++) {
            for (int y = 1; y < 9; y++) {
                for (int z = 1; z < 9; z++) {
                    for (int zz = 1; zz < 9; zz++) {
                        if (x + y + z + zz == 10) {
                            System.out.println(x + "-->" + y + "-->" + z + "-->" + z);
                            count++;
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }
}
