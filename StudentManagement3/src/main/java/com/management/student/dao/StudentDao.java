package com.management.student.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.management.student.dto.PaginationDto;
import com.management.student.model.Student;
import com.management.student.util.ComparatorUtil;

@Repository
public class StudentDao implements IStudentDao {

    /** The Constant logger. */
    final static Logger logger = Logger.getLogger(StudentDao.class);

    static Map<String, Student> studentMap = new HashMap<String, Student>();

    {
        Student student1 = new Student("1", "A", "Bathinda", 23);
        studentMap.put("1", student1);
        Student student2 = new Student("2", "B", "Bathinda", 23);
        studentMap.put("2", student2);
        Student student3 = new Student("3", "S", "Bathinda", 23);
        studentMap.put("3", student3);
        Student student4 = new Student("4", "D", "Bathinda", 23);
        studentMap.put("4", student4);
        Student student5 = new Student("5", "F", "Bathinda", 23);
        studentMap.put("5", student5);
        Student student6 = new Student("6", "G", "Bathinda", 23);
        studentMap.put("6", student6);
        Student student7 = new Student("7", "H", "Bathinda", 23);
        studentMap.put("7", student7);
        Student student8 = new Student("8", "J", "Bathinda", 23);
        studentMap.put("8", student8);
        Student student9 = new Student("9", "K", "Bathinda", 23);
        studentMap.put("9", student9);
        Student student10 = new Student("10", "L", "Bathinda", 23);
        studentMap.put("10", student10);
        Student student11 = new Student("11", "Gagan", "Bathinda", 23);
        studentMap.put("11", student11);
        Student student12 = new Student("12", "W", "Bathinda", 23);
        studentMap.put("12", student12);
        Student student13 = new Student("13", "E", "Bathinda", 23);
        studentMap.put("13", student13);
        Student student14 = new Student("14", "R", "Bathinda", 23);
        studentMap.put("14", student14);
        Student student15 = new Student("15", "T", "Bathinda", 23);
        studentMap.put("15", student15);

    }

    /** The jdbc template. */
    @Autowired
//    private MongoTemplate jdbcTemplate;

    public List<Student> getAll() throws IOException {
//        List<Student> studentList = this.jdbcTemplate.findAll(Student.class);
        List<Student> studentList = new ArrayList(studentMap.values());
        logger.debug("Fetched student List : " + studentList);
        return studentList;
    }



    public void delete(final String rollNo) throws IOException {
        logger.debug("deleting student with roll no : " + rollNo);
//        Query query = new Query(Criteria.where("rollNumber").is(rollNo));
//        this.jdbcTemplate.remove(query, Student.class);
        studentMap.remove(rollNo);
        logger.debug("student with roll no : " + rollNo + " has been deleted successfully");
    }

    public void update(final Student student) throws IOException {
        logger.debug("updating student with roll no : " + student.getRollNumber());
        studentMap.put(student.getRollNumber(), student);

//        Update update = new Update();
//
//        update.set("name", student.getName());
//        update.set("age", student.getAge());
//        update.set("address", student.getAddress());
//        this.jdbcTemplate
//            .updateMulti(new Query(Criteria.where("rollNumber").is(student.getRollNumber())), update, Student.class);

        logger.debug("student with roll no : " + student.getRollNumber() + " has been updated successfully");
    }

    public void add(final Student student) throws IOException {
        logger.debug("adding student with detail : " + student);
        studentMap.put(student.getRollNumber(), student);

//        this.jdbcTemplate.insert(student);
        logger.debug("student with detail : " + student + "has been added successfully");
    }



    public boolean alreadyExist(final String rollNumber) throws IOException {
        boolean result = false;

        Student student = studentMap.get(rollNumber);
        if (student != null) {
            result = true;
        }

//        Student student = this.jdbcTemplate.findOne(new Query(Criteria.where("rollNumber").is(rollNumber)), Student.class);
//        if(student != null) {
//            logger.debug("student with roll number : "+ rollNumber + " alredy Exist");
//            result = true;
//        }

        return result;
    }



    public List<Student> getAll(PaginationDto paginationDto) throws IOException {
//      List<Student> studentList = this.jdbcTemplate.findAll(Student.class);
        int pageNumber = (paginationDto.getDisplayStart() + paginationDto.getDisplayLength())/paginationDto.getDisplayLength();
        int pageLength = paginationDto.getDisplayLength();
        int count = pageNumber*pageLength;
        int maxCount = (pageNumber+1)*pageLength;

      List<Student> studentList = new ArrayList(studentMap.values());
      Comparator comparator = ComparatorUtil.getComparator(paginationDto.getColumnToSort(), paginationDto.getSortingDir());
      Set<Student> filteredSet = new TreeSet<Student>(comparator);

      for (Student student : studentList) {
          if (student.contains(paginationDto.getTextToSearch())) {
              filteredSet.add(student);
          }
      }

      studentList = new ArrayList<Student>();
      for (Student student : filteredSet) {
          count++;
          if (count == maxCount) {
              break;
          }
          studentList.add(student);
      }

      logger.debug("Fetched student List : " + studentList);
      return studentList;
    }

}