package com.lourence.jonh.employee.dao;

public class Employee {
    private int employeeID;
    private String name;
    private int age;
    private String address;
    private String position;
    
    public int getEmployeeId(){
        return employeeID;
    }
    public void setEmployeeId( int employeeID){
        this.employeeID = employeeID;
    }
    
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age = age;
    }
    
    public String  getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address = address;
    }
    
    public String getPosition(){
        return position;
    }
    public void setPosition(String position){
        this.position = position;
    }
}
