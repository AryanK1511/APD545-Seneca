package com.apd.workshop03.models;

import java.util.HashMap;
import java.util.Map;

// ===== HASHMAP CLASS =====
public class Hashmap {
    private static final Map<String, Applicant> applicants = new HashMap<>();

    private Hashmap() {
    }

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