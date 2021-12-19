package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TeamService {

    private static List<Team> listOfTeams;
    private static final JobService jobService = new JobService();

    private static Map<Long, String> teams() {
        Map<Long, String> teams = new HashMap<>();
        teams.put(1L, "C++ Developers");
        teams.put(2L, "Java Developers");
        teams.put(3L, "Angular Developers");
        teams.put(4L, "dotNet Developers");
        teams.put(5L, "Android Developers");
        teams.put(6L, "Swift Developers");
        teams.put(7L, "Project Managers");
        teams.put(8L, "HR Managers");
        teams.put(9L, "Recruiters");
        return teams;
    }
    public TeamService() {
        listOfTeams = getTeamsList();
    }

    private List<Team> getTeamsList(){
        Map<Long, String> teams = teams();
        List<Team> auxTeamsList = new ArrayList<>();
        teams.forEach((teamId,teamName) -> {
            String jobTitle = getJobTitle(teamName);
            Job job = findJobByJobTitle(jobTitle);
            if (job != null) {
                auxTeamsList.add(new Team(teamId, teamName, job));
            }
        });
        return auxTeamsList;
    }

    private String getJobTitle(String teamName) {
        String jobTitle = "";
        if ("C++ Developers".equals(teamName)) {
            jobTitle = "C++ Developer";
        } else if ("Java Developers".equals(teamName)) {
            jobTitle = "Java Developer";
        } else if ("Angular Developers".equals(teamName)) {
            jobTitle = "Angular Developer";
        } else if ("dotNet Developers".equals(teamName)) {
            jobTitle = "dotNet Developer";
        } else if ("Android Developers".equals(teamName)) {
            jobTitle = "Android Developer";
        } else if ("Swift Developers".equals(teamName)) {
            jobTitle = "Swift Developer";
        } else if ("Project Managers".equals(teamName)) {
            jobTitle = "Project Manager";
        } else if ("HR Managers".equals(teamName)) {
            jobTitle = "HR Manager";
        } else if ("Recruiters".equals(teamName)) {
            jobTitle = "Recruiter";
        }
        return jobTitle;
    }

    private static Job findJobByJobTitle(String jobTitle) {
        List<Job> jobs = jobService.getListOfJobs();
        Job jobToReturn = null;
        for (Job job : jobs) {
            if (job.getJobTitle().equals(jobTitle)) {
                jobToReturn = job;
            }
        }
        return jobToReturn;
    }

    public List<Team> getListOfTeams() {
        return listOfTeams;
    }

    public void setListOfJobs(List<Team> listOfTeams) {
        TeamService.listOfTeams = listOfTeams;
    }
}
