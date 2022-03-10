package Hibernate;

import java.util.List;

public interface ReimbursementDao {
    void addReimbursement(Reimbursement reimbursement, int id);
    void updateReimbursement(Reimbursement reimbursement);
    void deleteReimbursement(int id);
    List<Reimbursement> getReimbursement();
    Reimbursement getReimbursementById(int id);
}
