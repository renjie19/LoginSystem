package com.lourence.jonh.section.repository;

import java.util.List;

public interface SectionDao {
    Section addSection(Section section);
    void deleteSection(int sectionId) throws Exception;
    void updateSection(Section section) throws Exception;
    void deleteAll() throws Exception;
    Section getSectionById(int sectionId);
    List<Section> getAllSections() throws Exception;
}
