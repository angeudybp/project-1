package Hibernate;

public class DaoFactory {
    private static EmployeeDao employeeDao;
    private static ManagerDao managerDao;
    private static ReimbursementDao reimbursementDao;

    private DaoFactory(){

    }
    public static EmployeeDao getEmployeeDao(){
        if(employeeDao==null){
            employeeDao = new EmployeeDaoImp();
        }
        return employeeDao;
    }
    public static ManagerDao getManagerDao(){
        if(managerDao==null){
            managerDao = new ManagerDaoImp();
        }
        return managerDao;
    }
    public static ReimbursementDao getReimbursementDao(){
        if (reimbursementDao==null){
            reimbursementDao = new ReimbursementDaoImp();
        }
        return reimbursementDao;
    }

}
