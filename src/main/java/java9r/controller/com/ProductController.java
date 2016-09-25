package java9r.controller.com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java9r.entities.com.Product;
import java9r.service.com.ProductService;

@RestController
@RequestMapping("product")
public class ProductController {
	@Autowired
	ProductService productService;  
	
 
	@RequestMapping(value = "/all/", method = RequestMethod.POST)
	public ResponseEntity<Void> createProduct(@RequestBody Product product, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating product " + product.getName());

		if (productService.isUserExist(product)) {
			System.out.println("A Product with name " + product.getName() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		productService.insertProduct(product);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/all/{id}").buildAndExpand(product.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	 

}
