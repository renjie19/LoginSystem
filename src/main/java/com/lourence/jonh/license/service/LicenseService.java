package com.lourence.jonh.license.service;

import com.lourence.jonh.license.repository.License;
import com.lourence.jonh.license.repository.LicenseDao;
import com.lourence.jonh.license.repository.LicenseDaoImpl;

public class LicenseService {
    private static LicenseService licenseService;
    private LicenseDao licenseDao;

    private LicenseService(){
        licenseDao = LicenseDaoImpl.getInstance();
    }

    public static LicenseService getInstance() {
        if(licenseService==null){
            licenseService = new LicenseService();
        }
        return licenseService;
    }

    public void addLicenseDetails(License license) {
        try {
            licenseDao.addLicenseDetails(license);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void deleteAll() {
        try {
            licenseDao.deleteAllLicense();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void updateLicense(License license) {
        try {
            licenseDao.updateLicense(license);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteLicenseByEmployeeId(int employeeId) {
        try{
            licenseDao.deleteLicenseByEmployeeId(employeeId);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public License getLicenseDetails(int employeeId) {
        try{
            return licenseDao.getLicenseDetails(employeeId);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
