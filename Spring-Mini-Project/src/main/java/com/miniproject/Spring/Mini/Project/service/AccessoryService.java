package com.miniproject.Spring.Mini.Project.service;

import com.miniproject.Spring.Mini.Project.model.Accessories;
import com.miniproject.Spring.Mini.Project.repository.AccessoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccessoryService {

    private AccessoriesRepository accessoriesRepository;

    @Autowired
    public void setAccessoriesRepository(AccessoriesRepository accessoriesRepository) {
        this.accessoriesRepository = accessoriesRepository;
    }

    public List<Accessories> getAccessories() {
        System.out.println("service calling getAccessories");
    }
}
