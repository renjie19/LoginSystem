package com.lourence.jonh.model.reportsdao;

import java.util.List;

public interface ReportDao {
    List<Report> getReportsBetweenDates(int employeeId, String startDate, String endDate) throws Exception;
}
