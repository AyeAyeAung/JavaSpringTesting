package com.jdc.jpa2.entity;

import com.jdc.jpa2.entity.Category;
import java.io.Serializable;
import java.lang.String;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Item implements Serializable {

	   
	@Id
	@GeneratedValue
	private int id;
	private String name;
	@Lob
	private String description;
	@ManyToOne
	private Category category;
	
	@OneToMany(mappedBy = "item")
	private List<Price> prices;
	
	@Transient
	private DateFormat df;
	
	private static final long serialVersionUID = 1L;

	public Item() {
		super();
		prices = new ArrayList<>();
		df = new SimpleDateFormat("yyyy-MM-dd");
	}   
	public int getId() {
		return this.id;
	}

	public List<Price> getPrices() {
		return prices;
	}
	public void setPrices(List<Price> prices) {
		this.prices = prices;
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
	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	public double getCurrentPrice() {
		String message = String.format("There is no price for %s", df.format(new Date()));
		return prices.stream()
				.filter(p -> p.getId().getRefDate().compareTo(new Date()) <= 0)
				.sorted((a,b) -> a.getId().getRefDate().compareTo(b.getId().getRefDate()))
				.map(a -> a.getPrice())
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException(message));
	}
	
	public double getPrice(Date date) {
		return prices.stream()
				.filter(p -> p.getId().getRefDate().compareTo(date) <= 0)
				.sorted((a,b) -> a.getId().getRefDate().compareTo(b.getId().getRefDate()))
				.map(a -> a.getPrice())
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException(
						String.format("There is no price for %s", df.format(date))));
	}
   
}
