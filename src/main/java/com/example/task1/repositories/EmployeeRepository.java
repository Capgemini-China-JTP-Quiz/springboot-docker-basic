package com.example.task1.repositories;

import com.alibaba.fastjson.JSONObject;
import com.example.task1.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeRepository {

    public List<Employee> findAll() {
        String employeesStr = "  [{\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"小明\",\n" +
                "      \"age\": 20,\n" +
                "      \"gender\": \"男\"\n" +
                "    },{\n" +
                "      \"id\": 1,\n" +
                "      \"name\": \"小红\",\n" +
                "      \"age\": 19,\n" +
                "      \"gender\": \"女\"  \n" +
                "    },{\n" +
                "      \"id\": 2,\n" +
                "      \"name\": \"小智\",\n" +
                "      \"age\": 15,\n" +
                "      \"gender\": \"男\"\n" +
                "    },{\n" +
                "      \"id\": 3,\n" +
                "      \"name\": \"小刚\",\n" +
                "      \"age\": 16,\n" +
                "      \"gender\": \"男\"\n" +
                "    },{\n" +
                "      \"id\": 4,\n" +
                "      \"name\": \"小霞\",\n" +
                "      \"age\": 15,\n" +
                "      \"gender\": \"女\"\n" +
                "    }]";

        return JSONObject.parseArray(employeesStr, Employee.class);
    }
}
