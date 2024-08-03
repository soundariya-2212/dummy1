package com.max.usecase.services;

import com.max.usecase.models.CourseRating;
import com.max.usecase.repos.CourseRatingRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseRatingService {

    @Autowired
    private CourseRatingRepo courseRatingRepository;

    public List<CourseRating> getAllRatings() {
        return courseRatingRepository.findAll();
    }

    public ResponseEntity<CourseRating> getRatingById(Long id) {
        Optional<CourseRating> rating = courseRatingRepository.findById(id);
        return rating.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    public CourseRating createRating(CourseRating rating) {
        return courseRatingRepository.save(rating);
    }

    public ResponseEntity<CourseRating> updateRating(Long id, CourseRating rating) {
        if (courseRatingRepository.existsById(id)) {
            rating.setId(id);
            return ResponseEntity.ok(courseRatingRepository.save(rating));
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<Void> deleteRating(Long id) {
        if (courseRatingRepository.existsById(id)) {
            courseRatingRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
