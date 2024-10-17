package quan.dev.data.dao;
import java.util.List;
import quan.dev.data.model.User;

public interface UserDao {

	public boolean insert(User user);
	public boolean update(User user);
	public boolean delete(int userId);
	public User find(int userId);
	public List<User> findAll();
        User find(String email, String password);
        User find(String email);
        User checkAccount(String email, String password);
}