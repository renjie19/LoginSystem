package com.lourence.jonh.model.reportsdao;

import java.util.List;

public interface ReportDao {
    List<Report> getReportsBetweenDatesById(int employeeId, String startDate, String endDate) throws Exception;
}
