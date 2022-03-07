package Hibernate;

public class DaoFactory {
    private static EmployeeDao employeeDao;
    private DaoFactory(){

    }
    public static EmployeeDao getEmployeeDao(){
        if (employeeDao==null){
            employeeDao = new EmployeeDaoImp();
        }
        return employeeDao;
    }

}
