package cn.com.taiji;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Test2 {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpaunit");
         EntityManager entityManager = entityManagerFactory.createEntityManager();
         EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        //add(entityManager);
        find(entityManager);
       // del(entityManager);
        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

        public static void add(EntityManager entityManager){

            Category c1 = new Category();
            c1.setCategoryName("c1");
            Category c2 = new Category();
            c2.setCategoryName("c2");
            Item i1 = new Item();
            i1.setItemName("i1");
            Item i2 = new Item();
            i2.setItemName("i2");
            i1.getCategories().add(c1);
            i1.getCategories().add(c2);
            c1.getItems().add(i1);
            c1.getItems().add(i2);
            entityManager.persist(c1);
            entityManager.persist(c2);
            entityManager.persist(i1);
            entityManager.persist(i2);
    }
    public static void find(EntityManager entityManager){
        Item item=entityManager.find(Item.class,1);
        System.err.println(item.getCategories().size());
        System.err.println(item.getItemName());
    }

}

