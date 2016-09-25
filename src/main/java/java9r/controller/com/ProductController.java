package java9r.controller.com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java9r.entities.com.Product;
import java9r.service.com.ProductService;

@RestController
@RequestMapping("product")
public class ProductController {
	@Autowired
	ProductService productService;  
	
 
	@RequestMapping(value = "/all/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> getProduct(@PathVariable("id") long id) {
		System.out.println("Fetching Product with id " + id);
		Product product = productService.findById(id);
		if (product == null) {
			System.out.println("Product with id " + id + " not found");
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
 
}
