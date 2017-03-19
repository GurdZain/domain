package com.kavli.main;

import com.kavli.service.DoMainService;

/**
 * Created by Administrator on 2017/3/7.
 */
public class DoMain {
    public static boolean PROD_ENV = false;
    public static void main(String[] args) {
        if (args.length > 0 && args[0].contains("prod")) {
            PROD_ENV = true;
        }
        IMainService service = new DoMainService();
        service.init(args);
        service.serve();
    }
}
