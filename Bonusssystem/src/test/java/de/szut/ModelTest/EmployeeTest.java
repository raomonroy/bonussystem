package de.szut.ModelTest;

import de.szut.Model.Employee;
import org.junit.jupiter.api.Test;

public class EmployeeTest {

    @Test
    public void testEmployee() {
        Employee employee = new Employee("John Doe", 5, 8, 10, 2, true);

        assert(employee.getName().equals("John Doe"));
        assert(employee.getYearsInCompany() == 5);
        assert(employee.getPerformanceScore() == 8);
        assert(employee.getCompletedProjects() == 10);
        assert(employee.getAbsenceDays() == 2);
        assert(employee.isTeamLeader());
    }

}
