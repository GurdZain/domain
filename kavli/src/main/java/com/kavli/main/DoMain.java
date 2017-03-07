package com.kavli.main;

import com.kavli.service.DoMainService;
import com.kavli.tools.HttpUtils;
import net.sf.json.JSONObject;

/**
 * Created by Administrator on 2017/3/7.
 */
public class DoMain {
    public static void main(String[] args) {
        IMainService service = new DoMainService();
        service.init(args);
        service.serve();
    }
}
