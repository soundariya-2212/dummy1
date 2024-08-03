// package com.max.usecase.controllers;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.RestController;

// import com.max.usecase.models.Course;
// import com.max.usecase.services.CourseService;

// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;


// @RestController
// @RequestMapping("/courses")
// public class CourseController {
    
//     @Autowired
//     private CourseService cor;

//     @PostMapping("/register")
//     public Course addcourse(@RequestBody Course course)
//     {
//         return cor.addcourse(course);
//     }

    
    
// }



package com.max.usecase.controllers;

import com.max.usecase.models.Course;
import com.max.usecase.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }

    @PostMapping
    public Course createCourse(@RequestBody Course course) {
        return courseService.createCourse(course);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody Course course) {
        return courseService.updateCourse(id, course);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        return courseService.deleteCourse(id);
    }
}
