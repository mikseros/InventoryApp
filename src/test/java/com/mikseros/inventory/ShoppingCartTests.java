package com.mikseros.inventory;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.mikseros.inventory.product.Product;
import com.mikseros.inventory.shoppingcart.CartItem;
import com.mikseros.inventory.shoppingcart.CartItemRepository;
import com.mikseros.inventory.user.User;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class ShoppingCartTests {

	@Autowired
	private CartItemRepository repo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testAddItemFromDatabase() {
		Product product = entityManager.find(Product.class, 1);
		User user = entityManager.find(User.class, 1);
		
		CartItem item = new CartItem(1, product, user);
		
		repo.save(item);
	}
}
