package com.lourence.jonh.util;

import com.lourence.jonh.controller.EmployeeController;
import com.lourence.jonh.controller.TimeLogController;
import com.lourence.jonh.model.timelogdao.TimeLog;

public class EmployeeTimelogFacade {

    public TimeLog log(int employeeId){
        try {
            EmployeeController.getInstance().hasId(employeeId);
            TimeLog timeLog = TimeLogController.getInstance().log(employeeId);
            return timeLog;
        }catch(Exception e){
            System.out.println(e.getMessage());;
        }
        return null;
    }
}
