package com.lourence.jonh;

import com.lourence.jonh.controller.EmployeeController;
import com.lourence.jonh.controller.ReportController;
import com.lourence.jonh.controller.TimeLogController;
import com.lourence.jonh.model.timelogdao.TimeLog;


public class Logintest {
    public static void main(String[] args) {
        EmployeeController employeeController = EmployeeController.getInstance();
        TimeLogController timelogController = TimeLogController.getInstance();
        ReportController reportController = ReportController.getInstance();


        TimeLog timelog = new TimeLog();
        timelog.setId(9);
        //timelogController.log(timelog);
        String startDate ="2019-08-19";
        String endDate = "2019-08-21";

        for(int x = 0;x<10;x++) {
            reportController.viewEmployeeReportPerDate(x, startDate, endDate);
        }




    }
}
