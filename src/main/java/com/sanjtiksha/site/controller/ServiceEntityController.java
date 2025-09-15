package com.sanjtiksha.site.controller;

import com.sanjtiksha.site.entity.ServiceEntity;
import com.sanjtiksha.site.repository.ServiceEntityRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services")
public class ServiceEntityController {

    private final ServiceEntityRepository serviceEntityRepository;

    public ServiceEntityController(ServiceEntityRepository serviceEntityRepository) {
        this.serviceEntityRepository = serviceEntityRepository;
    }

    // GET /api/services → list all
    @GetMapping
    public List<ServiceEntity> getAllServices() {
        return serviceEntityRepository.findAll();
    }

    // POST /api/services → add new
    @PostMapping
    public ServiceEntity createService(@RequestBody ServiceEntity service) {
        return serviceEntityRepository.save(service);
    }
}
