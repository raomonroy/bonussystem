package de.szut.ModelTest;

import de.szut.Model.Employee;
import org.junit.jupiter.api.Test;

public class EmployeeTest {

    @Test
    public void testEmployee() {
        // Test the Employee class
        Employee employee = new Employee();
        employee.setName("John Doe");
        employee.setYearsInCompany(5);
        employee.setPerformanceScore(8);
        employee.setCompletedProjects(10);
        employee.setAbsenceDays(2);
        employee.setTeamLeader(true);

        assert(employee.getName().equals("John Doe"));
        assert(employee.getYearsInCompany() == 5);
        assert(employee.getPerformanceScore() == 8);
        assert(employee.getCompletedProjects() == 10);
        assert(employee.getAbsenceDays() == 2);
        assert(employee.isTeamLeader());
    }

}
