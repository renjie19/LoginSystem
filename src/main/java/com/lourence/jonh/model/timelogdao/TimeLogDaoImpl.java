package com.lourence.jonh.model.timelogdao;
import com.lourence.jonh.util.MySqlConnector;
import com.lourence.jonh.util.StateEnum;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TimeLogDaoImpl implements TimeLogDao {
    private ResultSet resultSet;
    private TimeLog timeLog;
    
    @Override
    public int addLog(TimeLog log)throws Exception{
        String insertSql = "INSERT INTO timelogs VALUES(?,CURDATE(),CURTIME(),?)";
        PreparedStatement preparedStatement = MySqlConnector.getInstance().prepareStatement(insertSql);
        preparedStatement.setInt(1,log.getId());
        preparedStatement.setString(2,log.getType().toString());
        return MySqlConnector.getInstance().executeUpdate(preparedStatement);
    }

    @Override
    public TimeLog getLastLogById(int id) throws Exception{
        String insertSql = "SELECT * FROM timelogs WHERE id = ? ORDER BY date DESC,time DESC LIMIT 1";
        PreparedStatement preparedStatement = MySqlConnector.getInstance().prepareStatement(insertSql);
        preparedStatement.setInt(1,id);
        try {
            resultSet = MySqlConnector.getInstance().executeQuery(preparedStatement);
            timeLog = new TimeLog();
            if (resultSet.next()) {
                timeLog = generateTimeLog(resultSet);
            } else {
                timeLog.setType(StateEnum.OUT);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            MySqlConnector.getInstance().closeConnection();
        }
        return timeLog;
    }

    @Override
    public boolean hasEmployeeId(int employeeId)throws Exception{
        String insertSql = "SELECT * FROM employee WHERE id = ?";
        PreparedStatement preparedStatement = MySqlConnector.getInstance().prepareStatement(insertSql);
        preparedStatement.setInt(1,employeeId);
        try {
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            MySqlConnector.getInstance().closeConnection();
        }
        return false;
    }

    @Override
    public void deleteAllLogs(){
        try {
            String insertSql = "DELETE FROM timelogs";
            PreparedStatement preparedStatement = MySqlConnector.getInstance().prepareStatement(insertSql);
            MySqlConnector.getInstance().executeUpdate(preparedStatement);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private TimeLog generateTimeLog(ResultSet resultSet)throws Exception{
        timeLog = new TimeLog();
        timeLog.setId(resultSet.getInt("id"));
        timeLog.setDate(resultSet.getDate("date"));
        timeLog.setTime(resultSet.getTime("time"));
        if(resultSet.getString("status").equals("IN")){
            timeLog.setType(StateEnum.IN);
        }else{
            timeLog.setType(StateEnum.OUT);
        }
        return timeLog;
    }
}
