package com.jdc.jpa2.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity
@SuppressWarnings("serial")
public class Price implements Serializable{

	@EmbeddedId
	private PricePK id;
	private double price;
	@ManyToOne
	@JoinColumn(insertable = false, updatable = false, name = "itemId")
	private Item item;
	
	public Price() {
		id = new PricePK();
		id.setRefDate(new Date());
	}

	public PricePK getId() {
		return id;
	}
	public void setId(PricePK id) {
		this.id = id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
		id.setItemId(item.getId());
	}
	
}
