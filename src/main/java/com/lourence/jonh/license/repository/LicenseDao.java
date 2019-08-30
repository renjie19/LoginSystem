package com.lourence.jonh.license.repository;

public interface LicenseDao {
    void addLicenseDetails(License teachingLicense) throws Exception;
    License getLicenseDetails(int employeeId) throws Exception;
    void deleteAllLicense() throws Exception;
    void updateLicense(License license) throws Exception;
    void deleteLicenseByEmployeeId(int employeeId) throws Exception;
}
