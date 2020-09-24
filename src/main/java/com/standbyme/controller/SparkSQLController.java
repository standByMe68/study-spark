package com.standbyme.controller;

import com.standbyme.config.DataSourceMap;
import com.standbyme.config.SparkConig;
import org.apache.spark.api.java.function.ForeachFunction;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.SparkSession;

public class SparkSQLController {

    //通过SqlContext获取对应的数据库操作
    public static void main(String[] args) {
        SparkSession sparkSession = SparkConig.getSparkSession();

        SQLContext sqlContext = sparkSession.sqlContext();

        Dataset<Row> jdbc = sqlContext.read().format("jdbc").options(DataSourceMap.getDataSourceMap()).load();
        jdbc.show();

        //打印数据到目录中
        jdbc.write().format("json").mode("overwrite").save("G:\\tmp\\json1111");

    }
}
