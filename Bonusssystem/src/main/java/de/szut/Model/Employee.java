package de.szut.Model;

public class Employee {

    private String name;
    private int yearsInCompany;
    private int performanceScore;
    private int completedProjects;
    private int absenceDays;
    private boolean teamLeader;

    public Employee(String name, int yearsInCompany, int performanceScore, int completedProjects, int absenceDays, boolean teamLeader) {
        this.name = name;
        this.yearsInCompany = yearsInCompany;
        this.performanceScore = performanceScore;
        this.completedProjects = completedProjects;
        this.absenceDays = absenceDays;
        this.teamLeader = teamLeader;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearsInCompany() {
        return yearsInCompany;
    }

    public void setYearsInCompany(int yearsInCompany) {
        this.yearsInCompany = yearsInCompany;
    }

    public int getPerformanceScore() {
        return performanceScore;
    }

    public void setPerformanceScore(int performanceScore) {
        this.performanceScore = performanceScore;
    }

    public int getCompletedProjects() {
        return completedProjects;
    }

    public void setCompletedProjects(int completedProjects) {
        this.completedProjects = completedProjects;
    }

    public int getAbsenceDays() {
        return absenceDays;
    }

    public void setAbsenceDays(int absenceDays) {
        this.absenceDays = absenceDays;
    }

    public boolean isTeamLeader() {
        return teamLeader;
    }

    public void setTeamLeader(boolean teamLeader) {
        this.teamLeader = teamLeader;
    }
}
