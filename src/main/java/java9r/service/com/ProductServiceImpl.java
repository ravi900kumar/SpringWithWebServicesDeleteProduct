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
	public Product findById(long id) {
 		return productDAO.findById(id);
	}
 
	 
	 
	@Override
	public void deleteProductById(long id) {
		productDAO.deleteProductById(id);
		
	}
	 

}
