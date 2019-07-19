package common.util;

import java.util.Date;

/**
 * Create by leonardo on 2019/7/19
 */
public class RuntimeUtil {
    public void runDemo(IRunDemo demo) {
        Date start = new Date();
        demo.excute();
        Date end = new Date();
        System.out.printf("cost time(ms):%d%n",end.getTime()-start.getTime());
    }
}
