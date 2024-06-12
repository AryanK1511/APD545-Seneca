package com.apd.workshop03.models;

import java.util.ArrayList;
import java.util.List;

// ===== APPLICANT CLASS =====
public class Applicant {
    private String name;
    private String phoneNumber;
    private final List<String> skills;
    private List<String> companies;
    private String jobRole;

    public Applicant(String name, String phoneNumber, String jobRole) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.skills = new ArrayList<>();
        this.jobRole = jobRole;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getCompanies() {
        return companies;
    }

    public void setCompanies(List<String> companies) {
        this.companies = companies;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void addSkill(String skill) {
        this.skills.add(skill);
    }

    public String getJobRole() {
        return jobRole;
    }

    public void setJobRole(String jobRole) {
        this.jobRole = jobRole;
    }
}
