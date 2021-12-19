package com.company;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static final TeamService teamService = new TeamService();
    private static final JobService jobService = new JobService();

    static List<EmployeeDto> employeesDto = new ArrayList<>();
    static List<Employee> employees = new ArrayList<>();
    static List<Team> teams = new ArrayList<>();

    public static void main(String[] args) {
        instantiateTeamsList();
        populateEmployeesDtoList();
        populateEmployeesList();
        populateTeams();
        System.out.println("\nAll employees' data: ");
        displayEmployees();
        System.out.println("\nAll teams' data: ");
        teams.forEach(team -> team.displayTeam());
    }

    public static void instantiateTeamsList() {
        teams = teamService.getListOfTeams();
    }

    public static void populateEmployeesList() {
        System.out.println("Populating employees list after filtering, any errors will be displayed below ");
        int employeesCounter = 0;
        for (EmployeeDto employeeDto : employeesDto) {
            Job job = findJobByJobTitle(employeeDto.getJobTitle());
            if (job != null) {
                Employee employee = Employee.fromEmployeeDto(employeeDto);
                if (isEmailValid(employee.getEmail())) {
                    if (!isEmailFound(employee.getEmail())) {
                        employee.setId(++employeesCounter);
                        employee.setJob(job);
                        employees.add(employee);
                    } else {
                        System.out.println("Employee with email " + employee.getEmail() + " already exists");
                    }
                } else {
                    System.out.println("Email: " + employee.getEmail() + " for employee " +
                            employee.getFirstName() + " " + employee.getLastName() + " is not valid");
                }
            } else {
                System.out.println("Job title for " + employeeDto.getFirstName() + " " + employeeDto.getLastName() +
                        " was set wrong: " + employeeDto.getJobTitle());
            }
        }
        System.out.println("");
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

    private static void populateTeams() {
        System.out.println("Populating list of teams ");
        for (Team team : teams) {
            String teamJobTitle = team.getJob().getJobTitle();
            List<Employee> teamMembers = new ArrayList<>();
            for (Employee employee : employees) {
                if (employee.getJob().getJobTitle().equals(teamJobTitle)) {
                    teamMembers.add(employee);
                }
            }
            if (teamMembers.size() != 0) {
                team.setTeamMembers(teamMembers);
                for (Employee employee : teamMembers) {
                    employee.setTeam(team);
                }
                Employee teamLeader = teamMembers.get(0);
                for (int i = 1; i < teamMembers.size(); i++) {
                    if (teamMembers.get(i).getEmploymentDate().isBefore(teamLeader.getEmploymentDate())) {
                        teamLeader = teamMembers.get(i);
                    }
                }
                teamLeader.setIsTeamLeader(true);
                team.setTeamLeader(teamLeader);
            }
        }
    }

    private static boolean isEmailFound(String email) {
        for (Employee employee : employees) {
            if (employee.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isEmailValid(String email) {
        Pattern pattern = Pattern.compile("^(.+)@(.+)$");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private static void displayEmployees() {
        for (Employee employee : employees) {
            employee.displayEmployee();
        }
    }


    public static void populateEmployeesDtoList() {
        System.out.println("Populating initial employees list for insertion filtering: ");
        employeesDto.add(new EmployeeDto("ionpantelei@gmail.com","Ion", "Pantelei",
                LocalDate.parse("1999-10-02"),LocalDate.parse("2019-08-11"),"+37368237497",
                "Java Developer", false, "str. Ginta Latina 1",""));
        employeesDto.add(new EmployeeDto("sergiumalcoci@gmail.com","Sergiu", "Malcoci",
                LocalDate.parse("1995-12-22"),LocalDate.parse("2020-01-03"),"+37360027147",
                "Angular Developer", false, "str. Bulgara 9/2",""));
        employeesDto.add(new EmployeeDto("iondemcencogmail.com","Ion", "Demcenco",
                LocalDate.parse("2000-06-02"),LocalDate.parse("2021-02-04"),"+37367752224",
                "Angular Developer", false, "str. Mircea cel Batran 24",""));
        employeesDto.add(new EmployeeDto("ionpantelei@gmail.com","Ion", "Pantelei",
                LocalDate.parse("1999-10-02"),LocalDate.parse("2019-08-11"),"+37368237497",
                "Java Developer", false, "str. Ginta Latina 1",""));
        employeesDto.add(new EmployeeDto("igorcasu@gmail.com","Igor", "Casu",
                LocalDate.parse("1998-09-12"),LocalDate.parse("2020-09-14"),"+37367319245",
                "C++ Developer", false, "str. Cogalniceanu 34",""));
        employeesDto.add(new EmployeeDto("eugensecara@gmail.com","Eugen", "Secara",
                LocalDate.parse("2000-09-30"),LocalDate.parse("2021-03-15"),"+37379822679",
                "QA Engineer", false, "str. Deleanu 24",""));
        employeesDto.add(new EmployeeDto("adrianpostica@gmail.com","Adrian", "Postica",
                LocalDate.parse("2000-08-10"),LocalDate.parse("2021-11-08"),"+37379372614",
                "dotNet Developer", false, "str. Armeana 54/4",""));
        employeesDto.add(new EmployeeDto("nicolaipetrenco@gmail.com","Nicolai", "Petrenco",
                LocalDate.parse("1992-02-15"),LocalDate.parse("2015-04-08"),"+37368237497",
                "Android Developer", false, "str. Andrei Doga 3",""));
        employeesDto.add(new EmployeeDto("maximcilibiu@gmail.com","Maxim", "Cilibiu",
                LocalDate.parse("2002-04-29"),LocalDate.parse("2021-04-01"),"+37368237497",
                "Swift Developer", false, "str. Tudor Vladimir. 17",""));
        employeesDto.add(new EmployeeDto("vladimirdimitrov@gmail.com","Vladimir", "Dimitrov",
                LocalDate.parse("1996-06-07"),LocalDate.parse("2016-09-21"),"+37367750009",
                "Project Manager", false, "str. Eugen Doga 23/3",""));
        employeesDto.add(new EmployeeDto("alinaursu@gmail.com","Alina", "Ursu",
                LocalDate.parse("1998-08-17"),LocalDate.parse("2019-05-11"),"+37367379141",
                "HR Manager", false, "str. Muncesti 33",""));
        employeesDto.add(new EmployeeDto("elenalupu@gmail.com","Elena", "Lupu",
                LocalDate.parse("1996-08-10"),LocalDate.parse("2018-06-12"),"+37368237497",
                "Recruiter", false, "str. Sarmisegetuza 18/1",""));
        employeesDto.add(new EmployeeDto("anatolmelnic@gmail.com","Anatol", "Melnic",
                LocalDate.parse("1996-09-12"),LocalDate.parse("2018-09-14"),"+37367319245",
                "C++ Developer", false, "str. Ginta Latina 34",""));
        employeesDto.add(new EmployeeDto("nichitamelnic@gmail.com","Nichita", "Melnic",
                LocalDate.parse("2000-10-02"),LocalDate.parse("2019-08-11"),"+37367676767",
                "Java Developer", false, "str. Cogalniceanu 1",""));
        employeesDto.add(new EmployeeDto("ioncristea@gmail.com","Ion", "Cristea",
                LocalDate.parse("1993-12-22"),LocalDate.parse("2018-01-03"),"+37360027147",
                "Angular Developer", false, "str. Armeana 9/2",""));
        employeesDto.add(new EmployeeDto("mirceavasilache@gmail.com","Mircea", "Vasilache",
                LocalDate.parse("1998-08-10"),LocalDate.parse("2019-11-08"),"+37379372614",
                "dotNet Developer", false, "str. Bulgara 54/4",""));
        employeesDto.add(new EmployeeDto("vasilerusu@gmail.com","Vasile", "Rusu",
                LocalDate.parse("1990-02-15"),LocalDate.parse("2013-04-08"),"+37368237497",
                "Android Developer", false, "str. Tudor Vladimir. 3",""));
        employeesDto.add(new EmployeeDto("maximdadu@gmail.com","Maxim", "Dadu",
                LocalDate.parse("2000-04-29"),LocalDate.parse("2019-04-01"),"+37368237497",
                "Swift Developer", false, "str. Andrei Doga 17",""));
        employeesDto.add(new EmployeeDto("stepanporcescu@gmail.com","Stepan", "Porcescu",
                LocalDate.parse("1994-06-07"),LocalDate.parse("2014-09-21"),"+37367750009",
                "Project Manager", false, "str. Muncesti 23/3",""));
        employeesDto.add(new EmployeeDto("iuliamihalas@gmail.com","Iulia", "Mihalas",
                LocalDate.parse("1996-08-17"),LocalDate.parse("2017-05-11"),"+37367379141",
                "HR Manager", false, "str. Eugen Doga 33",""));
        employeesDto.add(new EmployeeDto("dorinaursu@gmail.com","Dorina", "Ursu",
                LocalDate.parse("1994-08-10"),LocalDate.parse("2016-06-12"),"+37368237497",
                "Recruiter", false, "str. Calea Iesilor 18/1",""));
        employeesDto.add(new EmployeeDto("dumitrumunteanu@gmail.com","Dumitru", "Munteanu",
                LocalDate.parse("2001-05-01"),LocalDate.parse("2020-09-14"),"+37367319245",
                "C++ Developer", false, "str. Trandafirilor 3",""));
        employeesDto.add(new EmployeeDto("andreicegolea@gmail.com","Andrei", "Cegolea",
                LocalDate.parse("2001-10-02"),LocalDate.parse("2021-08-11"),"+37367676767",
                "Java Developer", false, "str. Tighina 24",""));
        employeesDto.add(new EmployeeDto("eugenpostica@gmail.com","Eugen", "Postica",
                LocalDate.parse("1994-12-22"),LocalDate.parse("2020-01-03"),"+37360027147",
                "Angular Developer", false, "str. Armeana 9/2",""));
        employeesDto.add(new EmployeeDto("mihailungu@gmail.com","Mihai", "Lungu",
                LocalDate.parse("1999-08-10"),LocalDate.parse("2020-11-08"),"+37379372614",
                "dotNet Developer", false, "str. Suvorov 50",""));
        employeesDto.add(new EmployeeDto("vladcaldarasan@gmail.com","Vlad", "Caldarasan",
                LocalDate.parse("1991-02-15"),LocalDate.parse("2014-04-08"),"+37368237497",
                "Android Developer", false, "str. Mircea Eliade 2",""));
        employeesDto.add(new EmployeeDto("adrianvizii@gmail.com","Adrian", "Vizii",
                LocalDate.parse("2001-04-29"),LocalDate.parse("2020-04-01"),"+37368237497",
                "Swift Developer", false, "str. Puschin 17",""));
        employeesDto.add(new EmployeeDto("cristipasecinic@gmail.com","Criti", "Pasecinic",
                LocalDate.parse("1995-06-07"),LocalDate.parse("2015-09-21"),"+37367750009",
                "Project Manager", false, "str. Uzinelor 20",""));
        employeesDto.add(new EmployeeDto("victoriabadasco@gmail.com","Victoria", "Badasco",
                LocalDate.parse("1997-08-17"),LocalDate.parse("2018-05-11"),"+37367379141",
                "HR Manager", false, "str. Stefan cel Mare 40",""));
        employeesDto.add(new EmployeeDto("marianicorici@gmail.com","Maria", "Nicorici",
                LocalDate.parse("1995-08-10"),LocalDate.parse("2017-06-12"),"+37368237497",
                "Recruiter", false, "str. Sperantei 23",""));
        System.out.println("");
    }
}
