package com.lourence.jonh.report.service;

import com.lourence.jonh.report.repository.Report;
import com.lourence.jonh.report.repository.ReportDao;
import com.lourence.jonh.report.repository.ReportDaoImpl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
            DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
            List<Report> reportList = reportDao.getReportsBetweenDatesById(employeeId,startDate,endDate);
            if(!reportList.isEmpty()) {
                for(Report report : reportList) {
                    report.setTotalHours(getHoursRendered(report));
                    System.out.println("Date: "+report.getDate()+" | In: "+formatLongToTime(report.getTimeIn())+
                            " | Out: "+formatLongToTime(report.getTimeOut())+" | Hours: "+report.getTotalHours());
                }
                double totalWorkingHours = 0;
                for(Report report : reportList) {
                    totalWorkingHours = totalWorkingHours + report.getTotalHours();
                }
                System.out.println("Total Working Hours: "+totalWorkingHours);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private double getHoursRendered(Report report)throws Exception{
        if(report.getTimeIn() != null && report.getTimeOut() != null) {
          Long timeIn = report.getTimeIn();
          Long timeOut = report.getTimeOut();
          Long diff = timeOut - timeIn;
          return ((double)diff/1000)/3600;
//            SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
//            Date start = format.parse(report.getTimeIn().toString());
//            Date end = format.parse(report.getTimeOut().toString());
//            long diff = end.getTime() - start.getTime();
//            return ((double)diff/1000)/3600;
        }
        return 0;
    }

    private String formatLongToTime(Long date) {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        if(date != null) {
            return dateFormat.format(date);
        }
        return null;
    }
}
