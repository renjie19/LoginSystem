package com.lourence.jonh.model.reportsdao;

import java.util.List;

public interface ReportDAO {
    List<Report> getReportsEachDate(int employeeId, String startDate, String endDate) throws Exception;
}
