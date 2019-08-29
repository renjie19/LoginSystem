package com.lourence.jonh.teachinglicense.repository;

import com.lourence.jonh.employee.repository.Employee;
import com.lourence.jonh.employee.repository.EmployeeDao;
import com.lourence.jonh.employee.repository.EmployeeDaoImpl;
import com.lourence.jonh.employee.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class LicenseDaoImplTest {
    @BeforeEach
    void before(){
        LicenseDao licenseDao = new LicenseDaoImpl();
        try {
            licenseDao.deleteAllLicense();
            EmployeeService.getInstance().deleteAllEmployee();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test
    void addLicenseDetails() {
        Employee employee = new Employee();
        employee.setName("Gloria Arroyo");
        employee.setAge(45);
        employee.setAddress("Manila");
        employee.setPosition("Cha-Cha Queen");
        EmployeeDao employeeDao = new EmployeeDaoImpl();
        try {
            int employeeId = employeeDao.addEmployee(employee);
            LicenseDao licenseDao = new LicenseDaoImpl();
            License license = new License();
            license.setLicenseNumber(226758);
            license.setIssueDate(new Date());
            license.setExpiryDate(new Date());
            license.setEmployeeId(employeeId);
            licenseDao.addLicenseDetails(license);
            License savedLicense = licenseDao.getLicenseDetails(employeeId);
            assertEquals(savedLicense.getEmployeeId(),license.getEmployeeId());
            assertEquals(savedLicense.getLicenseNumber(),license.getLicenseNumber());
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test
    void updateLicense() {
        Employee employee = new Employee();
        employee.setName("Gloria Arroyo");
        employee.setAge(45);
        employee.setAddress("Manila");
        employee.setPosition("Cha-Cha Queen");
        EmployeeDao employeeDao = new EmployeeDaoImpl();
        try {
            int employeeId = employeeDao.addEmployee(employee);
            LicenseDao licenseDao = new LicenseDaoImpl();
            License license = new License();
            license.setLicenseNumber(226758);
            license.setIssueDate(new Date());
            license.setExpiryDate(new Date());
            license.setEmployeeId(employeeId);
            licenseDao.addLicenseDetails(license);
            License savedLicense = licenseDao.getLicenseDetails(employeeId);
            savedLicense.setLicenseNumber(444556);
            licenseDao.updateLicense(savedLicense);
            License updatedLicense = licenseDao.getLicenseDetails(employeeId);
            assertNotEquals(savedLicense.getLicenseNumber(),updatedLicense.getLicenseNumber());
            assertEquals(savedLicense.getEmployeeId(),updatedLicense.getEmployeeId());
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}