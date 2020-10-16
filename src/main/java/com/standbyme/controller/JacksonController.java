package com.standbyme.controller;

import com.standbyme.domain.Student;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

import java.io.IOException;
import java.io.Serializable;

public class JacksonController {

    public static void main(String[] args) {

        String xiaoming = "{\"name\":\"Mahesh\", \"age\":21}";

        ObjectMapper mapper = new ObjectMapper();
        try {
            Student student = mapper.readValue(xiaoming, Student.class);
            System.out.println(student);

            mapper.enable(SerializationConfig.Feature.INDENT_OUTPUT);

            student.setName(null);

            String string = mapper.writeValueAsString(student);

            System.out.println(string);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
