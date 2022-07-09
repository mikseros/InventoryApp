package com.mikseros.inventory;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.mikseros.inventory.user.Role;
import com.mikseros.inventory.user.User;
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
	
	@Test
	public void testCreateNewUserWithOneRole() {
		Role roleAdmin = entityManager.find(Role.class, 1);
		User user = new User("xxx@xxx.com", "123456");
		user.addRole(roleAdmin);
		
		repo.save(user);
	}
	
	@Test
	public void testCreateNewUserWithTwoRoles() {
		Role roleEditor = entityManager.find(Role.class, 2);
		Role roleVisitor = entityManager.find(Role.class, 3);
		User user = new User("xxx2@xxx.com", "123456");
		user.addRole(roleEditor);
		user.addRole(roleVisitor);
		
		repo.save(user);
	}
	
	@Test
	public void testAssignRoleToExistingUser() {
		User user = repo.findById(1).get();
		Role roleEditor = entityManager.find(Role.class, 2);
		
		user.addRole(roleEditor);
	}
}
