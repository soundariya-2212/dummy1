package com.max.usecase.controllers;

import com.max.usecase.models.Enrollment;
import com.max.usecase.services.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @GetMapping
    public List<Enrollment> getAllEnrollments() {
        return enrollmentService.getAllEnrollments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Enrollment> getEnrollmentById(@PathVariable Long id) {
        return enrollmentService.getEnrollmentById(id);
    }

    @PostMapping
    public Enrollment createEnrollment(@RequestBody Enrollment enrollment) {
        return enrollmentService.createEnrollment(enrollment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Enrollment> updateEnrollment(@PathVariable Long id, @RequestBody Enrollment enrollment) {
        return enrollmentService.updateEnrollment(id, enrollment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnrollment(@PathVariable Long id) {
        return enrollmentService.deleteEnrollment(id);
    }
}
