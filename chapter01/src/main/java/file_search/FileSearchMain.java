package file_search;

import file_search.parallel.ParallelGroupFileSearch;
import file_search.serial.SerialFileSearch;

import java.io.File;
import java.util.Date;

/**
 * Create by leonardo on 2019/7/19
 */
public class FileSearchMain {
    public static void main(String[] args) {
//        Date start1 = new Date();
//        SerialFileSearch.searchFile(new File("D:\\AppServ"),"phpinfo.php",new Result());
//        Date end1 = new Date();
//        System.out.printf("Serial cost: %d%n",end1.getTime()-start1.getTime());

        Date start2 = new Date();
        ParallelGroupFileSearch.searchFile(new File("D:\\AppServ"),"phpinfo.php",new Result());
        Date end2 = new Date();
        System.out.printf("Parallel cost: %d%n",end2.getTime()-start2.getTime());
    }
}
