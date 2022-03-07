package Hibernate;

import java.util.List;

public interface ManagerDao {
    void addManager(Manager manager);
    void updateManager(Manager manager);
    void deleteManager(int id);
    List<Manager> getManagers();
    Manager getManagerById(int id);
}
