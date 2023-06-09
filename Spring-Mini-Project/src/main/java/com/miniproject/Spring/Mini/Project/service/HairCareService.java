package com.miniproject.Spring.Mini.Project.service;

import com.miniproject.Spring.Mini.Project.exception.InformationExistException;
import com.miniproject.Spring.Mini.Project.exception.InformationNotFoundException;
import com.miniproject.Spring.Mini.Project.model.Accessories;
import com.miniproject.Spring.Mini.Project.model.Category;
import com.miniproject.Spring.Mini.Project.model.User;
import com.miniproject.Spring.Mini.Project.security.MyUserDetails;
import com.miniproject.Spring.Mini.Project.repository.AccessoriesRepository;
import com.miniproject.Spring.Mini.Project.repository.HairCareRepository;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@Service
public class HairCareService {

    private AccessoriesRepository accessoriesRepository;
    private HairCareRepository hairCareRepository;


    @Autowired
    public void setAccessoriesRepository(AccessoriesRepository accessoriesRepository) {
        this.accessoriesRepository = accessoriesRepository;
    }

    @Autowired
    public void setHairCareRepository(HairCareRepository hairCareRepository) {
        this.hairCareRepository = hairCareRepository;
    }

    public static User getCurrentLoggedInUser() {
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userDetails.getUser();
    }


    public List<Category> getHairCategories() {
        System.out.println("service calling getHairCategories");
        List<Category> category = hairCareRepository.findByUserId(HairCareService.getCurrentLoggedInUser().getId());
        if (category.isEmpty()) {
            throw new InformationNotFoundException("No categories found for user " + HairCareService.getCurrentLoggedInUser().getId());
        } else {
            return category;
        }
    }

    public Category createHairCategory(Category hairCareObject) {
        System.out.println("service calling createCategory ==>");

        Category category = hairCareRepository.findByUserIdAndName(HairCareService.getCurrentLoggedInUser().getId(), hairCareObject.getName());
        if (category != null) {
            throw new InformationExistException("category with name " + category.getName() + " already exists");
        } else {
            hairCareObject.setUser(getCurrentLoggedInUser());
            return hairCareRepository.save(hairCareObject);
        }
    }

    public Category getHairCategory(Long hairCategoryId) {
        System.out.println("service calling getHairCategory");
        Category category = hairCareRepository.findByIdAndUserId(HairCareService.getCurrentLoggedInUser().getId(), hairCategoryId);

        if (category == null) {
            throw new InformationNotFoundException("category not found for " + hairCategoryId);
        } else {
            return category;
        }
    }

    public Category updateHairCategory(Long hairCategoryId, Category hairCareObject) {
        System.out.println("service calling updateHairCategory");
        Category category = hairCareRepository.findByIdAndUserId(hairCategoryId, HairCareService.getCurrentLoggedInUser().getId());
            if (hairCareObject.equals(hairCareRepository.findByName(hairCareObject.getName()))){
                throw new InformationExistException("Category " + category.getName() + " already exists");
            } else {
                Category updateHairCategory = hairCareRepository.findHairCareCategoryById(hairCategoryId);
                updateHairCategory.setName(hairCareObject.getName());
                updateHairCategory.setDescription(hairCareObject.getDescription());
                updateHairCategory.setUser(HairCareService.getCurrentLoggedInUser());
                return hairCareRepository.save(updateHairCategory);
        }
    }


    public void deleteHairCategory(Long hairCategoryId) {
        System.out.println("service calling deleteHairCategory ==>");
        Optional<Category> category = hairCareRepository.findById(hairCategoryId);
        if (category.isPresent()) {
            hairCareRepository.delete(category.get());
        } else {
            throw new InformationNotFoundException("Category with id " + hairCategoryId + " not found ");
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

    public Accessories createAccessories(Long hairCategoryId, Accessories accessoryObject) {
        System.out.println("service calling createAccessories ==>");
        try {
            Optional<Category> category = hairCareRepository.findById(hairCategoryId);
            accessoryObject.setCategory(category.get());
            return accessoriesRepository.save(accessoryObject);
        } catch (NoSuchElementException e) {
            throw new InformationNotFoundException("category with id " + hairCategoryId + " not found");
        }
    }

    public Accessories getAccessory(Long hairCategoryId, Long accessoryId) {
        System.out.println("service calling getAccessory ==>");
        Accessories accessory = accessoriesRepository.findAccessoriesById(accessoryId);

        if (accessory == null) {
            throw new InformationNotFoundException("Accessory not found for category " + hairCategoryId + " and accessoryId " + accessoryId);
        } else {
            return accessory;
        }
    }

    public Accessories updateAccessory(Long hairCategoryId, Long accessoryId, Accessories accessoryObject) {
        Accessories accessory = getAccessory(hairCategoryId, accessoryId);
        if (accessoryObject.equals(accessoriesRepository.findByName(accessoryObject.getName()))){
            throw new InformationExistException("Accessory " + accessory.getName() + " already exists");
        } else {
            accessory.setName(accessoryObject.getName());
            accessory.setDescription(accessoryObject.getDescription());
            accessory.setRating(accessoryObject.getRating());
            return accessoriesRepository.save(accessory);
        }
    }

    public void deleteAccessory(Long categoryId, Long accessoryId) {
        System.out.println("calling deleteAccessory ==>");
        try {
            Optional<Accessories> accessory = accessoriesRepository.findById(accessoryId);
            if (accessory.isPresent() && accessory.get().getCategory().getId().equals(categoryId)) {
                accessoriesRepository.delete(accessory.get());
            } else {
                throw new InformationNotFoundException("accessory with id " + accessoryId + " not found in category " + categoryId);
            }
        } catch (EmptyResultDataAccessException e) {
            throw new InformationNotFoundException("accessory with id " + accessoryId + " not found in category " + categoryId);
        }
    }
}
