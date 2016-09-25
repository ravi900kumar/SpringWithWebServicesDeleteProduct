package java9r.service.com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java9r.dao.com.ProductDAO;
import java9r.entities.com.Product;
 
@Service("productService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ProductServiceImpl implements ProductService{
	@Autowired
	ProductDAO productDAO;
	 
	@Override
	public Product findByName(String name) {
	 
		return productDAO.findByName(name);
	}
	@Override
	public void insertProduct(Product product) {
		productDAO.insertProduct(product);
		
	}
	@Override
	public boolean isUserExist(Product product) {
		 
		return productDAO.isUserExist(product);
	}
	 

}
