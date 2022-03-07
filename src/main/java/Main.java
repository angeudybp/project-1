import Hibernate.*;

public class Main {
    public static void main(String[] args) {
        ManagerDao managerDao = new ManagerDaoImp();
        Manager manager = new Manager("Paul","p@gmail.com","ptest","ptest123",false);
        managerDao.addManager(manager);

    }
}
