package com.max.usecase.controllers;

import com.max.usecase.models.SubModule;
import com.max.usecase.services.SubModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/submodules")
public class SubModuleController {

    @Autowired
    private SubModuleService subModuleService;

    @GetMapping
    public List<SubModule> getAllSubModules() {
        return subModuleService.getAllSubModules();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubModule> getSubModuleById(@PathVariable Long id) {
        return subModuleService.getSubModuleById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public SubModule createSubModule(@RequestBody SubModule subModule) {
        return subModuleService.createSubModule(subModule);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubModule> updateSubModule(@PathVariable Long id, @RequestBody SubModule subModule) {
        return subModuleService.updateSubModule(id, subModule)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubModule(@PathVariable Long id) {
        if (subModuleService.deleteSubModule(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
