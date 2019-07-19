package file_search.parallel;

import file_search.Result;

import java.io.File;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Create by leonardo on 2019/7/19
 */
public class ParallelGroupFileSearch {
    public static void searchFile(File file, String fileName, Result parallelResult) {
        ConcurrentLinkedDeque<File> directories = new ConcurrentLinkedDeque<>();
        File[] contents = file.listFiles();
        for (File content : contents) {
            if (content.isDirectory()) {
                directories.add(content);
            }
        }

        int numThreads = Runtime.getRuntime().availableProcessors();
        Thread[] threads = new Thread[numThreads];
        ParallelGroupFileTask[] tasks = new ParallelGroupFileTask[numThreads];
        for (int i = 0; i < numThreads; i++) {
            tasks[i] = new ParallelGroupFileTask(fileName, directories, parallelResult);
            threads[i] = new Thread(tasks[i]);
            threads[i].start();
        }

        boolean finish = false;
        int numFinished= 0;
        while (!finish) {
            numFinished = 0;
            for (int i = 0; i < threads.length; i++) {
                if (threads[i].getState().equals(Thread.State.TERMINATED)) {
                    numFinished++;
                    if (tasks[i].isFound()) {
                        finish = true;
                    }
                }
            }
            if (numFinished == threads.length) {
                finish = true;
            }
        }
        if (numFinished!=threads.length) {
            for (Thread thread : threads) {
                thread.interrupt();
            }
        }
    }
}
