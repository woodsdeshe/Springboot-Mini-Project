package com.miniproject.Spring.Mini.Project.controller;

import com.miniproject.Spring.Mini.Project.model.Accessories;
import com.miniproject.Spring.Mini.Project.model.Category;
import com.miniproject.Spring.Mini.Project.service.HairCareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/api")
public class HairCareController {

    private HairCareService hairCareService;

    @Autowired
    public void setHairCareService(HairCareService hairCareService) {
        this.hairCareService = hairCareService;
    }

    // http://localhost:9093/api/categories/
    @GetMapping(path = "/categories/")
    public List<Category> getCategories() {
        return hairCareService.getHairCategories();
    }

    // http://localhost:9093/api/categories/
    @PostMapping(path = "/categories/")
    public Category createHairCategory(@RequestBody Category hairCareObject) {
        return hairCareService.createHairCategory(hairCareObject);
    }

    // http://localhost:9093/api/categories/{categoryId}/
    @GetMapping(path = "/categories/{hairCategoryId}/")
    public Category getHairCategory(@PathVariable  Long hairCategoryId) {
        return hairCareService.getHairCategory(hairCategoryId);
    }

    // http://localhost:9093/api/categories/{categoryId}/
    @PutMapping(path = "/categories/{hairCategoryId}/")
    public Category updateHairCategory(@PathVariable Long hairCategoryId, @RequestBody Category hairCareObject) {
        return hairCareService.updateHairCategory(hairCategoryId, hairCareObject);
    }

    // http://localhost:9093/api/categories/{categoryId}/
    @DeleteMapping(path = "/categories/{hairCategoryId}/")
    public ResponseEntity<Void> deleteHairCategory(@PathVariable(value = "hairCategoryId") Long hairCategoryId) {
        hairCareService.deleteHairCategory(hairCategoryId);
        return ResponseEntity.noContent().build();
    }

    // http://localhost:9093/api/categories/{categoryId}/accessories/
    @GetMapping(path = "/categories/{hairCategoryId}/accessories/")
    public List<Accessories> getHairAccessories(@PathVariable(value = "hairCategoryId") Long hairCategoryId) {
        return hairCareService.getAccessories(hairCategoryId);
    }

    // http://localhost:9093/api/categories/{categoryId}/accessories/{accessoryId}
    @GetMapping(path = "/categories/{hairCategoryId}/accessories/{accessoryId}/")
    public Accessories getAccessory(@PathVariable(value = "hairCategoryId") Long hairCategoryId, @PathVariable(value = "accessoryId") Long accessoryId) {
        return hairCareService.getAccessory(hairCategoryId, accessoryId);
    }

    // http://localhost:9093/api/categories/{categoryId}/accessories/
    @PostMapping(path = "/categories/{hairCategoryId}/accessories/")
    public Accessories createAccessories(@PathVariable(value = "hairCategoryId") Long hairCategoryId, @RequestBody Accessories accessoryObject) {
        return hairCareService.createAccessories(hairCategoryId, accessoryObject);
    }

    // http://localhost:9093/api/categories/{categoryId}/accessories/{accessoryId}
    @PutMapping(path = "/categories/{hairCategoryId}/accessories/{accessoryId}/")
    public Accessories updateAccessory(@PathVariable(value = "hairCategoryId") Long hairCategoryId,                                        @PathVariable(value = "accessoryId") Long accessoryId,
                                       @RequestBody Accessories accessoryObject) {
        return hairCareService.updateAccessory(hairCategoryId,accessoryId,accessoryObject);
    }

    // http://localhost:9093/api/categories/{categoryId}/accessories/{accessoryId}
    @DeleteMapping(path = "/categories/{hairCategoryId}/accessories/{accessoryId}/")
    public void deleteAccessory(@PathVariable(value = "hairCategoryId") Long hairCategoryId, @PathVariable(value = "accessoryId") Long accessoryId) {
        hairCareService.deleteAccessory(hairCategoryId,accessoryId);
    }
}