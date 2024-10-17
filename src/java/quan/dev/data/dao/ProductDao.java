package quan.dev.data.dao;

import java.util.List;

import quan.dev.data.model.Product;

public interface ProductDao {

	 public boolean insert(Product product);
	    public boolean update(Product product);
	    public boolean delete(int id);
	    public Product find(int id);
	    public List<Product> findAll();
	
}