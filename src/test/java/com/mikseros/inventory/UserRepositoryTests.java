package com.mikseros.inventory;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.mikseros.inventory.user.Role;
import com.mikseros.inventory.user.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {

	@Autowired
	private UserRepository repo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateRoles() {
		Role roleAdmin = new Role("Administrator");
		Role roleEditor = new Role("Editor");
		Role roleVisitor = new Role("Visitor");
		
		entityManager.persist(roleAdmin);
		entityManager.persist(roleEditor);
		entityManager.persist(roleVisitor);
	}
}
