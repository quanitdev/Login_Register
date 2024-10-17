//package quan.dev.data.model;
//
//public class User {
//	public int id;
//	public String email;
//	public String role;
//	public String password;
//	public User(int id, String email, String role, String password) {
//		super();
//		this.id = id;
//		this.email = email;
//		this.role = role;
//		this.password = password;
//	}
//	
//}
package quan.dev.data.model;
import java.util.List;

import quan.dev.data.dao.Database;
import quan.dev.data.dao.DatabaseDao;

public class User {
	private int id;
    private String email;
    private String password;
    private String role;
    
    public User(String email, String password, String role) {
        super();
        this.email = email;
        this.password = password;
        this.role = role;
    }
    public User(int id, String email, String password, String role) {
        super();
        this.id = id;
        this.email = email;
        this.password = password;
        this.role = role;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public Order order() {
        return Database.getInstance().getOrderDao().find(id);
    }
        
        public List<Order> getOrders() {
        return DatabaseDao.getInstance().getOrderDao().findByUser(id);
    }
}
	
	