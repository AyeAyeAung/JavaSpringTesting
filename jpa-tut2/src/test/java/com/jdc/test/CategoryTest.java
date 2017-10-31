package com.jdc.test;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.jdc.jpa2.entity.Category;
import com.jdc.jpa2.repo.CategoryRepo;

public class CategoryTest {
	
	static EntityManagerFactory EMF;
	static EntityManager em;
	CategoryRepo repo;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		EMF = Persistence.createEntityManagerFactory("jpa-tut2");
		em = EMF.createEntityManager();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		em.close();
		EMF.close();
	}

	@Before
	public void setUp() throws Exception {
		repo = new CategoryRepo(em);
	}

	@Test
	public void test1() {
		Category c = new Category();
		c.setName("A");
		c.setDescription("B");
		
		repo.create(c);
		
		assertEquals(1, c.getId());
	}
	
	@Test
	public void test2() {
		Category c = repo.find(1);
		assertNotNull(c);
		
		assertNull(repo.find(2));
		
		assertEquals("A", c.getName());
		assertEquals("B", c.getDescription());
	}
	
	@Test
	public void test3() {
		Category c = repo.find(1);
		c.setDescription("Description");
		repo.update(c);
		
		c = repo.find(1);
		assertEquals("Description", c.getDescription());
	}
	
	@Test
	public void test4() {
		Category c = repo.find(1);
		repo.delete(c);
		
		assertNull(repo.find(1));
	}

}
