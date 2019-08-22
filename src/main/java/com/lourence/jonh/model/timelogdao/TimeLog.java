package com.lourence.jonh.model.timelogdao;
import com.lourence.jonh.util.StateEnum;

import java.util.Date;

public class TimeLog {
    private int EmployeeId;
    private StateEnum type;
    private Date date;
    private Date time;
    
    public int getId(){
        return EmployeeId;
    }

    public void setId(int id){
        this.EmployeeId = id;
    }
    
    public void setType(StateEnum type) {
        this.type = type;
    }
    
    public StateEnum getType(){
        return type;
    }
    
    public void setDate(Date date){
        this.date  = date;
    }

    public Date getDate(){
        return this.date;
    }

    public void setTime(Date time){
        this.time = time;
    }

    public Date getTime(){
        return this.time;
    }

    
    
}
