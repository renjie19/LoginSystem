package com.lourence.jonh.section.repository;

import com.lourence.jonh.util.Hibernate;

import java.util.List;

public class SectionDaoImpl implements SectionDao {
    private static SectionDaoImpl sectionDao;

    private SectionDaoImpl() {
    }

    public static SectionDaoImpl getInstance() {
        if(sectionDao==null) {
            sectionDao = new SectionDaoImpl();
        }
        return sectionDao;
    }

    @Override
    public Section addSection(Section section) {
        Hibernate hibernate = new Hibernate();
        hibernate.persist(section);
        return section;
    }

    @Override
    public void deleteSection(int sectionId) {
        Hibernate hibernate = new Hibernate();
        hibernate.remove(Section.class,sectionId);
    }

    @Override
    public Section updateSection(Section section) {
        Hibernate hibernate = new Hibernate();
        hibernate.merge(section);
        return section;
    }

    @Override
    public void deleteAll() {
        String insertSql = "DELETE FROM Section";
        Hibernate hibernate = new Hibernate();
        hibernate.createNativeQuery(insertSql);
    }

    @Override
    public Section getSectionById(int sectionId) {
        Hibernate hibernate = new Hibernate();
        return (Section)hibernate.find(Section.class,sectionId);
    }

    @Override
    public List<Section> getAllSections() {
        String insertSql = "Select s from Section s";
        Hibernate hibernate = new Hibernate();
        return hibernate.createNamedQuery(insertSql);
    }
}
