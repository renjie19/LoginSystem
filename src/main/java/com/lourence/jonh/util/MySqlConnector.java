package com.lourence.jonh.util;
import java.sql.*;

public class MySqlConnector {
    private static MySqlConnector mySqlConnector;
    private final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private final String USER = "root";
    private final String PASSWORD = "pass";
    private Connection con;

    private MySqlConnector(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static MySqlConnector getInstance(){
        if(mySqlConnector==null){
            mySqlConnector = new MySqlConnector();
        }
        return mySqlConnector;
    }

    public ResultSet executeQuery(PreparedStatement preparedStatement){
        ResultSet resultSet = null;
        try {
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            closeConnection();
            e.printStackTrace();
        }
        return resultSet;
    }

    public int executeUpdate(PreparedStatement preparedStatement){
        int rowsAffected = 0;
        try{
            rowsAffected = preparedStatement.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            closeConnection();
        }
        return rowsAffected;
    }

    public PreparedStatement prepareStatement(String sql)throws Exception{
        this.con = DriverManager.getConnection(URL, USER, PASSWORD);
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        return preparedStatement;
    }

    public void closeConnection(){
        if(con!=null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("con is null");
        }
    }
}
