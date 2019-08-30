package com.lourence.jonh.section.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class SectionDaoImplTest {

    @BeforeEach
    void before() {
        try {
            SectionDao sectionDao = new SectionDaoImpl();
            sectionDao.deleteAll();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    void addSection() {
        try {
            Section section = new Section();
            section.setSectionName("Rose");
            section.setYearLevel("Grade 7");
            SectionDao sectionDao = new SectionDaoImpl();
            Section savedSection = sectionDao.addSection(section);
            assertEquals(section.getSectionName(),savedSection.getSectionName());
            assertEquals(section.getYearLevel(),savedSection.getYearLevel());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    void deleteSection() {
        try {
            Section section = new Section();
            section.setSectionName("Rose");
            SectionDao sectionDao = new SectionDaoImpl();
            Section savedSection = sectionDao.addSection(section);
            sectionDao.deleteSection(savedSection.getSectionId());
            Section afterDelete = sectionDao.getSectionById(savedSection.getSectionId());
            assertNull(afterDelete);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void updateSection() {
        try {
            Section section = new Section();
            section.setSectionName("Rose");
            section.setYearLevel("Grade 7");
            SectionDao sectionDao = new SectionDaoImpl();
            Section savedSection = sectionDao.addSection(section);
           savedSection.setSectionName("Lily");
           sectionDao.updateSection(savedSection);
           assertEquals("Lily",savedSection.getSectionName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}