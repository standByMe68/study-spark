package com.standbyme.config;

import org.apache.spark.sql.SparkSession;

public class SparkConig {

    public static SparkSession getSparkSession(){
        SparkSession sparkSession = SparkSession.builder().master("local").getOrCreate();
        return sparkSession;
    }
}
