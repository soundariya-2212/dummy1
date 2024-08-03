package com.max.usecase.controllers;

import com.max.usecase.models.Assignment;
import com.max.usecase.services.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assignments")
public class AssignmentController {

    @Autowired
    private AssignmentService assignmentService;

    @GetMapping
    public List<Assignment> getAllAssignments() {
        return assignmentService.getAllAssignments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Assignment> getAssignmentById(@PathVariable Long id) {
        return assignmentService.getAssignmentById(id);
    }

    @PostMapping
    public Assignment createAssignment(@RequestBody Assignment assignment) {
        return assignmentService.createAssignment(assignment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Assignment> updateAssignment(@PathVariable Long id, @RequestBody Assignment assignment) {
        return assignmentService.updateAssignment(id, assignment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAssignment(@PathVariable Long id) {
        return assignmentService.deleteAssignment(id);
    }
}
