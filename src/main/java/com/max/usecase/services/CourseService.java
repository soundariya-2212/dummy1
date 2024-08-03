// package com.max.usecase.services;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.max.usecase.models.Course;
// import com.max.usecase.repos.CourseRepo;

// @Service
// public class CourseService {
    
//     @Autowired
//     private CourseRepo corepo;

//     public Course addcourse(Course course)
//     {
//         return corepo.save(course);
//     }
    
// }



package com.max.usecase.services;

import com.max.usecase.models.Course;
import com.max.usecase.repos.CourseRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepo courseRepo;

    public List<Course> getAllCourses() {
        return courseRepo.findAll();
    }

    public ResponseEntity<Course> getCourseById(Long id) {
        Optional<Course> course = courseRepo.findById(id);
        return course.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    public Course createCourse(Course course) {
        return courseRepo.save(course);
    }

    public ResponseEntity<Course> updateCourse(Long id, Course course) {
        if (courseRepo.existsById(id)) {
            course.setId(id);
            return ResponseEntity.ok(courseRepo.save(course));
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<Void> deleteCourse(Long id) {
        if (courseRepo.existsById(id)) {
            courseRepo.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
