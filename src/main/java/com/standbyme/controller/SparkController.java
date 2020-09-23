package com.standbyme.controller;

import com.standbyme.config.DataSourceProperties;
import com.standbyme.config.SparkConig;
import com.standbyme.domain.CalcTask;
import com.standbyme.function.CalcTaskFuntion;
import org.apache.spark.api.java.function.MapPartitionsFunction;
import org.apache.spark.sql.*;

import java.util.Iterator;
import java.util.Properties;

public class SparkController {

    public static void main(String[] args) {

        SparkSession sparkSession = SparkConig.getSparkSession();

        String sql = "select * from t_calc_task";

        String table = "t_calc_task";

        Dataset<Row> dataset = getSelectByMysql(sparkSession, sql);

        //dataset.show();

        Dataset<CalcTask> calcTaskDataset = dataset.mapPartitions(new CalcTaskFuntion(), Encoders.bean(CalcTask.class));

        calcTaskDataset.show();


    }

    private static Dataset<Row> getSelectByMysql(SparkSession sparkSession, String sql) {

        Properties dataSourceProperties = DataSourceProperties.getDataSourceProperties();

        sparkSession.read().jdbc("jdbc:mysql://192.168.2.135:3306/loong?useUnicode=true&characterEncoding=utf-8&useSSL=false","t_calc_task",dataSourceProperties).createOrReplaceTempView("t_calc_task");

        return sparkSession.sql(sql);
    }
}
