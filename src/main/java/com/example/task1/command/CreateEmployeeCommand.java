package com.example.task1.command;

import com.example.task1.entity.Employee;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CreateEmployeeCommand {

    @NotNull
    private Integer id;

    @NotBlank
    private String name;

    @NotNull
    private Integer age;

    @NotBlank
    private String gender;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public static Employee toEmployee(CreateEmployeeCommand createEmployeeCommand) {
        Employee result = new Employee();
        BeanUtils.copyProperties(createEmployeeCommand, result);
        return result;
    }
}
