package java9r.controller.com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
			
			//------------------- Delete a Product --------------------------------------------------------
			
			@RequestMapping(value = "/all/{id}", method = RequestMethod.DELETE)
			public ResponseEntity<Product> deleteProduct(@PathVariable("id") long id) {
				System.out.println("Fetching & Deleting Product with id " + id);

				Product user = productService.findById(id);
				if (user == null) {
					System.out.println("Unable to delete. Product with id " + id + " not found");
					return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
				}

				productService.deleteProductById(id);;
				return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
			}
			
			 

}
