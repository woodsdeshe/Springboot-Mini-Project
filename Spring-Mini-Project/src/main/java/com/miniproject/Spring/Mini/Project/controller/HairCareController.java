package com.miniproject.Spring.Mini.Project.controller;

import com.miniproject.Spring.Mini.Project.model.HairCareCategory;
import com.miniproject.Spring.Mini.Project.service.HairCareService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<HairCareCategory> getCategories() {
        return hairCareService.getHairCategories();
    }

    @PostMapping(path = "/categories/")
    public HairCareCategory createHairCategory(@RequestBody HairCareCategory hairCareObject) {
        return hairCareService.createHairCategory(hairCareObject);
    }
}