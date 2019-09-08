package com.lourence.jonh.report.repository;

import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

class ReportDaoImplTest {

    @Test
    void getReportsBetweenDatesById() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String startDate = dateFormat.format(new Date());
        String endDate = dateFormat.format(new Date());
        ReportDaoImpl.getInstance().getReportsBetweenDatesById(7,"2019-09-07","2019-09-07");
    }
}