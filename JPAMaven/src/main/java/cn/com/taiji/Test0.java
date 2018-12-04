package cn.com.taiji;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Test0 {

	public static void main(String[] args) {
		// 1. 创建EntityManagerFactory
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPAMaven");//跟项目名保持一致

		// 2. 创建EntityManager
		EntityManager entityManager = factory.createEntityManager();

		update(entityManager);
		

		// 6. 关闭EntityManager
		entityManager.close();

		// 7. 关闭EntityManagerFactory
		factory.close();
	}
	
	//添加用户
    public static  void addUser(EntityManager entityManager){
    
        // 3.开启事务
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
//        List<Customer> authorities = entityManager.createQuery("select  a from Customer a").getResultList();
    
        // 4. 持久化操作
        Customer customer=new Customer();
        customer.setFirstName("aaa111");
        customer.setId(111222);
        customer.setLastName("bbb111");
        // 添加customer到数据库，相当于hibernate的save();
        entityManager.persist(customer);
        // 5. 提交事务
        transaction.commit();
    }
    
    public static  void find(EntityManager entityManager){
        Order order = entityManager.find(Order.class,1);
        Customer customer = order.getCustomer();
        System.out.println(order.getOrderName());
        System.out.println(customer.getLastName());
    }
	
    public static void dele(EntityManager entityManager) {
		// 3.开启事务
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		// 4. 持久化操作
		// 通过Id查找并删除customer表的数据
		Customer customer = entityManager.find(Customer.class, 1);
		entityManager.remove(customer);

		// 5. 提交事务
		transaction.commit();
	}
    
//    public static void update(EntityManager entityManager) {
//    	// 3.开启事务
//    	EntityTransaction transaction = entityManager.getTransaction();
//    	transaction.begin();
//
//    	// 4. 持久化操作
//    	// 通过Id查找并删除Users表的数据
//    	Customer customer = entityManager.find(Customer.class, 2);
//    	customer.setFirstName("aaaaaa");
//    	customer.setId(10);
//    	customer.setLastName("bbbbbb");
//    	entityManager.persist(customer);
//    	// 5. 提交事务
//    	transaction.commit();
//    }

        public static void update(EntityManager entityManager){
            Order order =entityManager.find(Order.class,2);
            order.getCustomer().setId(99);
        }

}
