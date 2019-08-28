package com.lourence.jonh.util;

import com.lourence.jonh.employee.controller.EmployeeController;
import com.lourence.jonh.timelog.controller.TimeLogController;
import com.lourence.jonh.timelog.dao.TimeLog;

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
