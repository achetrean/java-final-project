package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JobService {
    private static List<Job> listOfJobs;
    private static Map<Long, String> jobs() {
        Map<Long, String> jobs = new HashMap<>();
        jobs.put(1L, "C++ Developer");
        jobs.put(2L, "Java Developer");
        jobs.put(3L, "Angular Developer");
        jobs.put(4L, "dotNet Developer");
        jobs.put(5L, "Android Developer");
        jobs.put(6L, "Swift Developer");
        jobs.put(7L, "Project Manager");
        jobs.put(8L, "HR Manager");
        jobs.put(9L, "Recruiter");
        return jobs;
    }
    public JobService() {
        listOfJobs = getJobsList();
    }

    private List<Job> getJobsList(){
        Map<Long, String> jobs = jobs();
        List<Job> auxJobsList = new ArrayList<>();
        jobs.forEach((jobId,jobTitle) -> {
            auxJobsList.add(new Job(jobId,jobTitle));
        });
        return auxJobsList;
    }

    public List<Job> getListOfJobs() {
        return listOfJobs;
    }

    public void setListOfJobs(List<Job> listOfJobs) {
        JobService.listOfJobs = listOfJobs;
    }
}
