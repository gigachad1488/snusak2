package com.example.kozinak;

import java.io.Serializable;

public class User implements Serializable {
    private String firstName = "";
    private String lastName = "";
    private int age = 0;
    private double salary = 0;

    public  void  setFirstName(String name)
    {
        firstName = name;
    }

    public  void  setLastName(String name)
    {
        lastName = name;
    }

    public  void  setAge(int age)
    {
        this.age = age;
    }

    public  void  setSalary(double salary)
    {
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public String getUserData()
    {
        return "Имя: " + firstName + "\n" +
                "Фамилия: " + lastName + "\n" +
                "Возраст: " + age + "\n" +
                "Зарплата: " + salary;
    }

}
