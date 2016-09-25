package java9r.dao.com;

import java9r.entities.com.Product;

 

 
public interface ProductDAO {
	
	
	 
	Product findByName(String name);
	void insertProduct(Product  product);
	
	public boolean isUserExist(Product product);
	 

}
