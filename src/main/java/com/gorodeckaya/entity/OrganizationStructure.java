package com.gorodeckaya.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="organization_structure")

public class OrganizationStructure {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id_post", length = 11, nullable = false)
    private long id;

    @Column(name = "department")
    private String department;
    @Column(name = "post")
    private String post;
    @Column(name = "salary")
    private double salary;

    public OrganizationStructure() {
    }

    public OrganizationStructure(String department, String post, double salary) {
        this.department = department;
        this.post = post;
        this.salary = salary;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
