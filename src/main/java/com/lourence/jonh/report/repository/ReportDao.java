package com.lourence.jonh.report.repository;

import java.util.List;

public interface ReportDao {
    List<Report> getReportsBetweenDatesById(int employeeId, String startDate, String endDate);
}
