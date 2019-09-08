package com.lourence.jonh.report.repository;

import com.lourence.jonh.timelog.repository.TimeLog;
import com.lourence.jonh.util.Hibernate;

import java.util.ArrayList;
import java.util.List;

public class ReportDaoImpl implements ReportDao {
    private static ReportDaoImpl reportDao;

    private ReportDaoImpl() {
    }

    public static ReportDaoImpl getInstance() {
        if(reportDao==null) {
            reportDao = new ReportDaoImpl();
        }
        return reportDao;
    }

    @Override
    public List<Report> getReportsBetweenDatesById(int employeeId, String startDate, String endDate) {
        List<Report> reportList1 = new ArrayList<Report>();
        String insertSql = "Select t from TimeLog t where employeeId = "+employeeId+" and date between '"+startDate+"' and '"+endDate+"' order by date,time";
        Hibernate hibernate = new Hibernate();
        return generateReport(hibernate.createNamedQuery(insertSql));
    }

    private List<Report> generateReport(List timeLogList){
        List<Report> reportList = new ArrayList<Report>();
        while(!timeLogList.isEmpty()) {
            TimeLog timeIn = (TimeLog)timeLogList.get(0);
            Report report = new Report();
            report.setId(timeIn.getEmployeeId());
            report.setDate(timeIn.getDate());
            report.setTimeIn(timeIn.getTime());
            timeLogList.remove(timeIn);
            TimeLog timeOut = null;
            if(!timeLogList.isEmpty()) {
                timeOut = (TimeLog)timeLogList.get(0);
            }
            if(timeOut!=null && !(timeIn.getType().equals(timeOut.getType()))) {
                report.setTimeOut(timeOut.getTime());
                timeLogList.remove(timeOut);
            } else if(timeOut!=null && timeIn.getType().equals(timeOut.getType())) {
                report.setTimeOut(null);
            } else {
                report.setTimeOut(null);
            }
            reportList.add(report);
        }

        return reportList;
    }
}
