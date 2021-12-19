package com.company;

import java.util.List;
import java.util.Objects;

public class Team {
    private Long teamId;
    private String teamName;
    private Employee teamLeader;
    private List<Employee> teamMembers;
    private Job job;

    public Team(Long teamId, String teamName,
                Employee teamLeader,List<Employee> teamMembers,
                Job job) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.teamLeader = teamLeader;
        this.teamMembers = teamMembers;
        this.job = job;
    }

    public Team(Long teamId, String teamName, Job job) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.job = job;
    }

    public Team(){}

    public void displayTeam() {
        System.out.println("\n====================================");
        System.out.println("Team name:" + teamName);
        System.out.println("Each team member job title: " + job.getJobTitle());
        if (teamMembers != null) {
            System.out.println("Team leader full name: " + teamLeader.getFirstName() + " " + teamLeader.getLastName());
            System.out.println("Team members: ");
            for (Employee teamMember : teamMembers) {
                System.out.println(teamMember.toString());
            }
        }
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Employee getTeamLeader() {
        return teamLeader;
    }

    public void setTeamLeader(Employee teamLeader) {
        this.teamLeader = teamLeader;
    }

    public List<Employee> getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(List<Employee> teamMembers) {
        this.teamMembers = teamMembers;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Team team = (Team) obj;
        return Objects.equals(teamId, team.teamId) &&
                Objects.equals(teamName, team.teamName) &&
                Objects.equals(teamLeader, team.teamLeader) &&
                Objects.equals(teamMembers, team.teamMembers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teamId, teamName, teamLeader, teamMembers);
    }
}
