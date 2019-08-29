package com.lourence.jonh;

import com.lourence.jonh.report.service.ReportService;

public class Logintest {
    public static void main(String[] args) {
        //TimeLogController.getInstance().log(34);
        String startDate = "2019-08-19";
        String endDate = "2019-08-28";
        ReportService.getInstance().viewEmployeeReportPerDate(34,startDate,endDate);
    }
}
