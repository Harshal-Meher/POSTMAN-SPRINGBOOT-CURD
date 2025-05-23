package com.rssoft.restapi.controllers;

import com.rssoft.restapi.entities.Course;
import com.rssoft.restapi.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {
    @Autowired
    CourseService courseService;

    @GetMapping("/home")
    public String Home() {
        return "Welcome Home";
    }
    @GetMapping("/courses")
    public List<Course> getCourse() {
        return this.courseService.getAllCourse();
    }

    @GetMapping("/courses/{courseId}")
    public Course getCourseById(@PathVariable String courseId) {
        return this.courseService.getCourseById(Integer.parseInt(courseId));
    }

    @PostMapping("/courses")
    public Course addCourse(@RequestBody Course course){
        return this.courseService.addCourse(course);
    }
    @PutMapping("/courses")
    public Course updateCourse(@RequestBody Course course){
        return this.courseService.UpdateCourse(course);
    }

    @DeleteMapping("/courses/{courseId}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable int courseId) {
        try {
            this.courseService.deleteCourse(courseId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
