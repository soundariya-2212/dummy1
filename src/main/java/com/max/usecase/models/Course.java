package com.max.usecase.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String category;
    private String difficultyLevel;
    private String syllabus;
    private String schedule;
    private String prerequisites;
    private boolean isApproved = false;
    private float rating;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user; // Creator of the course (Instructor)

    @OneToMany(mappedBy = "course")
    @JsonManagedReference
    private List<Enrollment> enrollments;

    @OneToMany(mappedBy = "course")
    @JsonManagedReference
    private List<LearningMaterial> learningMaterials;

    @OneToMany(mappedBy = "course")
    @JsonManagedReference
    private List<Assignment> assignments;

    @OneToMany(mappedBy = "course")
    @JsonManagedReference
    private List<SubModule> subModules;

    @OneToMany(mappedBy = "course")
    @JsonManagedReference
    private List<CourseRating> ratings;

    // Constructors
    public Course() {}

    public Course(Long id, String title, String category, String difficultyLevel, String syllabus, String schedule, String prerequisites, boolean isApproved, float rating, User user, List<Enrollment> enrollments, List<LearningMaterial> learningMaterials, List<Assignment> assignments, List<SubModule> subModules, List<CourseRating> ratings) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.difficultyLevel = difficultyLevel;
        this.syllabus = syllabus;
        this.schedule = schedule;
        this.prerequisites = prerequisites;
        this.isApproved = isApproved;
        this.rating = rating;
        this.user = user;
        this.enrollments = enrollments;
        this.learningMaterials = learningMaterials;
        this.assignments = assignments;
        this.subModules = subModules;
        this.ratings = ratings;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public String getSyllabus() {
        return syllabus;
    }

    public void setSyllabus(String syllabus) {
        this.syllabus = syllabus;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getPrerequisites() {
        return prerequisites;
    }

    public void setPrerequisites(String prerequisites) {
        this.prerequisites = prerequisites;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean isApproved) {
        this.isApproved = isApproved;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(List<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }

    public List<LearningMaterial> getLearningMaterials() {
        return learningMaterials;
    }

    public void setLearningMaterials(List<LearningMaterial> learningMaterials) {
        this.learningMaterials = learningMaterials;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<Assignment> assignments) {
        this.assignments = assignments;
    }

    public List<SubModule> getSubModules() {
        return subModules;
    }

    public void setSubModules(List<SubModule> subModules) {
        this.subModules = subModules;
    }

    public List<CourseRating> getRatings() {
        return ratings;
    }

    public void setRatings(List<CourseRating> ratings) {
        this.ratings = ratings;
    }
}
