package com.lourence.jonh.license.repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class License {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int licenseId;
    private int licenseCode;

    public int getLicenseId() {
        return licenseId;
    }

    public void setLicenseId(int licenseId) {
        this.licenseId = licenseId;
    }

    public int getLicenseCode() {
        return licenseCode;
    }

    public void setLicenseCode(int licenseCode) {
        this.licenseCode = licenseCode;
    }
}
