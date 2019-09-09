package com.lourence.jonh.section.repository;

import java.util.List;

public interface SectionDao {
    Section addSection(Section section);
    void deleteSection(int sectionId);
    Section updateSection(Section section);
    void deleteAll();
    Section getSectionById(int sectionId);
    List<Section> getAllSections();
}
