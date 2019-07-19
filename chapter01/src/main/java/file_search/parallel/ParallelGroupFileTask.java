package file_search.parallel;

import file_search.Result;

import java.io.File;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Create by leonardo on 2019/7/19
 */
public class ParallelGroupFileTask implements Runnable {

    private final String fileName;
    private final ConcurrentLinkedDeque<File> directories;
    private final Result parallelResult;
    private boolean found;

    public ParallelGroupFileTask(String fileName, ConcurrentLinkedDeque<File> directories, Result parallelResult) {
        this.fileName = fileName;
        this.directories = directories;
        this.parallelResult = parallelResult;
        this.found = false;
    }

    @Override
    public void run() {
        while (directories.size() > 0) {
            File file = directories.poll();
            try {
                proccessDirectory(file, fileName, parallelResult);
                if (found) {
                    System.out.printf("%s has found the file%n", Thread.currentThread().getName());
                    System.out.printf("Parallel Search: Path: %s%n", parallelResult.getPath());
                    return;
                }
            } catch (InterruptedException e) {
                System.out.printf("%s has been interrupted%n", Thread.currentThread().getName());
            }
        }
    }

    private void proccessDirectory(File file, String fileName, Result parallelResult) throws InterruptedException {
        File[] contents;
        contents = file.listFiles();
        if (contents == null || contents.length == 0) {
            return;
        }
        for (File content : contents) {
            if (content.isDirectory()) {
                proccessDirectory(content, fileName, parallelResult);
                if (Thread.currentThread().isInterrupted()) {
                    throw new InterruptedException();
                }
                if (found) {
                    return;
                }
            } else {
                proccessFile(content,fileName,parallelResult);
                if (Thread.currentThread().isInterrupted()) {
                    throw new InterruptedException();
                }
                if (found) {
                    return;
                }
            }

        }
    }

    private void proccessFile(File content, String fileName, Result parallelResult) {
        if (content.getName().equals(fileName)) {
            parallelResult.setFound(true);
            parallelResult.setPath(content.getAbsolutePath());
            System.out.printf("Parallel Search: Path: %s%n",parallelResult.getPath());
        }
    }


    public boolean isFound() {
        return found;
    }

}
