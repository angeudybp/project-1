import Hibernate.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        EmployeeDao employeeDao = new EmployeeDaoImp();

        Reimbursement reimbursement = new Reimbursement(500,"pending",employeeDao.getEmployeeById(4));


        ReimbursementDao reimbursementDao = new ReimbursementDaoImp();

        reimbursementDao.addReimbursement(reimbursement,4);






    }
}
