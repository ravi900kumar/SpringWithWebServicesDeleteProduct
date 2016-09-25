package java9r.service.com;

import java9r.entities.com.Product;

 

public interface ProductService {
	 
	Product findByName(String name);
	
	void insertProduct(Product  product);
	public boolean isUserExist(Product product);
	 
}
