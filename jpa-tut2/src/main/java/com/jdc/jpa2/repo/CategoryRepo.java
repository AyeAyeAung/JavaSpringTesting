package com.jdc.jpa2.repo;

import javax.persistence.EntityManager;

import com.jdc.jpa2.entity.Category;

public class CategoryRepo implements Repository<Category> {

	private EntityManager em;
	
	public CategoryRepo(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public void create(Category t) {
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
	}

	@Override
	public Category find(Object id) {
		return em.find(Category.class, id);
	}

	@Override
	public void update(Category t) {
		em.getTransaction().begin();
		em.merge(t);
		em.getTransaction().commit();
	}

	@Override
	public void delete(Category t) {
		em.getTransaction().begin();
		em.merge(t);
		em.remove(t);
		em.getTransaction().commit();
	}

}
