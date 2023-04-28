package com.miniproject.Spring.Mini.Project.service;

import com.miniproject.Spring.Mini.Project.exception.InformationExistException;
import com.miniproject.Spring.Mini.Project.model.HairCareCategory;
import com.miniproject.Spring.Mini.Project.repository.HairCareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HairCareService {

    private HairCareRepository hairCareRepository;

    @Autowired
    public void setHairCareRepository(HairCareRepository hairCareRepository) {
        this.hairCareRepository = hairCareRepository;
    }

    public List<HairCareCategory> getHairCategories() {
        System.out.println("service calling getHairCategories");
        return hairCareRepository.findAll();
    }

    public HairCareCategory createHairCategory(HairCareCategory hairCareObject) {
        HairCareCategory hairCategory = hairCareRepository.findByName(hairCareObject.getName());
        if (hairCareObject != null) {
            throw new InformationExistException("Category with the name " + hairCategory.getName() + " already exists");
        } else {
            return hairCareRepository.save(hairCareObject);
        }
    }
}
