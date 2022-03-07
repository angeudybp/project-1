package Hibernate;

import java.util.List;

public interface EmployeeDao {
    void addEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployee(int id);
    List<Employee> getEmployees();
    Employee getEmployeeById(int id);
}
