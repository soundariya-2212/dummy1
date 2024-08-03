package com.max.usecase.controllers;

import com.max.usecase.models.LearningMaterial;
import com.max.usecase.services.LearningMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/learningmaterials")
public class LearningMaterialController {

    @Autowired
    private LearningMaterialService learningMaterialService;

    @GetMapping
    public List<LearningMaterial> getAllLearningMaterials() {
        return learningMaterialService.getAllLearningMaterials();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LearningMaterial> getLearningMaterialById(@PathVariable Long id) {
        return learningMaterialService.getLearningMaterialById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public LearningMaterial createLearningMaterial(@RequestBody LearningMaterial learningMaterial) {
        return learningMaterialService.createLearningMaterial(learningMaterial);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LearningMaterial> updateLearningMaterial(@PathVariable Long id, @RequestBody LearningMaterial learningMaterial) {
        return learningMaterialService.updateLearningMaterial(id, learningMaterial)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLearningMaterial(@PathVariable Long id) {
        if (learningMaterialService.deleteLearningMaterial(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
