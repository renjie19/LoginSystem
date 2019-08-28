package com.lourence.jonh;

import com.lourence.jonh.report.controller.ReportController;

public class Logintest {
    public static void main(String[] args) {
        //TimeLogController.getInstance().log(34);
        String startDate = "2019-08-19";
        String endDate = "2019-08-28";
        ReportController.getInstance().viewEmployeeReportPerDate(34,startDate,endDate);
    }
}
