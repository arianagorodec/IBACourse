package com.gorodeckaya.service.impl;


import com.gorodeckaya.entity.OrganizationStructure;
import com.gorodeckaya.repository.OrganizationStructureRepository;
import com.gorodeckaya.service.OrganizationStructureService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrganizationStructureServiceImpl implements OrganizationStructureService {
    @Autowired
    private OrganizationStructureRepository organizationStructureRepository;

    @Override
    public OrganizationStructure addOrganizationStructure(OrganizationStructure organizationStructure) {
        return organizationStructureRepository.saveAndFlush(organizationStructure);
    }

    @Override
    public void deleteById(long id) {
        organizationStructureRepository.deleteById(id);
    }

    @Override
    public OrganizationStructure getById(long id) {
        return organizationStructureRepository.findById(id);
    }

    @Override
    public OrganizationStructure getByDepartment(String name) {
        return organizationStructureRepository.findByDepartment(name);
    }
    @Override
    public OrganizationStructure getByPost(String name) {
        return organizationStructureRepository.findByPost(name);
    }

    @Override
    public OrganizationStructure getBySalary(double salary) {
        return organizationStructureRepository.findBySalary(salary);
    }

    @Override
    public OrganizationStructure editOrganizationStructure(OrganizationStructure organizationStructure) {
        return organizationStructureRepository.saveAndFlush(organizationStructure);
    }

    @Override
    public List<OrganizationStructure> getAll() {
        return organizationStructureRepository.findAll();
    }
}
