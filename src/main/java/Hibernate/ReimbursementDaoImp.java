package Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class ReimbursementDaoImp implements ReimbursementDao{
    @Override
    public void addReimbursement(Reimbursement reimbursement) {
        SessionFactory factory = ConnectionFactory.getConfiguration().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(reimbursement);
        transaction.commit();
        session.close();
    }

    @Override
    public void updateReimbursement(Reimbursement reimbursement) {
        SessionFactory factory = ConnectionFactory.getConfiguration().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        session.update(reimbursement);
        transaction.commit();
        session.close();

    }

    @Override
    public void deleteReimbursement(int id) {
        SessionFactory factory = ConnectionFactory.getConfiguration().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(getReimbursementById(id));
        transaction.commit();
        session.close();

    }

    @Override
    public List<Reimbursement> getReimbursement() {
        List<Reimbursement> reimbursements;
        SessionFactory factory = ConnectionFactory.getConfiguration().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        reimbursements = session.createQuery("from Reimbursement",Reimbursement.class).list();
        transaction.commit();
        session.close();

        return reimbursements;
    }

    @Override
    public Reimbursement getReimbursementById(int id) {
        SessionFactory factory = ConnectionFactory.getConfiguration().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        Reimbursement reimbursement = session.find(Reimbursement.class,id);
        transaction.commit();
        session.close();

        return reimbursement;
    }
}
