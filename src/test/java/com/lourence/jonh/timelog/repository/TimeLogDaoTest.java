package com.lourence.jonh.timelog.repository;

import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

class TimeLogDaoTest {

    @Test
    void addLog() {
       TimeLog timeLog = new TimeLog();
       timeLog.setEmployeeId(4);
       timeLog.setDate(new Date());
       timeLog.setTime(System.currentTimeMillis());
       TimeLogDaoImpl.getInstance().addLog(timeLog);
    }
    @Test
    void getLastLog() {
        TimeLog timelog = TimeLogDaoImpl.getInstance().getLastLogById(4);
        Date date = timelog.getDate();
        DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        format.format(date);
    }
}