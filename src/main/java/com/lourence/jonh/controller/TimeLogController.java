package com.lourence.jonh.controller;

import com.lourence.jonh.model.timelogdao.TimeLog;
import com.lourence.jonh.model.timelogdao.TimeLogDao;
import com.lourence.jonh.model.timelogdao.TimeLogDaoImpl;
import com.lourence.jonh.util.StateEnum;

public class TimeLogController {
    private static TimeLogController timeLogController;
    private TimeLogDao timeLogDao = new TimeLogDaoImpl(); ;
    
    private TimeLogController(){

    }
    
    public static TimeLogController getInstance(){
        if(timeLogController==null){
            timeLogController = new TimeLogController();
        }
        return timeLogController;
    }
    
    public TimeLog log(int employeeId){
        try {
            TimeLog timelog = new TimeLog();
            timelog.setId(employeeId);
            timelog.setType(getEmployeeState(timelog.getId()));
            int rowAffected = timeLogDao.addLog(timelog);
            if(rowAffected != 0 && timelog.getType().equals(StateEnum.IN)){
                System.out.println("Login Successful");
            }else if(rowAffected != 0 && timelog.getType().equals(StateEnum.OUT)){
                System.out.println("Logout Success");
            }
            return timelog = timeLogDao.getLastLogById(timelog.getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void deleteAllLogs(){
        timeLogDao.deleteAllLogs();
    }

    private StateEnum getEmployeeState(int id){
        try {
            TimeLog timeLog = timeLogDao.getLastLogById(id);
            StateEnum state = timeLog.getType();
            if(state.equals(StateEnum.IN)){
                return StateEnum.OUT;
            }
        }catch(Exception e){
           e.printStackTrace();
        }
        return StateEnum.IN;
    }

      
}




