package com.mrcruz.bikestore.controllertest;




import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.mrcruz.bikestore.controller.ProductController;
import com.mrcruz.bikestore.repository.ProductRepository;
import com.mrcruz.bikestore.service.ProductService;





@RunWith(SpringRunner.class)
@WebMvcTest(controllers = ProductController.class)
public class ProductControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	
	
	
	@MockBean
	ProductRepository productRepository;
	
	@MockBean
	ProductService productService;
	/*
	 * 
	 @Autowired
	private ProductController productController;
	
	
	
	@BeforeEach
	public void setup() {
		standaloneSetup(this.productController);
	}
	*/
	
	@Test
	public void mustReturnSuccessWhenGetProduct() throws Exception {
		
		mockMvc
			.perform(MockMvcRequestBuilders.get("/api/bikes"))
			.andExpect(MockMvcResultMatchers.status().isOk());
	}
	


}
