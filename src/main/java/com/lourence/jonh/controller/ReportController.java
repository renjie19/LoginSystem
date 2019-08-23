package com.lourence.jonh.controller;

import com.lourence.jonh.model.reportsdao.Report;
import com.lourence.jonh.model.reportsdao.ReportDao;
import com.lourence.jonh.model.reportsdao.ReportDaoImpl;

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
            double hoursRendered;
            List<Report> reportList = reportDao.getReportsBetweenDatesById(employeeId, startDate, endDate);
            if(reportList != null) {
                for (Report report : reportList) {
                    hoursRendered = getHoursRendered(report);
                    System.out.println(report.getId() + " | " + report.getDate() + " | " + report.getTimeIn() + " | " +
                            report.getTimeOut() + " | " + String.format("% .1f", hoursRendered));
                    totalWorkingHours = totalWorkingHours + hoursRendered;
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
