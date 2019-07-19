package common.util;

import java.util.List;

/**
 * Create by leonardo on 2019/7/19
 */
public class ThreadUtil {

    public static void waitForThreads(List<Thread> threads) {
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        threads.clear();
    }
}
