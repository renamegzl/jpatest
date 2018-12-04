package cn.com.taiji;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;


/**
 * The persistent class for the customers database table.
 * 
 */
@Entity
@Table(name="customers")
@NamedQuery(name="Customer.findAll", query="SELECT c FROM Customer c")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="first_name")
	private String firstName;
	@Id
	private int id;

	@Column(name="last_name")
	private String lastName;

	public Customer() {
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	//映射单向 1-n 的关联关系
		//使用 @OneToMany 来映射 1-n 的关联关系
		//使用 @JoinColumn 来映射外键列的名称
		//可以使用 @OneToMany 的 fetch 属性来修改默认的加载策略
		//可以通过 @OneToMany 的 cascade 属性来修改默认的删除策略. 
		//注意: 若在 1 的一端的 @OneToMany 中使用 mappedBy 属性, 则 @OneToMany 端就不能再使用 @JoinColumn 属性了. 
//		@JoinColumn(name="CUSTOMER_ID")
		@OneToMany(fetch=FetchType.LAZY,cascade={CascadeType.REMOVE},mappedBy="customer")
		public Set<Order> getOrders() {
			return getOrders();
		}


		//工具方法. 不需要映射为数据表的一列. 
		@Transient
		public String getInfo(){
			return "lastName: " + lastName;
		}

}