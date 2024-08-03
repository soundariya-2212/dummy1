package com.max.usecase.services;

import com.max.usecase.models.LearningMaterial;
import com.max.usecase.repos.LearningMaterialRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LearningMaterialService {

    @Autowired
    private LearningMaterialRepo learningMaterialRepository;

    public List<LearningMaterial> getAllLearningMaterials() {
        return learningMaterialRepository.findAll();
    }

    public Optional<LearningMaterial> getLearningMaterialById(Long id) {
        return learningMaterialRepository.findById(id);
    }

    public LearningMaterial createLearningMaterial(LearningMaterial learningMaterial) {
        return learningMaterialRepository.save(learningMaterial);
    }

    public Optional<LearningMaterial> updateLearningMaterial(Long id, LearningMaterial learningMaterial) {
        if (learningMaterialRepository.existsById(id)) {
            learningMaterial.setId(id);
            return Optional.of(learningMaterialRepository.save(learningMaterial));
        } else {
            return Optional.empty();
        }
    }

    public boolean deleteLearningMaterial(Long id) {
        if (learningMaterialRepository.existsById(id)) {
            learningMaterialRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
