package com.lourence.jonh.util;

import com.lourence.jonh.controller.EmployeeController;
import com.lourence.jonh.controller.TimeLogController;
import com.lourence.jonh.model.timelogdao.TimeLog;

public class EmployeeTimelogFacade {
    EmployeeController employeeController = EmployeeController.getInstance();
    TimeLogController timeLogController = TimeLogController.getInstance();

    public TimeLog log(int employeeId){
        try {
            employeeController.hasId(employeeId);
            TimeLog timeLog = timeLogController.log(employeeId);
            return timeLog;
        }catch(Exception e){
            System.out.println(e.getMessage());;
        }
        return null;
    }
}
