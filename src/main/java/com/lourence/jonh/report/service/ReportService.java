package com.lourence.jonh.report.service;

import com.lourence.jonh.report.repository.Report;
import com.lourence.jonh.report.repository.ReportDao;
import com.lourence.jonh.report.repository.ReportDaoImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ReportService {
    private static ReportService reportService;
    private ReportDao reportDao = ReportDaoImpl.getInstance();

    private ReportService(){}

    public static ReportService getInstance() {
        if(reportService ==null){
            reportService = new ReportService();
        }
        return reportService;
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
