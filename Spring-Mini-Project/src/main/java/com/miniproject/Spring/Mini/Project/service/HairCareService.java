package com.miniproject.Spring.Mini.Project.service;

import com.miniproject.Spring.Mini.Project.exception.InformationExistException;
import com.miniproject.Spring.Mini.Project.exception.InformationNotFoundException;
import com.miniproject.Spring.Mini.Project.model.Accessories;
import com.miniproject.Spring.Mini.Project.model.HairCareCategory;
import com.miniproject.Spring.Mini.Project.repository.AccessoriesRepository;
import com.miniproject.Spring.Mini.Project.repository.HairCareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
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

    public List<HairCareCategory> getHairCategories() {
        System.out.println("service calling getHairCategories");
        return hairCareRepository.findAll();
    }

    public HairCareCategory createHairCategory(HairCareCategory hairCareObject) {
        System.out.println("service calling createCategory ==>");

        HairCareCategory category = hairCareRepository.findByName(hairCareObject.getName());
        if (category != null) {
            throw new InformationExistException("category with name " + category.getName() + " already exists");
        } else {
            return hairCareRepository.save(hairCareObject);
        }
    }

    public HairCareCategory getHairCategory(Long hairCategoryId) {
        System.out.println("service calling getHairCategory");
        HairCareCategory category = hairCareRepository.findHairCareCategoryById(hairCategoryId);

        if (category == null) {
            throw new InformationNotFoundException("category not found for " + hairCategoryId);
        } else {
            return category;
        }
    }

    public HairCareCategory updateHairCategory(Long hairCategoryId, HairCareCategory hairCareObject) {
        System.out.println("service calling updateHairCategory");
        HairCareCategory category = getHairCategory(hairCategoryId);
            if (hairCareObject.equals(hairCareRepository.findByName(hairCareObject.getName()))){
                throw new InformationExistException("Category " + category.getName() + " already exists");
            } else {
                HairCareCategory updateHairCategory = hairCareRepository.findHairCareCategoryById(hairCategoryId);
                updateHairCategory.setName(hairCareObject.getName());
                updateHairCategory.setDescription(hairCareObject.getDescription());
                return hairCareRepository.save(updateHairCategory);
        }
    }


    public HairCareCategory deleteHairCategory(Long categoryId) {
        Optional<HairCareCategory> category = hairCareRepository.findById(categoryId);
        if (category.isPresent()) {
            hairCareRepository.delete(category.get());
            return category.get();
        } else {
            throw new InformationNotFoundException("Category with id " + categoryId + " not found ");
        }
    }

    public List<Accessories> getAccessories(Long hairCategoryId) {
        System.out.println("service calling getAccessories");
        HairCareCategory category = getHairCategory(hairCategoryId);
        return category.getAccessoriesList();
    }
}
