package com.jdc.jpa2.repo;

import java.io.Serializable;

public interface Repository<T extends Serializable> {
	
	void create(T t);
	T find(Object id);
	void update(T t);
	void delete(T t);

}
