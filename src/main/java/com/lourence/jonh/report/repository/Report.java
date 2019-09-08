package com.lourence.jonh.report.repository;

import java.util.Date;

public class Report {
    private int id;
    private Date date;

    private Long timeIn;
    private Long timeOut;
    private double totalHours;

    public int getId(){
        return this.id;
    }

    public void setId(int employeeId){
        this.id = employeeId;
    }

    public Date getDate(){
        return this.date;
    }

    public void setDate(Date date){
        this.date = date;
    }

    public void setTimeIn(Long timeIn){
        this.timeIn = timeIn;
    }

    public Long getTimeIn(){
        return this.timeIn;
    }

    public Long getTimeOut(){
        return this.timeOut;
    }

    public void setTimeOut(Long timeOut){
        this.timeOut = timeOut;
    }

    public void setTotalHours(double totalHours){
        this.totalHours = totalHours;
    }

    public double getTotalHours(){
        return this.totalHours;
    }
}
