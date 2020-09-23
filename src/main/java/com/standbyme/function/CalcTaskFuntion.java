package com.standbyme.function;

import com.standbyme.domain.CalcTask;
import org.apache.spark.api.java.function.MapPartitionsFunction;
import org.apache.spark.sql.Row;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CalcTaskFuntion implements MapPartitionsFunction<Row,CalcTask> {
    @Override
    public Iterator<CalcTask> call(Iterator<Row> input) throws Exception {

        List<CalcTask> list = new ArrayList<>();

        while(input.hasNext()){

            Row next = input.next();

            CalcTask calcTask = new CalcTask(next);

            list.add(calcTask);
        }
        return list.iterator();
    }
}
