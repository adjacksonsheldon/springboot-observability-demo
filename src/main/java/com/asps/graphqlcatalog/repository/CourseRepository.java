package com.asps.graphqlcatalog.repository;

import com.asps.graphqlcatalog.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}