package com.lourence.jonh.util;

import com.lourence.jonh.employee.service.EmployeeService;
import com.lourence.jonh.timelog.repository.TimeLog;
import com.lourence.jonh.timelog.service.TimeLogService;

public class EmployeeTimelogFacade {

    public TimeLog log(int employeeId){
        try {
            EmployeeService.getInstance().hasId(employeeId);
            return TimeLogService.getInstance().log(employeeId);
        }catch(Exception e){
            System.out.println(e.getMessage());;
        }
        return null;
    }
}
