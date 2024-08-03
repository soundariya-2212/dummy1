package com.max.usecase.services;

import com.max.usecase.models.Enrollment;
import com.max.usecase.repos.EnrollmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnrollmentService {

    @Autowired
    private EnrollmentRepo enrollmentRepository;

    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }

    public ResponseEntity<Enrollment> getEnrollmentById(Long id) {
        Optional<Enrollment> enrollment = enrollmentRepository.findById(id);
        return enrollment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    public Enrollment createEnrollment(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    public ResponseEntity<Enrollment> updateEnrollment(Long id, Enrollment enrollment) {
        if (enrollmentRepository.existsById(id)) {
            enrollment.setId(id);
            return ResponseEntity.ok(enrollmentRepository.save(enrollment));
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<Void> deleteEnrollment(Long id) {
        if (enrollmentRepository.existsById(id)) {
            enrollmentRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
