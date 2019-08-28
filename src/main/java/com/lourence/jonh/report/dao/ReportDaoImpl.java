package com.lourence.jonh.report.dao;

import com.lourence.jonh.util.MySqlConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ReportDaoImpl implements ReportDao {

    @Override
    public List<Report> getReportsBetweenDatesById(int employeeId, String startDate, String endDate) throws Exception{
        List<Report> reportList1 = new ArrayList<Report>();
        String insertSql = "select * from timelogs where id = ? && date between ? AND ? order by date,time";
        PreparedStatement preparedStatement = MySqlConnector.getInstance().prepareStatement(insertSql);
        preparedStatement.setInt(1,employeeId);
        preparedStatement.setString(2,startDate);
        preparedStatement.setString(3,endDate);
        try {
            ResultSet resultSet = MySqlConnector.getInstance().executeQuery(preparedStatement);
            reportList1 = generateReport(resultSet);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            MySqlConnector.getInstance().closeConnection();
        }
        return reportList1;
    }

    private List<Report> generateReport(ResultSet resultSet)throws Exception{
        List<Report> reportList = new ArrayList<Report>();
        while(resultSet.next()){
            Report report = new Report();
            report.setId(resultSet.getInt("id"));
            report.setDate(resultSet.getDate("date"));
            report.setTimeIn(resultSet.getTime("time"));
            String status = resultSet.getString("status");
            boolean hasNext = resultSet.next();
            if(hasNext && (!(status.equals(resultSet.getString("status"))))) {
                report.setTimeOut(resultSet.getTime("time"));
            }else if(hasNext && (status.equals(resultSet.getString("status")))){
                report.setTimeOut(null);
                resultSet.previous();
            }else{
                report.setTimeOut(null);
            }
            reportList.add(report);
        }
        return reportList;
    }
}
