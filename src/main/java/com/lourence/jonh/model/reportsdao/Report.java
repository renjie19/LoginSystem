package com.lourence.jonh.model.reportsdao;

import java.util.Date;

public class Report {
    private int id;
    private Date date;
    private Date timeIn;
    private Date timeOut;

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

    public void setTimeIn(Date timeIn){
        this.timeIn = timeIn;
    }
    public Date getTimeIn(){
        return this.timeIn;
    }

    public Date getTimeOut(){
        return this.timeOut;
    }
    public void setTimeOut(Date timeOut){
        this.timeOut = timeOut;
    }
}
