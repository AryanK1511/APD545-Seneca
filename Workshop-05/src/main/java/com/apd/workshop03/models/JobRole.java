package com.apd.workshop03.models;

// ===== JOB ROLE CLASS ======
public class JobRole {
    private final String jobName;
    private final String deadlineDate;
    private final String description;
    private final String requiredSkills;

    public JobRole(String jobName, String deadlineDate, String description, String requiredSkills) {
        this.jobName = jobName;
        this.deadlineDate = deadlineDate;
        this.description = description;
        this.requiredSkills = requiredSkills;
    }

    public String getJobName() {
        return jobName;
    }

    public String getDeadlineDate() {
        return deadlineDate;
    }

    public String getDescription() {
        return description;
    }

    public String getRequiredSkills() {
        return requiredSkills;
    }
}
