package com.standbyme.config;

import java.util.HashMap;
import java.util.Map;

public class DataSourceMap {

    public static Map<String,String> getDataSourceMap(){

        Map<String, String> dataSourceMap = new HashMap<>();

        dataSourceMap.put("driver", "com.mysql.jdbc.Driver");
        dataSourceMap.put("user", "root");
        dataSourceMap.put("password", "zaq1@WSX");
        dataSourceMap.put("url", "jdbc:mysql://192.168.2.135:3306/loong?useUnicode=true&characterEncoding=utf-8&useSSL=false");
        dataSourceMap.put("dbtable", "t_calc_task");

        return dataSourceMap;
    }


}
