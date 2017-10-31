package com.jdc.jpa2.entity;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

@Entity
public class Category implements Serializable {

	   
	@Id
	@GeneratedValue
	private int id;
	private String name;
	@Lob
	private String description;
	private static final long serialVersionUID = 1L;

	public Category() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
   
}
