import Hibernate.Employee;
import Hibernate.EmployeeDao;
import Hibernate.EmployeeDaoImp;

public class Main {
    public static void main(String[] args) {
        EmployeeDao employeeDao = new EmployeeDaoImp();
        Employee employee = new Employee("Mark","m@gmail.com","male","test","test123",false);
        employeeDao.addEmployee(employee);

    }
}
