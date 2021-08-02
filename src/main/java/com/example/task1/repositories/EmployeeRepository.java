package com.example.task1.repositories;

import com.alibaba.fastjson.JSONObject;
import com.example.task1.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeRepository {

    private List<Employee> data;
    public static final String EMPLOYEES_STR = "  [{\n" +
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

    public EmployeeRepository() {
        this.data = JSONObject.parseArray(EMPLOYEES_STR, Employee.class);
    }

    public List<Employee> findAll() {
        return data;
    }

    public Employee findById(Integer id) {
        return data.stream().filter(employee -> employee.getId().equals(id)).findAny().orElse(null);
    }

    public Boolean save(Employee employee) {
       return data.add(employee);
    }

    public Boolean deleteById(Integer id) {
        data = data.stream().filter(employee -> !employee.getId().equals(id)).collect(Collectors.toList());
        return true;
    }
}
