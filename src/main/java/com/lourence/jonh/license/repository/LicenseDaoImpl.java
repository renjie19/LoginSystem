package com.lourence.jonh.license.repository;

import com.lourence.jonh.util.Hibernate;

public class LicenseDaoImpl implements LicenseDao {
    private static LicenseDaoImpl licenseDao;

    private LicenseDaoImpl() {

    }

    public static LicenseDaoImpl getInstance() {
        if(licenseDao==null) {
            licenseDao = new LicenseDaoImpl();
        }
        return licenseDao;
    }

    @Override
    public void addLicense(License license) {
        Hibernate hibernate = new Hibernate();
        hibernate.persist(license);
    }
}
