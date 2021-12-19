package com.company;

import java.time.LocalDate;
import java.util.Objects;

public class EmployeeDto {
    private String email;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private LocalDate employmentDate;
    private String phoneNumber;
    private String jobTitle;
    private boolean isTeamLeader;
    private String address;
    private String bio;

    public EmployeeDto(String email, String firstName, String lastName,
                       LocalDate birthDate, LocalDate employmentDate,
                       String phoneNumber, String jobTitle, boolean isTeamLeader,
                       String address, String bio) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.employmentDate = employmentDate;
        this.phoneNumber = phoneNumber;
        this.jobTitle = jobTitle;
        this.isTeamLeader = isTeamLeader;
        this.address = address;
        this.bio = bio;
    }

    public EmployeeDto(){}

    public static EmployeeDto fromEmployee(Employee employee) {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmail(employee.getEmail());
        employeeDto.setFirstName(employee.getFirstName());
        employeeDto.setLastName(employee.getLastName());
        employeeDto.setBirthDate(employee.getBirthDate());
        employeeDto.setEmploymentDate(employee.getEmploymentDate());
        employeeDto.setPhoneNumber(employee.getPhoneNumber());
        employeeDto.setJobTitle(employee.getJob().getJobTitle());
        employeeDto.setIsTeamLeader(employee.isTeamLeader());
        employeeDto.setAddress(employee.getAddress());
        employeeDto.setBio(employee.getBio());
        return employeeDto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeDto that = (EmployeeDto) o;
        return isTeamLeader == that.isTeamLeader &&
                Objects.equals(email, that.email) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(birthDate, that.birthDate) &&
                Objects.equals(employmentDate, that.employmentDate) &&
                Objects.equals(phoneNumber, that.phoneNumber) &&
                Objects.equals(jobTitle, that.jobTitle) &&
                Objects.equals(address, that.address) &&
                Objects.equals(bio, that.bio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, firstName, lastName, birthDate,
                employmentDate, phoneNumber, jobTitle, isTeamLeader, address, bio);
    }

}
