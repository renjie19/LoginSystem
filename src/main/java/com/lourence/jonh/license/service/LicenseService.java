package com.lourence.jonh.license.service;

import com.lourence.jonh.license.repository.License;
import com.lourence.jonh.license.repository.LicenseDao;
import com.lourence.jonh.license.repository.LicenseDaoImpl;

public class LicenseService {
    private LicenseDao licenseDao;

    public LicenseService() {
        this.licenseDao = LicenseDaoImpl.getInstance();
    }

    public void addLicense(License license) {
        licenseDao.addLicense(license);
    }
}
