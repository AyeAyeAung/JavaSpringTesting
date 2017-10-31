package com.jdc.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.jdc.jpa2.entity.Category;

public class CategoryTest2 {
	
	static EntityManagerFactory EMF;
	EntityManager em;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		EMF = Persistence.createEntityManagerFactory("jpa-tut2");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		EMF.close();
	}

	@Before
	public void setUp() throws Exception {
		em = EMF.createEntityManager();
	}

	@After
	public void tearDown() throws Exception {
		if(em.isOpen())
			em.close();
	}

	@Test
	public void test() {
		
		Category c = new Category();
		em.getTransaction().begin();
		em.persist(c);
		c.setName("A");
		em.getTransaction().commit();
		
		em.detach(c);
		
		em.getTransaction().begin();
		Category c1 = em.find(Category.class, 1);
		em.getTransaction().commit();
		
		assertTrue(em.contains(c1));

		em.clear();
		
		assertFalse(em.contains(c1));
		
		em.close();
		
		c1.getName();
	}

}
