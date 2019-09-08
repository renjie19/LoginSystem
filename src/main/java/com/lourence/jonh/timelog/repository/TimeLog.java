package com.lourence.jonh.timelog.repository;
import com.lourence.jonh.util.StateEnum;

import javax.persistence.*;
import java.util.Date;

@Entity
public class TimeLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int logId;
    private int employeeId;
    private StateEnum type;
    @Temporal(value = TemporalType.DATE)
    private Date date;
    private long time;

    public int getLogId() {
        return logId;
    }

    public void setLogId(int logId) {
        this.logId = logId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public StateEnum getType() {
        return type;
    }

    public void setType(StateEnum type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
