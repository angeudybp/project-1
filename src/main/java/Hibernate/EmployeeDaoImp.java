package Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class EmployeeDaoImp implements EmployeeDao{

    @Override
    public void addEmployee(Employee employee) {
        SessionFactory factory = ConnectionFactory.getConfiguration().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(employee);
        transaction.commit();
        session.close();
    }

    @Override
    public void updateEmployee(Employee employee) {
        SessionFactory factory = ConnectionFactory.getConfiguration().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        session.update(employee);
        transaction.commit();
        session.close();


    }

    @Override
    public void deleteEmployee(int id) {

        SessionFactory factory = ConnectionFactory.getConfiguration().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(getEmployeeById(id));
        transaction.commit();
        session.close();

    }

    @Override
    public List<Employee> getEmployees() {
        List<Employee> employees;
        SessionFactory factory = ConnectionFactory.getConfiguration().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        employees = session.createQuery("from Employee",Employee.class).list();
        transaction.commit();
        session.close();

        return employees;
    }

    @Override
    public Employee getEmployeeById(int id) {
        SessionFactory factory = ConnectionFactory.getConfiguration().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        Employee employee = session.find(Employee.class,id);
        transaction.commit();
        session.close();

        return employee;
    }
}
