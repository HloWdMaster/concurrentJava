package file_search.serial;

import file_search.Result;

import java.io.File;

/**
 * Create by leonardo on 2019/7/19
 */
public class SerialFileSearch {

    public static void fileSearch(File file, String fileName, Result result) {
        File[] contents;
        contents = file.listFiles();
        if (contents==null || contents.length == 0) {
            return;
        }
        for (File content : contents) {
            if (content.isDirectory()) {
                fileSearch(content,fileName,result);
            }else{
                if (content.getName().equals(fileName)) {
                    result.setFound(true);
                    result.setPath(content.getAbsolutePath());
                    System.out.printf("Serial Search: Path: %s%n",result.getPath());
                    return;
                }
            }
            if (result.isFound()) {
                return;
            }

        }

    }
}
