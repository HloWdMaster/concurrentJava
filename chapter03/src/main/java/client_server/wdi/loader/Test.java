package client_server.wdi.loader;

import client_server.common.Constants;
import client_server.wdi.data.WDI;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Create by leonardo on 2019/7/29
 */
public class Test {
    public static void main(String[] args) {
        Path path = Paths.get(Constants.DATA_ROUTE);
        List<WDI> load = new WDILoader().load(path.toString());
        for (WDI wdi : load) {
            System.out.println(wdi);
        }
    }
}
