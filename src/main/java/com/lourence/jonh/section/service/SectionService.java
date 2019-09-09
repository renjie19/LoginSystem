package com.lourence.jonh.section.service;

import com.lourence.jonh.section.repository.Section;
import com.lourence.jonh.section.repository.SectionDao;
import com.lourence.jonh.section.repository.SectionDaoImpl;

public class SectionService {
    private SectionDao sectionDao;

    public SectionService(){
        sectionDao = SectionDaoImpl.getInstance();
    }

    public void addSection(Section section) {
        sectionDao.addSection(section);
    }

    public void deleteSection(int sectionId) {
        sectionDao.deleteSection(sectionId);
    }

    public void updateSection(Section section) {
        sectionDao.updateSection(section);
    }

    public void deleteAll() {
        sectionDao.deleteAll();
    }

    Section getSectionById(int sectionId) {
        return sectionDao.getSectionById(sectionId);
    }
}
