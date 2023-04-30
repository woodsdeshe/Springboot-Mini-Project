package com.miniproject.Spring.Mini.Project.service;

import com.miniproject.Spring.Mini.Project.exception.InformationExistException;
import com.miniproject.Spring.Mini.Project.exception.InformationNotFoundException;
import com.miniproject.Spring.Mini.Project.model.Accessories;
import com.miniproject.Spring.Mini.Project.model.Category;
import com.miniproject.Spring.Mini.Project.repository.AccessoriesRepository;
import com.miniproject.Spring.Mini.Project.repository.HairCareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@Service
public class HairCareService {

    private AccessoriesRepository accessoriesRepository;

    @Autowired
    public void setAccessoriesRepository(AccessoriesRepository accessoriesRepository) {
        this.accessoriesRepository = accessoriesRepository;
    }

    private HairCareRepository hairCareRepository;

    @Autowired
    public void setHairCareRepository(HairCareRepository hairCareRepository) {
        this.hairCareRepository = hairCareRepository;
    }

    public List<Category> getHairCategories() {
        System.out.println("service calling getHairCategories");
        return hairCareRepository.findAll();
    }

    public Category createHairCategory(Category hairCareObject) {
        System.out.println("service calling createCategory ==>");

        Category category = hairCareRepository.findByName(hairCareObject.getName());
        if (category != null) {
            throw new InformationExistException("category with name " + category.getName() + " already exists");
        } else {
            return hairCareRepository.save(hairCareObject);
        }
    }

    public Category getHairCategory(Long hairCategoryId) {
        System.out.println("service calling getHairCategory");
        Category category = hairCareRepository.findHairCareCategoryById(hairCategoryId);

        if (category == null) {
            throw new InformationNotFoundException("category not found for " + hairCategoryId);
        } else {
            return category;
        }
    }

    public Category updateHairCategory(Long hairCategoryId, Category hairCareObject) {
        System.out.println("service calling updateHairCategory");
        Category category = getHairCategory(hairCategoryId);
            if (hairCareObject.equals(hairCareRepository.findByName(hairCareObject.getName()))){
                throw new InformationExistException("Category " + category.getName() + " already exists");
            } else {
                Category updateHairCategory = hairCareRepository.findHairCareCategoryById(hairCategoryId);
                updateHairCategory.setName(hairCareObject.getName());
                updateHairCategory.setDescription(hairCareObject.getDescription());
                return hairCareRepository.save(updateHairCategory);
        }
    }


    public void deleteHairCategory(Long categoryId) {
        System.out.println("service calling deleteHairCategory ==>");
        Optional<Category> category = hairCareRepository.findById(categoryId);
        if (category.isPresent()) {
            hairCareRepository.delete(category.get());
        } else {
            throw new InformationNotFoundException("Category with id " + categoryId + " not found ");
        }
    }

    public List<Accessories> getAccessories(Long hairCategoryId) {
        System.out.println("service calling getAccessories ==>");
        Category category = getHairCategory(hairCategoryId);
        if (category.getAccessoriesList().isEmpty()) {
            throw new InformationNotFoundException("Accessories not found in category " + hairCategoryId);
        }
        return category.getAccessoriesList();
    }

    public Accessories createAccessories(Long categoryId, Accessories accessoryObject) {
        try {
            Optional<Category> category = hairCareRepository.findById(categoryId);
            accessoryObject.setCategory(category.get());
            return accessoriesRepository.save(accessoryObject);
        } catch (NoSuchElementException e) {
            throw new InformationNotFoundException("category with id " + categoryId + " not found");
        }
    }

    public Accessories getAccessory(Long categoryId, Long accessoryId) {
        Category category = getHairCategory(categoryId);
        Accessories accessory = accessoriesRepository.findAccessoriesById(accessoryId);
        return category
    }
}
