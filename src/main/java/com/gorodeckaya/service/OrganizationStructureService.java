package com.gorodeckaya.service;

import com.gorodeckaya.entity.OrganizationStructure;

import java.util.List;

public interface OrganizationStructureService {
    OrganizationStructure addOrganizationStructure(OrganizationStructure organizationStructure);
    void deleteById(long id);
    OrganizationStructure getById(long id);
    OrganizationStructure getByDepartment(String name);
    OrganizationStructure getByPost(String name);
    OrganizationStructure getBySalary(double salary);
    OrganizationStructure editOrganizationStructure(OrganizationStructure organizationStructure);
    List<OrganizationStructure> getAll();
}
