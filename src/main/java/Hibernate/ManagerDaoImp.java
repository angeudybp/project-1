package Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class ManagerDaoImp implements ManagerDao{
    @Override
    public void addManager(Manager manager) {
        SessionFactory factory = ConnectionFactory.getConfiguration().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(manager);
        transaction.commit();
        session.close();
    }

    @Override
    public void updateManager(Manager manager) {
        SessionFactory factory = ConnectionFactory.getConfiguration().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        session.update(manager);
        transaction.commit();
        session.close();


    }

    @Override
    public void deleteManager(int id) {
        SessionFactory factory = ConnectionFactory.getConfiguration().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(getManagerById(id));
        transaction.commit();
        session.close();

    }

    @Override
    public List<Manager> getManagers() {
        List<Manager> managers;
        SessionFactory factory = ConnectionFactory.getConfiguration().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        managers= session.createQuery("from Manager",Manager.class).list();
        transaction.commit();
        session.close();

        return managers;
    }

    @Override
    public Manager getManagerById(int id) {
        SessionFactory factory = ConnectionFactory.getConfiguration().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        Manager manager = session.find(Manager.class,id);
        transaction.commit();
        session.close();

        return manager;
    }
}
