package com.lourence.jonh.section.repository;

import org.junit.jupiter.api.Test;

class SectionDaoImplTest {





    @Test
    void getSectionById() {
        Section section = SectionDaoImpl.getInstance().getSectionById(1);
    }

}