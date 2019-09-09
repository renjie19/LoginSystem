package com.lourence.jonh.report.service;

import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

class ReportServiceTest {

    @Test
    void viewEmployeeReportPerDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String startDate = dateFormat.format(new Date());
        String endDate = dateFormat.format(new Date());
        ReportService reportService = new ReportService();
        reportService.viewEmployeeReportPerDate(7,"2019-09-07","2019-09-07");
    }
}