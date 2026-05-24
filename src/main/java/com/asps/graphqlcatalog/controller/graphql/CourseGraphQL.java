package com.asps.graphqlcatalog.controller.graphql;

import com.asps.graphqlcatalog.dto.input.CreateCourseInput;
import com.asps.graphqlcatalog.entity.Category;
import com.asps.graphqlcatalog.entity.Course;
import com.asps.graphqlcatalog.service.CategoryService;
import com.asps.graphqlcatalog.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CourseGraphQL {
    private final CourseService courseService;
    private final CategoryService categoryService;

    @MutationMapping
    public Course createCourse(@Argument CreateCourseInput course) {
        return courseService.save(course);
    }

    @MutationMapping
    public Boolean deleteCourse(@Argument Long id) {
        return courseService.deleteById(id);
    }

    @QueryMapping
    public Course course(@Argument Long id) {
        return courseService.findById(id);
    }


    @QueryMapping
    public List<Course> courses() {
        return courseService.findAll();
    }

    @SchemaMapping(typeName = "Course", field = "category")
    public Category findCategory(Course course) {
        return categoryService.findById(course.getCategory().getId());
    }

}
