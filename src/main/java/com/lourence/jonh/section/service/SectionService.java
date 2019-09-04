package com.lourence.jonh.section.service;

import com.lourence.jonh.section.repository.Section;
import com.lourence.jonh.section.repository.SectionDao;
import com.lourence.jonh.section.repository.SectionDaoImpl;

public class SectionService {
    private static SectionService sectionService;
    private SectionDao sectionDao;

    private SectionService(){
        sectionDao = SectionDaoImpl.getInstance();
    }

    public static SectionService getInstance() {
        if(sectionService==null) {
            sectionService = new SectionService();
        }
        return sectionService;
    }
    public Section addSection(Section section) {
        try {
            return sectionDao.addSection(section);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteSection(int sectionId) {
        try {
            sectionDao.deleteSection(sectionId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateSection(Section section) {
        try {
            sectionDao.updateSection(section);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteAll() {
        try {
            sectionDao.deleteAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    Section getSectionById(int sectionId) {
        try {
            return sectionDao.getSectionById(sectionId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
