package com.sip.ams;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import com.sip.ams.entities.Product;
import com.sip.ams.repositories.ProductRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@TestMethodOrder(OrderAnnotation.class)

public class ProductRepositoryTests {

	@Autowired
	private ProductRepository repo;

	@Test
	@Rollback(false)
	@Order(2)
	public void testCreateProduct() {
		Product savedProduct = repo.save(new Product("iPhone 13", 1500));
		assertThat(savedProduct.getId()).isGreaterThan(6);
	}

	@Test
	@Order(1)
	public void testListProducts() {
		List<Product> products = (List<Product>) repo.findAll();
		assertThat(products.size()).isGreaterThan(0);
	}
}
