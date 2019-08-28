package com.lourence.jonh.report.controller;

import com.lourence.jonh.report.dao.Report;
import com.lourence.jonh.report.dao.ReportDao;
import com.lourence.jonh.report.dao.ReportDaoImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ReportController {
    private static ReportController reportController;
    private ReportDao reportDao = new ReportDaoImpl();

    private ReportController(){}

    public static ReportController getInstance() {
        if(reportController==null){
            reportController = new ReportController();
        }
        return reportController;
    }

    public void viewEmployeeReportPerDate(int employeeId, String startDate, String endDate){
        try {
            double totalWorkingHours = 0;
            List<Report> reportList = reportDao.getReportsBetweenDatesById(employeeId, startDate, endDate);
            if(reportList != null) {
                for (Report report : reportList) {
                    report.setTotalHours(getHoursRendered(report));
                    System.out.println(report.getId() + " | " + report.getDate() + " | " + report.getTimeIn() + " | " +
                            report.getTimeOut() + " | " + String.format("% .1f", report.getTotalHours()));
                    totalWorkingHours = totalWorkingHours + report.getTotalHours();
                }
                System.out.println("Total Hours: " + String.format("% .1f",totalWorkingHours));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private double getHoursRendered(Report report)throws Exception{
        if (report.getTimeIn() != null && report.getTimeOut() != null) {
            SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
            Date start = format.parse(report.getTimeIn().toString());
            Date end = format.parse(report.getTimeOut().toString());
            long diff = end.getTime() - start.getTime();
            return ((double)diff/1000)/3600;
        }
        return 0;
    }

}
