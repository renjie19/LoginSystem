package com.lourence.jonh.report.dao;

import java.util.List;

public interface ReportDao {
    List<Report> getReportsBetweenDatesById(int employeeId, String startDate, String endDate) throws Exception;
}
