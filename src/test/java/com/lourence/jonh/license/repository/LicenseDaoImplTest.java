package com.lourence.jonh.license.repository;

import org.junit.jupiter.api.Test;

class LicenseDaoImplTest {

    @Test
    void addLicense() {
        License license = new License();
        license.setLicenseCode(334554);
        LicenseDaoImpl.getInstance().addLicense(license);
    }
}