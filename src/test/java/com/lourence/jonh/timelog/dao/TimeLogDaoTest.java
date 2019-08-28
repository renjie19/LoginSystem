package com.lourence.jonh.timelog.dao;

import com.lourence.jonh.employee.dao.Employee;
import com.lourence.jonh.employee.dao.EmployeeDao;
import com.lourence.jonh.employee.dao.EmployeeDaoImpl;
import com.lourence.jonh.util.StateEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TimeLogDaoTest {

    @BeforeEach
    void before(){
        TimeLogDao timeLogDao = new TimeLogDaoImpl();
        timeLogDao.deleteAllLogs();
        EmployeeDao employeeDao = new EmployeeDaoImpl();
        employeeDao.deleteAllEmployee();

    }

    @Test
    void addLog() {
        Employee employee = new Employee();
        employee.setName("Gloria Arroyo");
        employee.setAge(45);
        employee.setAddress("Manila");
        employee.setPosition("Cha-Cha Queen");
        EmployeeDao employeeDao = new EmployeeDaoImpl();
        TimeLogDao timeLogDao = new TimeLogDaoImpl();
        try {
            employee.setEmployeeId(employeeDao.addEmployee(employee));
            TimeLog timeLog = new TimeLog();
            timeLog.setId(employee.getEmployeeId());
            TimeLog lastLog = timeLogDao.getLastLogById(timeLog.getId());
            timeLog.setType((lastLog.getType().equals(StateEnum.OUT))?StateEnum.IN:StateEnum.OUT);
            timeLogDao.addLog(timeLog);
            lastLog = timeLogDao.getLastLogById(timeLog.getId());
            assertEquals(timeLog.getId(),lastLog.getId());
            assertEquals(timeLog.getType(),lastLog.getType());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}