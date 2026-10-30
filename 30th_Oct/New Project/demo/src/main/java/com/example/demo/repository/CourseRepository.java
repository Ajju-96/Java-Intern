package com.example.demo.repository;

import com.example.demo.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class CourseRepository {

    private final Map<Long, Course> courses = new ConcurrentHashMap<>();

    public CourseRepository(){
        courses.put(1L, new Course(1L, "Java", "Learn the java programming language"));
        courses.put(2L, new Course(2L, "Spring Boot", "Build REST APIs with Spring Boot"));
    }

    public List<Course> findAll(){
        return new ArrayList<>(courses.values());
    }

    public Course findById(Long id){
        return courses.get(id);
    }

    public Course save(Course course){
        courses.put(course.getId(), course);
        return course;
    }

    public void deleteById(Long id){
        courses.remove(id);
    }
}
