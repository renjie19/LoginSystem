package com.lourence.jonh.controller;

import com.lourence.jonh.model.timelogdao.TimeLog;
import com.lourence.jonh.model.timelogdao.TimeLogDAOImp;
import com.lourence.jonh.util.StateEnum;

public class TimeLogController {
    private static TimeLogController timeLogController;
    
    private TimeLogController(){

    }
    
    public static TimeLogController getInstance(){
        if(timeLogController==null){
            timeLogController = new TimeLogController();
        }
        return timeLogController;
    }
    
    public void log(TimeLog log){
        try {
            if(checkIfIdExists(log.getId())) {
                log.setType(getEmployeeState(log.getId()));
                int rowAffected = TimeLogDAOImp.getInstance().addLog(log);
                if(rowAffected != 0 && log.getType().equals(StateEnum.IN)){
                    System.out.println("Login Successful");
                }else if(rowAffected != 0 && log.getType().equals(StateEnum.OUT)){
                    System.out.println("Logout Success");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private StateEnum getEmployeeState(int id){
        try {
            TimeLog timeLog = TimeLogDAOImp.getInstance().getLastLogById(id);
            StateEnum state = timeLog.getType();
            if(state.equals(StateEnum.IN)){
                return StateEnum.OUT;
            }
        }catch(Exception e){
           e.printStackTrace();
        }
        return StateEnum.IN;
    }

    private boolean checkIfIdExists(int employeeId)throws Exception{
        if(!TimeLogDAOImp.getInstance().checkIfEmployeeIdExist(employeeId)){
            throw new Exception("ID does not exist");
        }
        return true;
    }

      
}




