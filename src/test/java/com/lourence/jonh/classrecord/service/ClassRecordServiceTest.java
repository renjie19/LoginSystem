package com.lourence.jonh.classrecord.service;

import com.lourence.jonh.employee.service.EmployeeService;
import com.lourence.jonh.section.service.SectionService;
import org.junit.jupiter.api.BeforeEach;

class ClassRecordServiceTest {
    @BeforeEach
    void before() {
        EmployeeService.getInstance().deleteAllEmployee();
        SectionService.getInstance().deleteAll();
    }
}