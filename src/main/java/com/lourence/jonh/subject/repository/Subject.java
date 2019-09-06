package com.lourence.jonh.subject.repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int  subjectCode;
    private String subject;

    public void setSubjectCode(int subjectCode) {
        this.subjectCode = subjectCode;
    }

    public int getSubjectCode() {
        return subjectCode;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }
}
