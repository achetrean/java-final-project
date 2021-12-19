package com.company;

import java.time.LocalDate;
import java.util.Objects;

public class Employee {
    private String email;
    private long id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private LocalDate employmentDate;
    private String phoneNumber;
    private Job job;
    private boolean isTeamLeader;
    private String address;
    private String bio;
    private Team team;

    public Employee(String email, long id, String firstName, String lastName,
                    LocalDate birthDate, LocalDate employmentDate,
                    String phoneNumber, Job job, boolean isTeamLeader,
                    String address, String bio, Team team) {
        this.email = email;
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.employmentDate = employmentDate;
        this.phoneNumber = phoneNumber;
        this.job = job;
        this.isTeamLeader = isTeamLeader;
        this.address = address;
        this.bio = bio;
        this.team = team;
    }

    public Employee(String email, long id, String firstName, String lastName,
                    LocalDate birthDate, LocalDate employmentDate,
                    String phoneNumber, Job job, boolean isTeamLeader,
                    String address, String bio) {
        this.email = email;
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.employmentDate = employmentDate;
        this.phoneNumber = phoneNumber;
        this.job = job;
        this.isTeamLeader = isTeamLeader;
        this.address = address;
        this.bio = bio;
    }

    public Employee(){}

    public static Employee fromEmployeeDto(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setEmail(employeeDto.getEmail());
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setBirthDate(employeeDto.getBirthDate());
        employee.setEmploymentDate(employeeDto.getEmploymentDate());
        employee.setPhoneNumber(employeeDto.getPhoneNumber());
        employee.setIsTeamLeader(employeeDto.isTeamLeader());
        employee.setAddress(employeeDto.getAddress());
        employee.setBio(employeeDto.getBio());
        return employee;
    }

    public void displayEmployee() {
        System.out.println("====================================");
        System.out.println("Email: " + this.getEmail());
        System.out.println("Full name: " + this.getFirstName() + " " + this.getLastName());
        System.out.println("Phone number: " + this.getPhoneNumber());
        System.out.println("Birth date: " + this.getBirthDate());
        System.out.println("Employment date: " + this.getEmploymentDate());
        System.out.println("Address: " + this.getAddress());
        if (this.getBio().length() != 0) {
            System.out.println("Bio: " + this.getBio());
        }
        System.out.println("");
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(LocalDate employmentDate) {
        this.employmentDate = employmentDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public boolean isTeamLeader() {
        return isTeamLeader;
    }

    public void setIsTeamLeader(boolean teamLeader) {
        isTeamLeader = teamLeader;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee employee = (Employee) obj;
        return isTeamLeader == employee.isTeamLeader &&
                Objects.equals(firstName, employee.firstName) &&
                Objects.equals(lastName, employee.lastName) &&
                Objects.equals(birthDate, employee.birthDate) &&
                Objects.equals(employmentDate, employee.employmentDate) &&
                Objects.equals(phoneNumber, employee.phoneNumber) &&
                Objects.equals(job, employee.job) && Objects.equals(address, employee.address) &&
                Objects.equals(bio, employee.bio) && Objects.equals(team, employee.team);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, birthDate,
                employmentDate, phoneNumber, job,
                isTeamLeader, address, bio, team);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", employmentDate=" + employmentDate +
                ", phoneNumber='" + phoneNumber + '\'' +
                "\njob=" + job.getJobTitle() + '\'' +
                ", isTeamLeader=" + isTeamLeader +
                ", address='" + address + '\'' +
                ", bio='" + bio + '\'' +
                ", team=" + team.getTeamName()  + '\'' +
                '}';
    }
}
