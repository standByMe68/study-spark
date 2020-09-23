package com.standbyme.config;

import java.util.Properties;

public class DataSourceProperties {

    public static Properties getDataSourceProperties(){

        Properties properties = new Properties();

        properties.put("driver", "com.mysql.jdbc.Driver");
        properties.put("user", "root");
        properties.put("password", "zaq1@WSX");
        properties.put("url", "jdbc:mysql://192.168.2.135:3306/loong?useUnicode=true&characterEncoding=utf-8&useSSL=false");

        return properties;

    }



}
