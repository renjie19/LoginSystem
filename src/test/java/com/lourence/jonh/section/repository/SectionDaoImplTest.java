package com.lourence.jonh.section.repository;

import org.junit.jupiter.api.Test;

import java.util.List;

class SectionDaoImplTest {





    @Test
    void getSectionById() {
        Section section = SectionDaoImpl.getInstance().getSectionById(1);
    }

    @Test
    void deleteAll() {
        SectionDaoImpl.getInstance().deleteAll();
    }

    @Test
    void getAllSection() {
        List<Section> sectionList = SectionDaoImpl.getInstance().getAllSections();
    }
}