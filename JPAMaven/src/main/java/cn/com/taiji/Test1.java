package cn.com.taiji;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Test1 {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPAMaven");
         EntityManager entityManager = entityManagerFactory.createEntityManager();
         EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        add(entityManager);
       // find(entityManager);
//        del(entityManager);
        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    public static void add(EntityManager entityManager){
        Manager manager = new Manager();
        manager.setMgrName("AA");
        Department department = new Department();
        department.setDeptName("AA");
        manager.setDept(department);
        department.setMgr(manager);
        entityManager.persist(manager);
        entityManager.persist(department);
    }
    public static void find(EntityManager entityManager){
        final Department department = entityManager.find(Department.class, 1);
        System.err.println(department.getDeptName());
        System.err.println(department.getMgr().getMgrName());
    }
    public static void del(EntityManager entityManager){
        final Department department = entityManager.find(Department.class, 1);
        entityManager.remove(department);
        final Manager manager = entityManager.find(Manager.class, 2);
        entityManager.remove(manager);
    }
}

