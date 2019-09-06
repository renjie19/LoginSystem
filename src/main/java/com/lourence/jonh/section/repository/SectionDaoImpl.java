package com.lourence.jonh.section.repository;

import com.lourence.jonh.employee.repository.Employee;
import com.lourence.jonh.util.Hibernate;
import com.lourence.jonh.util.MySqlConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
        return null;
    }

    @Override
    public void deleteSection(int sectionId) throws Exception {
        Hibernate hibernate = new Hibernate();
        hibernate.remove(Section.class,sectionId);
    }

    @Override
    public void updateSection(Section section) throws Exception {
        Hibernate hibernate = new Hibernate();
        hibernate.merge(section);
    }

    @Override
    public void deleteAll() throws Exception {
        String insertSql = "DELETE FROM section";
        PreparedStatement preparedStatement = MySqlConnector.getInstance().prepareStatement(insertSql);
        MySqlConnector.getInstance().executeUpdate(preparedStatement);
    }

    @Override
    public Section getSectionById(int sectionId) {
        Hibernate hibernate = new Hibernate();
        return (Section)hibernate.find(Section.class,sectionId);
    }

    @Override
    public List<Section> getAllSections() throws Exception {
        List<Section> sectionList = new ArrayList<Section>();
        String insertSql = "select * from section left join teachersection t on section.sectionId = t.sectionId " +
                "left join employee e on t.employeeId = e.id order by sectionName";
        PreparedStatement preparedStatement = MySqlConnector.getInstance().prepareStatement(insertSql);
        ResultSet resultSet = MySqlConnector.getInstance().executeQuery(preparedStatement);
        while(resultSet.next()){
            sectionList.add(generateSection(resultSet));
        }
        return sectionList;
    }

    private Section generateSection(ResultSet resultSet) throws Exception {
        Section section = new Section();
        section.setSectionId(resultSet.getInt("sectionId"));
        section.setSectionName(resultSet.getString("sectionName"));
        section.setYearLevel(resultSet.getString("yearLevel"));
        List<Employee> employeeList = new ArrayList<Employee>();
        Employee employee = new Employee();
        employee.setEmployeeId(resultSet.getInt("id"));
        employee.setName(resultSet.getString("name"));
        employee.setAge(resultSet.getInt("age"));
        employee.setAddress(resultSet.getString("address"));
        employee.setPosition(resultSet.getString("position"));
        employeeList.add(employee);
        while(resultSet.next() && resultSet.getString("sectionName").equals(section.getSectionName())){
            employee = new Employee();
            employee.setEmployeeId(resultSet.getInt("id"));
            employee.setName(resultSet.getString("name"));
            employee.setAge(resultSet.getInt("age"));
            employee.setAddress(resultSet.getString("address"));
            employee.setPosition(resultSet.getString("position"));
            employeeList.add(employee);
        }
        resultSet.previous();
        section.setEmployees(employeeList);
        return section;
    }
}
