package com.apd.workshop02.models;

import java.util.HashMap;
import java.util.Map;

// ===== ADMIN CLASS =====
public class Admin {
    private static Map<String, Applicant> applicants = new HashMap<>();

    private Admin() {}

    public static void addApplicant(Applicant applicant) {
        applicants.put(applicant.getName(), applicant);
    }

    public static Applicant getApplicant(String name) {
        return applicants.get(name);
    }

    public static void removeApplicant(String name) {
        applicants.remove(name);
    }

    public static Map<String, Applicant> getAllApplicants() {
        return applicants;
    }
}