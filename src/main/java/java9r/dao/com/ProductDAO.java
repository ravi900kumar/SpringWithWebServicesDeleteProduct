package java9r.dao.com;

import java.util.*;

import java9r.entities.com.Product;

 

 
public interface ProductDAO {
	
	

	Product findById(long id);
 
	void updateProduct(Product product);
	 

}
